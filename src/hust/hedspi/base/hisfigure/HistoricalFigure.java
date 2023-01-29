package hust.hedspi.base.hisfigure;

import java.util.ArrayList;
import java.util.List;

public class HistoricalFigure {
	String name;
	String date;
	String content;
	List<String> historicalFigureList = new ArrayList<String>();
	String culturalFestival;
	String historicalEvents;
	Boolean isKing;
	String job;
	String nameDynasty;
	
	// Contructor
	public HistoricalFigure() {
		
	}
	
	public HistoricalFigure(String name, String content, Boolean isKing, String job) {
		super();
		this.name = name;
		this.content = content;
		this.isKing = isKing;
		this.job = job;
	}

	public HistoricalFigure(String name, String content, Boolean isKing, String job, String nameDynasty) {
		super();
		this.name = name;
		this.content = content;
		this.isKing = isKing;
		this.job = job;
		this.nameDynasty = nameDynasty;
	}
	
	public HistoricalFigure(String name, String date, String content, List<String> historicalFigureList,
			String culturalFestival, String historicalEvents, Boolean isKing, String job) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.historicalFigureList = historicalFigureList;
		this.culturalFestival = culturalFestival;
		this.historicalEvents = historicalEvents;
		this.isKing = isKing;
		this.job = job;
	}
	
	public HistoricalFigure(String name, String date, String content, List<String> historicalFigureList,
			String culturalFestival, String historicalEvents, Boolean isKing, String job, String nameDynasty) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.historicalFigureList = historicalFigureList;
		this.culturalFestival = culturalFestival;
		this.historicalEvents = historicalEvents;
		this.isKing = isKing;
		this.job = job;
		this.nameDynasty = nameDynasty;
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

	public List<String> getHistoricalFigureList() {
		return historicalFigureList;
	}

	public void setHistoricalFigureList(List<String> historicalFigureList) {
		this.historicalFigureList = historicalFigureList;
	}

	public String getCulturalFestival() {
		return culturalFestival;
	}

	public void setCulturalFestival(String culturalFestival) {
		this.culturalFestival = culturalFestival;
	}

	public String getHistoricalEvents() {
		return historicalEvents;
	}

	public void setHistoricalEvents(String historicalEvents) {
		this.historicalEvents = historicalEvents;
	}

	public Boolean getIsKing() {
		return isKing;
	}

	public void setIsKing(Boolean isKing) {
		this.isKing = isKing;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public String getNameDynasty() {
		return nameDynasty;
	}

	public void setNameDynasty(String nameDynasty) {
		this.nameDynasty = nameDynasty;
	}
}