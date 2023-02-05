package hust.hedspi.base.hisevent;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class HistoricalEvent {
	private String name;
	private String date;
	private String content;
	private String location;
	private String nameDynasty;
	private List<String> historicalFigure = new ArrayList<String>();
	private String hisFigList;
	private List<HistoricalFigure> figuresList = new ArrayList<HistoricalFigure>();

	// Contructor
	public HistoricalEvent() {}
	
	public HistoricalEvent(String name, String date, String content) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
	}
	
	public HistoricalEvent(String name, String date, String content, String nameDynasty) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.nameDynasty = nameDynasty;
	}
	
	public HistoricalEvent(String name, String date, String content, String location, List<String> historicalFigure) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.location = location;
		this.historicalFigure = historicalFigure;
	}

	public HistoricalEvent(String name, String date, String content, String location, List<String> historicalFigure,
			List<HistoricalFigure> figuresList) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.location = location;
		this.historicalFigure = historicalFigure;
		this.figuresList = figuresList;
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

	public List<String> getHistoricalFigure() {
		return historicalFigure;
	}

	public void setHistoricalFigure(List<String> historicalFigure) {
		this.historicalFigure = historicalFigure;
	}
	
	public String getNameDynasty() {
		return nameDynasty;
	}

	public void setNameDynasty(String nameDynasty) {
		this.nameDynasty = nameDynasty;
	}

	public String getHisFigList() {
		return hisFigList;
	}

	public void setHisFigList(String hisFigList) {
		this.hisFigList = hisFigList;
	}

	public List<HistoricalFigure> getFiguresList() {
		return figuresList;
	}

	public void setFiguresList(List<HistoricalFigure> figuresList) {
		this.figuresList = figuresList;
	}	
}