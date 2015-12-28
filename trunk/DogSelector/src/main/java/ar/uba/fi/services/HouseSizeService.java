package ar.uba.fi.services;

import java.util.HashMap;
import java.util.Map;

public class HouseSizeService {
	private static HouseSizeService INSTANCE = new HouseSizeService();
	private Map<String, String> houseSizes;
	
	private HouseSizeService() {
		this.houseSizes = new HashMap<String, String>();
		this.houseSizes.put("Buenos Aires", QuestionsService.HOUSE_SIZE_OPTION_0);
		this.houseSizes.put("Catamarca", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Chaco", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Chubut", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Cordoba", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Corrientes", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Entre Rios", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Formosa", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Jujuy", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("La Pampa", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("La Rioja", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Mendoza", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Misiones", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Neuquen", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Rio Negro", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Salta", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("San Juan", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("San Luis", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Santa Cruz", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Santa Fe", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Santiago del Estero", QuestionsService.HOUSE_SIZE_OPTION_1);
		this.houseSizes.put("Tierra del Fuego", QuestionsService.HOUSE_SIZE_OPTION_2);
		this.houseSizes.put("Tucuman", QuestionsService.HOUSE_SIZE_OPTION_1);
	}
	
	public static HouseSizeService getInstance() {
		return INSTANCE;
	}
	
	public String getHouseSize(String stateName) {
		return this.houseSizes.get(stateName);
	}
}
