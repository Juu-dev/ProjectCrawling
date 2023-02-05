package hust.hedspi.base.hisevent;

import java.util.ArrayList;
import java.util.List;

public class HistoricalEvents {
	private List<HistoricalEvent> hisVNEvents = new ArrayList<HistoricalEvent>();

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
	
	public void addElement(List<HistoricalEvent> event) {
		hisVNEvents.addAll(event);
	}
	
	// Methods
	public boolean searchCondition(HistoricalEvent event, String input) {
		boolean condition1 = event.getName().toLowerCase().contains(input.toLowerCase());
		boolean condition2 = event.getDate().toLowerCase().contains(input.toLowerCase());
		boolean condition3 = event.getContent().toLowerCase().contains(input.toLowerCase());
		boolean condition4 = event.getLocation().toLowerCase().contains(input.toLowerCase());
		boolean condition5 = event.getNameDynasty().toLowerCase().contains(input.toLowerCase());
		boolean condition6 = event.getHisFigList().toLowerCase().contains(input.toLowerCase());
		
		return condition1 || condition2 || condition3 || condition4 || condition5 || condition6;  
	}
	
	public List<HistoricalEvent> searchEvent (String input) {
		List<HistoricalEvent> resultSearch = new ArrayList<HistoricalEvent>();
		
		for (HistoricalEvent event: hisVNEvents) {
			if (searchCondition(event, input)) {
				resultSearch.add(event);
			}
		}
		return resultSearch;
	}
}
