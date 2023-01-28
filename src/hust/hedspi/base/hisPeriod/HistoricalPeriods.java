package hust.hedspi.base.hisperiod;

import java.util.ArrayList;
import java.util.List;

public class HistoricalPeriods {
	List<HistoricalPeriod> hisVNPeriods = new ArrayList<HistoricalPeriod>();

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
}
