package ar.uba.fi.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.uba.fi.model.Breed;

public class BreedService {
	private static BreedService INSTANCE = new BreedService();
	
	private Map<String, Breed> breeds = new HashMap<String, Breed>();
	
	private BreedService() {
		this.breeds.put("beagle", this.getBeagle());
		this.breeds.put("golden-retriever", this.getGolden());
		this.breeds.put("bulldog", this.getBulldog());
		this.breeds.put("chihuahua", this.getChihuahua());
		this.breeds.put("cocker", this.getCocker());
		this.breeds.put("rottweiler", this.getRottweiler());
	}
	
	public static BreedService getInstance() {
		return INSTANCE;
	}
	
	public Breed getBreed(String breedId) {
		return this.breeds.get(breedId);
	}
	
	public Collection<Breed> getAllBreeds() {
		return this.breeds.values();
	}
	
	private Breed getBeagle() {
		Breed breed = new Breed("beagle", "Beagle");
		breed.setDogSize(QuestionsService.DOG_SIZE_OPTION_0);
		breed.setExercise(QuestionsService.EXERCISE_OPTION_1);
		breed.setBark(QuestionsService.BARK_OPTION_2);
		breed.setAnimals(QuestionsService.ANIMALS_OPTION_0);
		breed.setChildren(QuestionsService.CHILDREN_OPTION_2);
		breed.setTimeAlone(QuestionsService.TIME_ALONE_OPTION_1);
		breed.setProtection(QuestionsService.PROTECTION_OPTION_1);
		breed.setGarden(QuestionsService.GARDEN_OPTION_1);
		breed.setHouseSize(QuestionsService.HOUSE_SIZE_OPTION_1);
		return breed;
	}
	
	private Breed getGolden() {
		Breed breed = new Breed("golden-retriever", "Golden Retriever");
		breed.setDogSize(QuestionsService.DOG_SIZE_OPTION_1);
		breed.setExercise(QuestionsService.EXERCISE_OPTION_2);
		breed.setBark(QuestionsService.BARK_OPTION_1);
		breed.setAnimals(QuestionsService.ANIMALS_OPTION_2);
		breed.setChildren(QuestionsService.CHILDREN_OPTION_2);
		breed.setTimeAlone(QuestionsService.TIME_ALONE_OPTION_1);
		breed.setProtection(QuestionsService.PROTECTION_OPTION_0);
		breed.setGarden(QuestionsService.GARDEN_OPTION_2);
		breed.setHouseSize(QuestionsService.HOUSE_SIZE_OPTION_1);
		return breed;
	}
	
	private Breed getBulldog() {
		Breed breed = new Breed("bulldog", "Bulldog");
		breed.setDogSize(QuestionsService.DOG_SIZE_OPTION_1);
		breed.setExercise(QuestionsService.EXERCISE_OPTION_1);
		breed.setBark(QuestionsService.BARK_OPTION_0);
		breed.setAnimals(QuestionsService.ANIMALS_OPTION_1);
		breed.setChildren(QuestionsService.CHILDREN_OPTION_1);
		breed.setTimeAlone(QuestionsService.TIME_ALONE_OPTION_1);
		breed.setProtection(QuestionsService.PROTECTION_OPTION_2);
		breed.setGarden(QuestionsService.GARDEN_OPTION_1);
		breed.setHouseSize(QuestionsService.HOUSE_SIZE_OPTION_2);
		return breed;
	}
	
	private Breed getChihuahua() {
		Breed breed = new Breed("chihuahua", "Chihuahua");
		breed.setDogSize(QuestionsService.DOG_SIZE_OPTION_0);
		breed.setExercise(QuestionsService.EXERCISE_OPTION_0);
		breed.setBark(QuestionsService.BARK_OPTION_2);
		breed.setAnimals(QuestionsService.ANIMALS_OPTION_1);
		breed.setChildren(QuestionsService.CHILDREN_OPTION_0);
		breed.setTimeAlone(QuestionsService.TIME_ALONE_OPTION_1);
		breed.setProtection(QuestionsService.PROTECTION_OPTION_1);
		breed.setGarden(QuestionsService.GARDEN_OPTION_0);
		breed.setHouseSize(QuestionsService.HOUSE_SIZE_OPTION_0);
		return breed;
	}
	
	private Breed getCocker() {
		Breed breed = new Breed("cocker", "Cocker");
		breed.setDogSize(QuestionsService.DOG_SIZE_OPTION_0);
		breed.setExercise(QuestionsService.EXERCISE_OPTION_0);
		breed.setBark(QuestionsService.BARK_OPTION_1);
		breed.setAnimals(QuestionsService.ANIMALS_OPTION_2);
		breed.setChildren(QuestionsService.CHILDREN_OPTION_2);
		breed.setTimeAlone(QuestionsService.TIME_ALONE_OPTION_0);
		breed.setProtection(QuestionsService.PROTECTION_OPTION_0);
		breed.setGarden(QuestionsService.GARDEN_OPTION_1);
		breed.setHouseSize(QuestionsService.HOUSE_SIZE_OPTION_0);
		return breed;
	}
	
	private Breed getRottweiler() {
		Breed breed = new Breed("rottweiler", "Rottweiler");
		breed.setDogSize(QuestionsService.DOG_SIZE_OPTION_2);
		breed.setExercise(QuestionsService.EXERCISE_OPTION_2);
		breed.setBark(QuestionsService.BARK_OPTION_1);
		breed.setAnimals(QuestionsService.ANIMALS_OPTION_1);
		breed.setChildren(QuestionsService.CHILDREN_OPTION_1);
		breed.setTimeAlone(QuestionsService.TIME_ALONE_OPTION_1);
		breed.setProtection(QuestionsService.PROTECTION_OPTION_2);
		breed.setGarden(QuestionsService.GARDEN_OPTION_2);
		breed.setHouseSize(QuestionsService.HOUSE_SIZE_OPTION_2);
		return breed;
	}
}
