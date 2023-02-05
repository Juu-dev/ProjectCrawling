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
		boolean condition = event.getName().toLowerCase().contains(input.toLowerCase());
		if (condition) return true;
		condition = event.getDate() != null ? event.getDate().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = event.getContent() != null ? event.getContent().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = event.getLocation() != null ? event.getLocation().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = event.getNameDynasty() != null ? event.getNameDynasty().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		condition = event.getHisFigList() != null ? event.getHisFigList().toLowerCase().contains(input.toLowerCase()) : false;
		if (condition) return true;
		return false;
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
