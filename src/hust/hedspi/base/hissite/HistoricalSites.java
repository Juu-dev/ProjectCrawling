package hust.hedspi.base.hissite;

import java.util.ArrayList;
import java.util.List;

public class HistoricalSites {
	List<HistoricalSite> hisVNSites = new ArrayList<HistoricalSite>();

	public List<HistoricalSite> getHisVNSites() {
		return hisVNSites;
	}

	public void setHisVNSites(List<HistoricalSite> hisVNSites) {
		this.hisVNSites = hisVNSites;
	}
	
	// Methods
	public void addElement(HistoricalSite site) {
		hisVNSites.add(site);
	}
	
	public List<HistoricalSite> searchSite (String input) {
		List<HistoricalSite> resutlSearch = new ArrayList<HistoricalSite>();
		
		for (HistoricalSite site: hisVNSites) {
			if (site.getName().toLowerCase().contains(input.toLowerCase())) {
				resutlSearch.add(site);
			}
		}
		return resutlSearch;
	}
}
