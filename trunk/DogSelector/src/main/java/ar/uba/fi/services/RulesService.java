package ar.uba.fi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import ar.uba.fi.model.Answer;
import ar.uba.fi.model.Breed;

public class RulesService {
	private static RulesService INSTANCE = new RulesService();
	
	private StatefulKnowledgeSession ksession;
	private KnowledgeAgent kagent;
	private KnowledgeBase kbase;
	private String breedId = null; //TODO soportar concurrencia
	private List<String> removedBreeds = new ArrayList<String>();
	private BreedService breedService = BreedService.getInstance();
	private Map<String, Integer> breedsPoints = null;
	
	private RulesService() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add( ResourceFactory.newClassPathResource( "breeds.drl" ), ResourceType.DRL );

		if ( kbuilder.hasErrors() ) {
		    System.err.println( kbuilder.getErrors().toString() );
		} else {
			System.out.println("base de conocimientos ok");
		}
		 this.kagent = KnowledgeAgentFactory.newKnowledgeAgent( "MyAgent" );
		 
         this.kbase = this.kagent.getKnowledgeBase();
         this.kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	}
	
	public static RulesService getInstance() {
		return INSTANCE;
	}
	
	public void createRuleSession() {
		this.ksession = this.kbase.newStatefulKnowledgeSession();
		this.breedId = null;
		this.removedBreeds = new ArrayList<String>();
		this.breedsPoints = new HashMap<String, Integer>();
	}
	
	public void terminateRuleSession() {
		if (this.ksession != null) {
			this.ksession.dispose();
		}
	}
	
	public void addAnswer(Answer answer) {
		this.ksession.insert(answer.getQuestion());
		this.ksession.insert(answer);
	}
	
	public int runAllRules() {
         return ksession.fireAllRules();
	}

	public String getBreedId() {
		return breedId;
	}

	public void setBreedId(String breedId) {
		this.breedId = breedId;
	}
	
	public void removePossibleBreed(String breedId) {
		this.removedBreeds.add(breedId);
		System.out.println("raza eliminada " + breedId);
	}
	
	public List<Breed> getPossibleBreeds() {
		Collection<Breed> allBreeds = this.breedService.getAllBreeds();
		List<Breed> possibleBreeds = new ArrayList<Breed>();
		
		for (Breed breed : allBreeds) {
			if (!this.removedBreeds.contains(breed.getId())) {
				possibleBreeds.add(breed);
			}
		}
		
		return possibleBreeds;
	}
	
	public void addPoints(String breedId, Integer points) {
		Integer breedPoints = this.getBreedPoints(breedId);
		breedPoints += points;
		this.breedsPoints.put(breedId, breedPoints);
	}
	
	public Integer getBreedPoints(String breedId) {
		Integer breedPoints = this.breedsPoints.get(breedId);
		if (breedPoints == null) {
			breedPoints = new Integer(0);
		}
		return breedPoints;
	}
	
	public List<Breed> getBreedsRanking() {
		Collection<Breed> allBreeds = this.breedService.getAllBreeds();
		List<Breed> breedsRanking = new ArrayList<Breed>();
		for (Breed breed : allBreeds) {
			breed.setPoints(this.getBreedPoints(breed.getId()));
			breedsRanking.add(breed);
		}
		Collections.sort(breedsRanking, new BreedComparator());
		
		return breedsRanking;
	}

	@Override
	protected void finalize() throws Throwable {
		this.terminateRuleSession();
		super.finalize();
	}
}
