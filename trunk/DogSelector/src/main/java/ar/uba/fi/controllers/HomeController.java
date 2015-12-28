package ar.uba.fi.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.uba.fi.model.Answer;
import ar.uba.fi.model.Breed;
import ar.uba.fi.model.Question;
import ar.uba.fi.services.BreedService;
import ar.uba.fi.services.HouseSizeService;
import ar.uba.fi.services.QuestionsService;
import ar.uba.fi.services.RulesService;
import ar.uba.fi.view.AnswersDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private List<Question> questions;
	private RulesService rulesService;
	private HouseSizeService houseSizeService;
	private BreedService breedService;
	
	public HomeController() {
		// TODO injeccion de dependencias
		this.rulesService = RulesService.getInstance();
		this.questions = QuestionsService.getInstance().getQuestions();
		this.houseSizeService = HouseSizeService.getInstance();
		this.breedService = BreedService.getInstance();
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String root(Model model, HttpSession session) {
		return "redirect:/home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		List<Answer> answers = this.getAnswers(session);
		if (answers.size() == 0) {
			this.rulesService.createRuleSession();
		}
		
		if (answers.size() < this.questions.size()) {
			logger.info("question number " + (answers.size() + 1));
			
			Question currentQuestion = this.questions.get(answers.size());
			
			model.addAttribute("question", currentQuestion);
			model.addAttribute("answer", new Answer(answers.size()));
			model.addAttribute("possibleBreeds", this.rulesService.getPossibleBreeds());
			
			return currentQuestion.getPageName();
		} else {
			return "redirect:/showBreedsRanking";
		}
	}
	
	@RequestMapping(value="/answer", method=RequestMethod.POST)
	public String answer(Answer answer, Model model, HttpSession session) {
		List<Answer> answers = this.getAnswers(session);
		Question currentQuestion = this.questions.get(answers.size());
		
		answer.setQuestion(this.questions.get(answer.getQuestionIndex()));
		
		if (answer.getSelectedOptionDescription() == null) { // si vengo desde el map selection
			answer.setSelectedOptionDescription(currentQuestion.getOptions().get(new Integer(answer.getSelectedOptionValue())).getDescription());
		}
		
		logger.info("answer question " + (answer.getQuestionIndex() + 1) + ": " + answer.getSelectedOptionDescription());
		
		answers.add(answer);
		this.rulesService.addAnswer(answer);
		this.rulesService.runAllRules();
		
		if (this.rulesService.getBreedId() != null) {
			logger.info("Raza sugerida: " + this.rulesService.getBreedId());
			return "redirect:/showSuggestedBreed?breedId=" + this.rulesService.getBreedId();
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value="/showBreedInfo", method=RequestMethod.GET)
	public String showBreedInfo(String breedId, String previousPage, Model model) {
		Breed selectedBreed = this.breedService.getBreed(breedId);
		model.addAttribute("selectedBreed", selectedBreed);
		model.addAttribute("previousPage", previousPage);
		return "selected-breed";
	}
	
	@RequestMapping(value="/showSuggestedBreed", method=RequestMethod.GET)
	public String showSuggestedBreed(String breedId, Model model) {
		Breed selectedBreed = this.breedService.getBreed(breedId);
		model.addAttribute("selectedBreed", selectedBreed);
		return "suggested-breed";
	}
	
	@RequestMapping(value="/showBreedsRanking", method=RequestMethod.GET)
	public String showBreedsRanking(Model model) {
		Collection<Breed> breedsRanking = this.rulesService.getBreedsRanking();
		model.addAttribute("breedsRanking", breedsRanking);
		return "breeds-ranking";
	}
	
	@RequestMapping(value="/breedSelection", method=RequestMethod.GET)
	public String breedSelection(String breedId, Model model, HttpSession session) {
		Breed selectedBreed = this.breedService.getBreed(breedId);
		model.addAttribute("selectedBreed", selectedBreed);
		model.addAttribute("answersDTO", new AnswersDTO());
		
		Breed breedAnswers = new Breed();
		breedAnswers.setDogSize(this.getAnswerValue("dogSize", session));
		breedAnswers.setAnimals(this.getAnswerValue("animals", session));
		breedAnswers.setExercise(this.getAnswerValue("exercise", session));
		breedAnswers.setBark(this.getAnswerValue("bark", session));
		breedAnswers.setChildren(this.getAnswerValue("children", session));
		breedAnswers.setTimeAlone(this.getAnswerValue("timeAlone", session));
		breedAnswers.setProtection(this.getAnswerValue("protection", session));
		breedAnswers.setGarden(this.getAnswerValue("garden", session));
		breedAnswers.setHouseSize(this.getAnswerValue("houseSize", session));
		model.addAttribute("breedAnswers", breedAnswers);
		return "breed-selection";
	}
	
	@RequestMapping(value="/addAnswers", method=RequestMethod.POST)
	public String addAnswers(AnswersDTO answersDTO, Model model, HttpSession session) {
		List<Answer> answers = this.getAnswers(session);
		this.addAnswers(answersDTO, answers);
		return "redirect:/home";
	}
	
	private void addAnswers(AnswersDTO answersDTO, List<Answer> answers) {
		
	}
	
	private String getAnswerValue(String questionId, HttpSession session) {
		String answerValue = null;
		List<Answer> answers = this.getAnswers(session);
		for (Answer answer : answers) {
			if (answer.getQuestion().getId().equals(questionId)) {
				answerValue = answer.getSelectedOptionDescription();
				break;
			}
		}
		return answerValue;
	}
	
	@RequestMapping(value="/mapSelection", method=RequestMethod.POST)
	public String mapSelection(Answer answer, Model model, HttpSession session) {
		logger.info("answer question " + (answer.getQuestionIndex() + 1) + ": " + answer.getSelectedOptionValue());
		answer.setSelectedOptionDescription(answer.getSelectedOptionValue() + " - Tamaño casa: " + this.houseSizeService.getHouseSize(answer.getSelectedOptionValue()));
		return this.answer(answer, model, session);
	}
	
	@RequestMapping(value="/startOver", method=RequestMethod.GET)
	public String startOver(HttpSession session) {
		session.removeAttribute("answers");
		this.rulesService.terminateRuleSession();
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/deleteLastAnswer", method=RequestMethod.GET)
	public String deleteLastAnswer(HttpSession session) {
		List<Answer> answers = this.getAnswers(session);
		answers.remove(answers.size() - 1);
		// TODO sacarla de la base de connocimiento
		return "redirect:/home";
	}
	
	@SuppressWarnings("unchecked")
	private List<Answer> getAnswers(HttpSession session) {
		List<Answer> answers = (List<Answer>) session.getAttribute("answers");
		if (answers == null) {
			answers = new ArrayList<Answer>();
			session.setAttribute("answers", answers);
		}
		return answers;
	}
	
}
