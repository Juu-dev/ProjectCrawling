package hust.hedspi.base.hissite;

import java.util.ArrayList;
import java.util.List;

public class HistoricalSites {
	private List<HistoricalSite> hisVNSites = new ArrayList<HistoricalSite>();

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
	
	public void addElement(List<HistoricalSite> site) {
		hisVNSites.addAll(site);
	}
	
	public boolean searchCondition(HistoricalSite site, String input) {
		boolean condition1 = site.getName().toLowerCase().contains(input.toLowerCase());
		boolean condition2 = site.getDate().toLowerCase().contains(input.toLowerCase());
		boolean condition3 = site.getContent().toLowerCase().contains(input.toLowerCase());
		boolean condition4 = site.getLocation().toLowerCase().contains(input.toLowerCase());
		boolean condition5 = site.getHisFigList().toLowerCase().contains(input.toLowerCase());
		
		return condition1 || condition2 || condition3 || condition4 || condition5;  
	}
	
	public List<HistoricalSite> searchSite (String input) {
		List<HistoricalSite> resutlSearch = new ArrayList<HistoricalSite>();
		
		for (HistoricalSite site: hisVNSites) {
			if (searchCondition(site, input)) {
				resutlSearch.add(site);
			}
		}
		return resutlSearch;
	}
}
