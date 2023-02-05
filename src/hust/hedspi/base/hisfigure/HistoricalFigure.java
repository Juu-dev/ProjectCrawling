package hust.hedspi.base.hisfigure;

import java.util.ArrayList;
import java.util.List;

import hust.hedspi.base.culfestival.CulturalFestival;
import hust.hedspi.base.hissite.HistoricalSite;

public class HistoricalFigure {
	private String name;
	private String date;
	private String content;
	private List<CulturalFestival> listCulFestival  = new ArrayList<CulturalFestival>();
	private List<HistoricalSite> listHisSite  = new ArrayList<HistoricalSite>();
	private Boolean isKing;
	private String job;
	private String nameDynasty;
	
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
	
	public HistoricalFigure(String name, String date, String content, Boolean isKing, String job) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.isKing = isKing;
		this.job = job;
	}
	
	public HistoricalFigure(String name, String date, String content, Boolean isKing, String job, String nameDynasty) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
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

	public List<CulturalFestival> getListCulFestival() {
		return listCulFestival;
	}

	public void setListCulFestival(List<CulturalFestival> listCulFestival) {
		this.listCulFestival = listCulFestival;
	}

	public List<HistoricalSite> getListHisSite() {
		return listHisSite;
	}

	public void setListHisSite(List<HistoricalSite> listHisSite) {
		this.listHisSite = listHisSite;
	}
}