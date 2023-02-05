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
	    boolean condition = site.getName() != null ? site.getName().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = site.getDate() != null ? site.getDate().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = site.getContent() != null ? site.getContent().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = site.getLocation() != null ? site.getLocation().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = site.getHisFigList() != null ? site.getHisFigList().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    return false;  
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
