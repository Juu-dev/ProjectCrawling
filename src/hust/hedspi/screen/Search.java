package hust.hedspi.screen;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalDynasty;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.base.hisperiod.HistoricalPeriods;
import hust.hedspi.base.hissite.HistoricalSite;
import hust.hedspi.base.hissite.HistoricalSites;
import hust.hedspi.base.culfestival.CulturalFestival;
import hust.hedspi.base.culfestival.CulturalFestivals;
import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisevent.HistoricalEvents;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.base.hisfigure.HistoricalFigures;


public class Search {
	HistoricalPeriods hisPeriods = new HistoricalPeriods();
	HistoricalEvents hisEvents = new HistoricalEvents();
	CulturalFestivals culFests = new CulturalFestivals();
	HistoricalSites hisSites = new HistoricalSites();
	HistoricalFigures hisFigs = new HistoricalFigures();
	
	// Methods
	// Search (Historical Period)	
	public HistoricalPeriod searchPeriod (String input) {
		// search
		HistoricalPeriod hisPeriod = hisPeriods.searchPeriod(input);
		
		// print information
		return hisPeriod;
	}
	
	public HistoricalChildPeriod searchChildPeriod (String input) {
		HistoricalChildPeriod hisChildPer = new HistoricalChildPeriod(); 
		
		List<HistoricalPeriod> hisPeriodList = hisPeriods.getHisVNPeriods();
		for (HistoricalPeriod period: hisPeriodList) {
			hisChildPer = period.searchChildPeriod(input);
			if (hisChildPer != null) break;
		}
		
		// print information
		return hisChildPer;
	}
	
	public HistoricalDynasty searchDynasty (String input) {
		HistoricalDynasty hisDyansty = new HistoricalDynasty(); 
		
		List<HistoricalPeriod> hisPeriodList = hisPeriods.getHisVNPeriods();
		for (HistoricalPeriod hisPeriod: hisPeriodList) {
			List<HistoricalChildPeriod> dynastyList = hisPeriod.getChildPeriodList();
			
			for (HistoricalChildPeriod dynasty: dynastyList) {
				hisDyansty = dynasty.searchDynasty(input);
				if (hisDyansty != null) break;
			}
			if (hisDyansty != null) break;
		}
		
		// print information
		return hisDyansty;
	}
	
	// Search (Historical Event)
	public HistoricalEvent searchEvent (String input) {
		
		// search
		HistoricalEvent hisEvent = hisEvents.searchEvent(input);
		
		//print information
		return hisEvent;
	}
	
	// Search (Historical Festival)
	public CulturalFestival searchFestival (String input) {
		// search
		CulturalFestival culFest = culFests.searchFestival(input);
		
		// print information
		return culFest;
	}
	
	// Search (Historical Figures)
	public HistoricalFigure searchFigure (String input) {
		// search
		HistoricalFigure hisFigure = hisFigs.searchFigure(input);
		
		// print information
		return hisFigure;
	}
	
	// Search (Historical Sites)
	public HistoricalSite searchSite (String input) {
		// search
		HistoricalSite hisSite = hisSites.searchSite(input);
		
		// print information
		return hisSite;
	}
	
	// main search method
	public void searchMain () {
		File fileDyn = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataDyn.json");
		File fileFes = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataFes.json");
		File fileEvent = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataEvent.json");
		File fileSites = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataSites.json");
		File fileFigures = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataFigues.json");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			// read file json
			if (fileDyn.exists()) {
				hisPeriods = mapper.readValue(fileDyn, HistoricalPeriods.class);
			}
			else {
				System.out.println("File ko ton tai");
			}
			
			if (fileEvent.exists()) {
				hisEvents = mapper.readValue(fileEvent, HistoricalEvents.class);
			}
			else {
				System.out.println("File ko ton tai");
			}
			
			if (fileFes.exists()) {
				culFests = mapper.readValue(fileFes, CulturalFestivals.class);
			}
			else {
				System.out.println("File ko ton tai");
			}
			
			if (fileSites.exists()) {
				hisSites = mapper.readValue(fileSites, HistoricalSites.class);
			}
			else {
				System.out.println("File ko ton tai");
			}
			
			if (fileFigures.exists()) {
				hisFigs = mapper.readValue(fileFigures, HistoricalFigures.class);
			}
			else {
				System.out.println("File ko ton tai");
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
