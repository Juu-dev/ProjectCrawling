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
	public HistoricalEvent searchEvent (String input) {
		for (HistoricalEvent event: hisVNEvents) {
			if (event.getName().toLowerCase().contains(input.toLowerCase())) {
				return event;
			}
		}
		return null;
	}
}
