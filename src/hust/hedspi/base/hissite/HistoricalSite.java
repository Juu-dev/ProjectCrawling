package hust.hedspi.base.hissite;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class HistoricalSite {
	String name;
	String date;
	String content;
	String location;
	String culturalFestival;
	List<String> historicalFigure = new ArrayList<String>();
	List<HistoricalFigure> figuresList = new ArrayList<HistoricalFigure>();
	String historicalEvents;
	
	// Contructor
	public HistoricalSite() {}
	
	public HistoricalSite(String name, String date, String location) {
		super();
		this.name = name;
		this.date = date;
		this.location = location;
	}
	
	public HistoricalSite(String name, String date, String content, String location, String culturalFestival, String historicalEvents) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.location = location;
		this.culturalFestival = culturalFestival;
		this.historicalEvents = historicalEvents;
	}

	// Getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCulturalFestival() {
		return culturalFestival;
	}

	public void setCulturalFestival(String culturalFestival) {
		this.culturalFestival = culturalFestival;
	}

	public List<String> getHistoricalFigure() {
		return historicalFigure;
	}

	public void setHistoricalFigure(List<String> historicalFigure) {
		this.historicalFigure = historicalFigure;
	}

	public String getHistoricalEvents() {
		return historicalEvents;
	}

	public void setHistoricalEvents(String historicalEvents) {
		this.historicalEvents = historicalEvents;
	}
	
	public List<HistoricalFigure> getFiguresList() {
		return figuresList;
	}

	public void setFiguresList(List<HistoricalFigure> figuresList) {
		this.figuresList = figuresList;
	}

	// Methods
	void getData() {
		
	}
}
