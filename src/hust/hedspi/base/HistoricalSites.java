package hust.hedspi.base;

public class HistoricalSites {
	String name;
	String date;
	String content;
	String location;
	String culturalFestival;
	String historicalFigure;
	String historicalEvents;
	
	// Contructor
	public HistoricalSites(String name, String date, String content, String location, String culturalFestival,
			String historicalFigure, String historicalEvents) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.location = location;
		this.culturalFestival = culturalFestival;
		this.historicalFigure = historicalFigure;
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

	public String getHistoricalFigure() {
		return historicalFigure;
	}

	public void setHistoricalFigure(String historicalFigure) {
		this.historicalFigure = historicalFigure;
	}

	public String getHistoricalEvents() {
		return historicalEvents;
	}

	public void setHistoricalEvents(String historicalEvents) {
		this.historicalEvents = historicalEvents;
	}
	
	// Methods
	void getData() {
		
	}
}
