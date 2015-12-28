package ar.uba.fi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.uba.fi.model.Question;

public class QuestionsService {
	private static QuestionsService INSTANCE = new QuestionsService();
	
	public static final String DOG_SIZE_OPTION_0 = "chico";
	public static final String DOG_SIZE_OPTION_1 = "mediano";
	public static final String DOG_SIZE_OPTION_2 = "grande";
	
	public static final String ANIMALS_OPTION_0 = "baja";
	public static final String ANIMALS_OPTION_1 = "media";
	public static final String ANIMALS_OPTION_2 = "alta";
	
	public static final String EXERCISE_OPTION_0 = "menos de 40 min";
	public static final String EXERCISE_OPTION_1 = "entre 40 min y 80 min";
	public static final String EXERCISE_OPTION_2 = "mas de 80 min";
	
	public static final String BARK_OPTION_0 = "baja";
	public static final String BARK_OPTION_1 = "media";
	public static final String BARK_OPTION_2 = "alta";
	
	public static final String CHILDREN_OPTION_0 = "no";
	public static final String CHILDREN_OPTION_1 = "masomenos";
	public static final String CHILDREN_OPTION_2 = "si";
	
	public static final String PROTECTION_OPTION_0 = "bajo";
	public static final String PROTECTION_OPTION_1 = "medio";
	public static final String PROTECTION_OPTION_2 = "alto";
	
	public static final String GARDEN_OPTION_0 = "no";
	public static final String GARDEN_OPTION_1 = "masomenos";
	public static final String GARDEN_OPTION_2 = "si";
	
	public static final String TIME_ALONE_OPTION_0 = "menos de 3 horas";
	public static final String TIME_ALONE_OPTION_1 = "entre 3 y 8 horas";
	public static final String TIME_ALONE_OPTION_2 = "mas de 8 horas";
	
	public static final String HOUSE_SIZE_OPTION_0 = "chica";
	public static final String HOUSE_SIZE_OPTION_1 = "mediana";
	public static final String HOUSE_SIZE_OPTION_2 = "grande";
	
	public static Map<String, Question> QUESTIONS;
	
	private QuestionsService() {
		QUESTIONS = new HashMap<String, Question>();
		QUESTIONS.put("dogSize", new Question("home", "dogSize", "¿cual es el tamaño de perro que esta buscando?", this.getDogSizeOptions()));
		QUESTIONS.put("animals", new Question("home","animals", "compatibilidad con animales requerida", this.getAnimalsOptions()));
		QUESTIONS.put("exercise", new Question("home","exercise", "¿cuanto tiempo por dia puede dedicar para ejercitar al perro?", this.getExerciseOptions()));
		QUESTIONS.put("bark", new Question("home","bark", "tendencia a ladrar", this.getBarkOptions()));
		QUESTIONS.put("children", new Question("home","children", "¿el perro estara en contacto con chicos?", this.getChildrenOptions()));
		QUESTIONS.put("timeAlone", new Question("home","timeAlone", "¿cual es el tiempo promedio que el perro va a estar solo?", this.getTimeAloneOptions()));
		QUESTIONS.put("protection", new Question("home","protection", "¿que nivel de proteccion esta buscando?", this.getProtectionOptions()));
		QUESTIONS.put("garden", new Question("home","garden", "¿el perro vivira en el jardin?", this.getGardenOptions()));
		QUESTIONS.put("houseSize", new Question("map", "houseSize", "¿donde va a vivir el perro?", this.getHouseSizeOptions()));
	}
	
	public static QuestionsService getInstance() {
		return INSTANCE;
	}
	
	public List<Question> getQuestions() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(QUESTIONS.get("dogSize"));
		questions.add(QUESTIONS.get("animals"));
		questions.add(QUESTIONS.get("exercise"));
		questions.add(QUESTIONS.get("bark"));
		questions.add(QUESTIONS.get("children"));
		questions.add(QUESTIONS.get("timeAlone"));
		questions.add(QUESTIONS.get("protection"));
		questions.add(QUESTIONS.get("garden"));
		questions.add(QUESTIONS.get("houseSize"));
		return questions;
	}
	
	private List<String> getDogSizeOptions() {
		List<String> options = new ArrayList<String>();
		options.add(DOG_SIZE_OPTION_0);
		options.add(DOG_SIZE_OPTION_1);
		options.add(DOG_SIZE_OPTION_2);
		return options;
	}
	
	private List<String> getAnimalsOptions() {
		List<String> options = new ArrayList<String>();
		options.add(ANIMALS_OPTION_0);
		options.add(ANIMALS_OPTION_1);
		options.add(ANIMALS_OPTION_2);
		return options;
	}
	
	private List<String> getExerciseOptions() {
		List<String> options = new ArrayList<String>();
		options.add(EXERCISE_OPTION_0);
		options.add(EXERCISE_OPTION_1);
		options.add(EXERCISE_OPTION_2);
		return options;
	}
	
	private List<String> getBarkOptions() {
		List<String> options = new ArrayList<String>();
		options.add(BARK_OPTION_0);
		options.add(BARK_OPTION_1);
		options.add(BARK_OPTION_2);
		return options;
	}
	
	private List<String> getChildrenOptions() {
		List<String> options = new ArrayList<String>();
		options.add(CHILDREN_OPTION_0);
		options.add(CHILDREN_OPTION_1);
		options.add(CHILDREN_OPTION_2);
		return options;
	}
	
	private List<String> getProtectionOptions() {
		List<String> options = new ArrayList<String>();
		options.add(PROTECTION_OPTION_0);
		options.add(PROTECTION_OPTION_1);
		options.add(PROTECTION_OPTION_2);
		return options;
	}
	
	private List<String> getGardenOptions() {
		List<String> options = new ArrayList<String>();
		options.add(GARDEN_OPTION_0);
		options.add(GARDEN_OPTION_1);
		options.add(GARDEN_OPTION_2);
		return options;
	}
	
	private List<String> getTimeAloneOptions() {
		List<String> options = new ArrayList<String>();
		options.add(TIME_ALONE_OPTION_0);
		options.add(TIME_ALONE_OPTION_1);
		options.add(TIME_ALONE_OPTION_2);
		return options;
	}
	
	private List<String> getHouseSizeOptions() {
		List<String> options = new ArrayList<String>();
		options.add(HOUSE_SIZE_OPTION_0);
		options.add(HOUSE_SIZE_OPTION_1);
		options.add(HOUSE_SIZE_OPTION_2);
		return options;
	}
	
}
