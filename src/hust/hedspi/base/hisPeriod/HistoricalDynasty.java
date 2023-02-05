package hust.hedspi.base.hisperiod;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisfigure.HistoricalFigure;

public class HistoricalDynasty {
	private String name;
	private String year;
	private String content;
	private String nameCountry;
	private List<HistoricalEvent> eventList = new ArrayList<HistoricalEvent>();
	private List<String> historicalKings;
	private String hisKingList;
	private List<HistoricalFigure> historicalFigures = new ArrayList<HistoricalFigure>();
	private String hisFigList;
	
	// Constructor
	public HistoricalDynasty() {}
	
	public HistoricalDynasty(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	public HistoricalDynasty(String name, String year, String content) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
	}
	
	public HistoricalDynasty(String name, String year, String content, String nameCountry) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
		this.nameCountry = nameCountry;
	}

	public HistoricalDynasty(String name, String year, String content, String nameCountry, List<String> historicalKings) {
		super();
		this.name = name;
		this.year = year;
		this.content = content;
        this.historicalKings = historicalKings;
        this.nameCountry = nameCountry;
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

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	
	public List<String> getHistoricalKings() {
		return historicalKings;
	}

	public void setHistoricalKings(List<String> historicalKings) {
		this.historicalKings = historicalKings;
	}

	public List<HistoricalEvent> getEventList() {
		return eventList;
	}

	public String getHisKingList() {
		return hisKingList;
	}

	public void setHisKingList(String hisKingList) {
		this.hisKingList = hisKingList;
	}

	public void setEventList(List<HistoricalEvent> eventList) {
		this.eventList = eventList;
	}

	public List<HistoricalFigure> getHistoricalFigures() {
		return historicalFigures;
	}

	public void setHistoricalFigures(List<HistoricalFigure> historicalFigures) {
		this.historicalFigures = historicalFigures;
	}

	public String getHisFigList() {
		return hisFigList;
	}

	public void setHisFigList(String hisFigList) {
		this.hisFigList = hisFigList;
	}
}