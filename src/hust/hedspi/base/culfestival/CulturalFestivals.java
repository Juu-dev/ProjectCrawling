package hust.hedspi.base.culfestival;

import java.util.ArrayList;
import java.util.List;

public class CulturalFestivals {
	List<CulturalFestival> culVNFestivals  = new ArrayList<CulturalFestival>();

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
}
