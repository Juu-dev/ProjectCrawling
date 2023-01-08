package hust.hedspi.base;

import java.util.ArrayList;
import java.util.List;

public class CulturalFestival {
	String name;
	String date;
	String location;
	List<String> historicalFigure  = new ArrayList<String>(); 
	
	// Constructor
	public CulturalFestival(String name, String date, String location, List<String> historicalFigure) {
		super();
		this.name = name;
		this.date = date;
		this.location = location;
		this.historicalFigure = historicalFigure;
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

	public List<String> getHistoricalFigureList() {
		return historicalFigure;
	}

	public void setHistoricalFigureList(List<String> historicalFigure) {
		this.historicalFigure = historicalFigure;
	}
	
	// Methods
	void getData() {}
		
	
	
	
}