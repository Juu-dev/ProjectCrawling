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
	
	public HistoricalSite searchSite (String input) {
		for (HistoricalSite site: hisVNSites) {
			if (site.getName().toLowerCase().contains(input.toLowerCase())) {
				return site;
			}
		}
		return null;
	}
}
