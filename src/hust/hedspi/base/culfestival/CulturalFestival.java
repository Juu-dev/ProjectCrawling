package hust.hedspi.base.culfestival;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class CulturalFestival {
	String name;
	String date;
	String location;
	List<String> historicalFigures  = new ArrayList<String>(); 
	List<HistoricalFigure> figuresList = new ArrayList<HistoricalFigure>();
	
	// Constructor
	public CulturalFestival(String name, String date, String location, List<String> historicalFigures) {
		super();
		this.name = name;
		this.date = date;
		this.location = location;
		this.historicalFigures = historicalFigures;
	}

	public CulturalFestival(String name, String date, String location, List<String> historicalFigures,
			List<HistoricalFigure> figuresList) {
		super();
		this.name = name;
		this.date = date;
		this.location = location;
		this.historicalFigures = historicalFigures;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getHistoricalFiguresList() {
		return historicalFigures;
	}

	public void setHistoricalFiguresList(List<String> historicalFigures) {
		this.historicalFigures = historicalFigures;
	}
	
	// Methods
	void getData() {}
		
	
	
	
}