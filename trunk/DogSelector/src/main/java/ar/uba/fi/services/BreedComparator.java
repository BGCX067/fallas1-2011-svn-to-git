package ar.uba.fi.services;

import java.util.Comparator;

import ar.uba.fi.model.Breed;

public class BreedComparator implements Comparator<Breed> {

	public int compare(Breed breed1, Breed breed2) {
		if (breed1.getPoints() > breed2.getPoints()) {
			return -1;
		} else if (breed1.getPoints().equals(breed2.getPoints())) {
			return 0;
		} else {
			return 1;
		}
	}

}
