package hust.hedspi.base;

import java.util.ArrayList;
import java.util.List;

public class HistoricalEvents {
	String name;
	String date;
	String content;
	String location;
	List<String> historicalFigure = new ArrayList<String>();

	// Contructor
	public HistoricalEvents(String name, String date, String content, String location, List<String> historicalFigure) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
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
	
	
	// Methods
	void getData() {
		
	}
	
}