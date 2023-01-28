package hust.hedspi.base.hisevent;

import java.util.ArrayList;
import java.util.List;


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
}
