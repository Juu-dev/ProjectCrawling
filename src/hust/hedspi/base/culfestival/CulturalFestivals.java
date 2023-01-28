package hust.hedspi.base.culfestival;

import java.util.ArrayList;
import java.util.List;

public class CulturalFestivals {
	List<CulturalFestival> culVNFestivals  = new ArrayList<CulturalFestival>();

	// Getter and setter
	public List<CulturalFestival> getCulturalFestivals() {
		return culVNFestivals;
	}

	public void setCulturalFestivals(List<CulturalFestival> culVNFestivals) {
		this.culVNFestivals = culVNFestivals;
	}
	
	// Methods
	public void addElement(CulturalFestival cul) {
		culVNFestivals.add(cul);
	}
	
	public CulturalFestival searchFestival (String input) {
		for (CulturalFestival festival: culVNFestivals) {
			if (festival.getName().toLowerCase().contains(input.toLowerCase())) {
				return festival;
			}
		}
		return null;
	}
}
