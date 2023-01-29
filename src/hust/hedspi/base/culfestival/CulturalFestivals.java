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
	
	public List<CulturalFestival> searchFestival (String input) {
		List<CulturalFestival> resultSearch = new ArrayList<CulturalFestival>();
		
		for (CulturalFestival festival: culVNFestivals) {
			if (festival.getName().toLowerCase().contains(input.toLowerCase())) {
				resultSearch.add(festival);
			}
		}
		return resultSearch;
	}
}



