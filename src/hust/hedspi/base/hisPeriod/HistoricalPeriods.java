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
		boolean condition1 = period.getName().toLowerCase().contains(input.toLowerCase());
		boolean condition2 = period.getYear().toLowerCase().contains(input.toLowerCase());
		boolean condition3 = period.getContent().toLowerCase().contains(input.toLowerCase());
		
		return condition1 || condition2 || condition3;  
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
