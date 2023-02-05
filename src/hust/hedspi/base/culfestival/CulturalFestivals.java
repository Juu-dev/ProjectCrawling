package hust.hedspi.base.culfestival;

import java.util.ArrayList;
import java.util.List;

public class CulturalFestivals {
	private List<CulturalFestival> culVNFestivals  = new ArrayList<CulturalFestival>();

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
	
	public void addElement(List<CulturalFestival> cul) {
		culVNFestivals.addAll(cul);
	}
	
	public boolean searchCondition(CulturalFestival festival, String input) {
		boolean condition1 = festival.getName().toLowerCase().contains(input.toLowerCase());
		boolean condition2 = festival.getDate().toLowerCase().contains(input.toLowerCase());
		boolean condition3 = festival.getLocation().toLowerCase().contains(input.toLowerCase());
		boolean condition4 = festival.getHisFigList().toLowerCase().contains(input.toLowerCase());
		
		return condition1 || condition2 || condition3 || condition4;  
	}
	
	public List<CulturalFestival> searchFestival (String input) {
		List<CulturalFestival> resultSearch = new ArrayList<CulturalFestival>();
		
		for (CulturalFestival festival: culVNFestivals) {
			if (searchCondition(festival, input)) {
				resultSearch.add(festival);
			}
		}
		return resultSearch;
	}
}



