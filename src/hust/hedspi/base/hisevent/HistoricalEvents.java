package hust.hedspi.base.hisevent;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.hisperiod.HistoricalChildPeriod;


public class HistoricalEvents {
 	List<HistoricalEvent> hisVNEvents = new ArrayList<HistoricalEvent>();

	public List<HistoricalEvent> getHisVNEvents() {
		return hisVNEvents;
	}

	public void setHisVNEvents(List<HistoricalEvent> hisVNEvents) {
		this.hisVNEvents = hisVNEvents;
	}
 	
 	// Methods
	public void addElement(HistoricalEvent event) {
		hisVNEvents.add(event);
	}
	
	// Methods
	public List<HistoricalEvent> searchEvent (String input) {
		List<HistoricalEvent> resultSearch = new ArrayList<HistoricalEvent>();
		
		for (HistoricalEvent event: hisVNEvents) {
			if (event.getName().toLowerCase().contains(input.toLowerCase())) {
				resultSearch.add(event);
			}
		}
		return resultSearch;
	}
}
