package hust.hedspi.base;

import java.util.ArrayList;
import java.util.List;

public class HistoricalEvents {
	String name;
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public String getContent() {
		return content;
	}
	public String getLocation() {
		return location;
	}
	public List<String> getHistoricalFigure() {
		return historicalFigure;
	}
	String date;
	String content;
	String location;
	List<String> historicalFigure = new ArrayList<String>();

	// Contructor
	public HistoricalEvents(String name, String date,String location, String content,  List<String> historicalFigure) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.location = location;
		this.historicalFigure = historicalFigure;
	}
	// Methods
	void getData() {
	}
	
}