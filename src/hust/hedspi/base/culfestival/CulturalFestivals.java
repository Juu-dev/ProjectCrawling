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
	
	// support search
	public boolean searchCondition(CulturalFestival festival, String input) {
		boolean condition = festival.getName() != null ? festival.getName().toLowerCase().contains(input.toLowerCase()): false;
		if (condition) return true;
		condition = festival.getDate() != null ? festival.getDate().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = festival.getLocation() != null ? festival.getLocation().toLowerCase().contains(input.toLowerCase()) : false ;
		if (condition) return true;
		condition = festival.getHisFigList() != null ? festival.getHisFigList().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		return false;  
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



