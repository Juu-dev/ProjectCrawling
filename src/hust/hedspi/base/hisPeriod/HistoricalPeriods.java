package hust.hedspi.base.hisperiod;

import java.util.ArrayList;
import java.util.List;

public class HistoricalPeriods {
	private List<HistoricalPeriod> hisVNPeriods = new ArrayList<HistoricalPeriod>();

	public List<HistoricalPeriod> getHisVNPeriods() {
		return hisVNPeriods;
	}

	public void setHisVNPeriods(List<HistoricalPeriod> hisVNPeriods) {
		this.hisVNPeriods = hisVNPeriods;
	}
	
	// Methods
	public void addElement(HistoricalPeriod per) {
		hisVNPeriods.add(per);
	}
	
	public void addElement(List<HistoricalPeriod> per) {
		hisVNPeriods.addAll(per);
	}
	
	public boolean searchCondition(HistoricalPeriod period, String input) {
		boolean condition = period.getName() != null ? period.getName().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = period.getYear() != null ? period.getYear().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = period.getContent() != null ? period.getContent().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		
		return false;  
	}
	
	public List<HistoricalPeriod> searchPeriod(String input) {
		List<HistoricalPeriod> resultSearch = new ArrayList<HistoricalPeriod>();
		
		for (HistoricalPeriod period: hisVNPeriods) {
			if (searchCondition(period, input)) {
				resultSearch.add(period);
			}
		}
		return resultSearch;
	}
}
