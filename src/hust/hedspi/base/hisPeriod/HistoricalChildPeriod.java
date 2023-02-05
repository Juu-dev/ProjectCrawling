package hust.hedspi.base.hisperiod;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisfigure.HistoricalFigure;

public class HistoricalChildPeriod {
	private String name;
	private String year;
	private String content;
	private List<HistoricalEvent> eventList = new ArrayList<HistoricalEvent>();
	private List<HistoricalFigure> figureList = new ArrayList<HistoricalFigure>();
	private List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
	// Constructor
	public HistoricalChildPeriod() {}
	
	public HistoricalChildPeriod(String name) {
		super();
		this.name = name;
	}
	
	public HistoricalChildPeriod(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
	
	public HistoricalChildPeriod(String name, String year, String content) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
	}

	// Getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public List<HistoricalDynasty> getDynastyList() {
		return dynastyList;
	}

	public void setDynastyList(List<HistoricalDynasty> dynastyList) {
		this.dynastyList = dynastyList;
	}

	public List<HistoricalEvent> getEventList() {
		return eventList;
	}

	public void setEventList(List<HistoricalEvent> eventList) {
		this.eventList = eventList;
	}

	public List<HistoricalFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<HistoricalFigure> figureList) {
		this.figureList = figureList;
	}

	// Methods
	public boolean searchCondition(HistoricalDynasty dynasty, String input) {
	    boolean condition = dynasty.getName() != null ? dynasty.getName().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = dynasty.getYear() != null ? dynasty.getYear().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = dynasty.getContent() != null ? dynasty.getContent().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = dynasty.getNameCountry() != null ? dynasty.getNameCountry().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = dynasty.getHisKingList() != null ? dynasty.getHisKingList().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    condition = dynasty.getHisFigList() != null ? dynasty.getHisFigList().toLowerCase().contains(input.toLowerCase()) : false;
	    if (condition) return true;
	    return false;  
	}
	
	public List<HistoricalDynasty> searchDynasty(String input) {
		List<HistoricalDynasty> resultSearch = new ArrayList<HistoricalDynasty>();
		
		for (HistoricalDynasty dynasty: dynastyList) {
			if (searchCondition(dynasty, input)) {
				resultSearch.add(dynasty) ;
			}
		}
		return resultSearch;
	}

	
}
