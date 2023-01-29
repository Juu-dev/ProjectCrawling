package hust.hedspi.search;

import java.io.File;
import java.util.ArrayList;
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


public class Search implements SearchFunction {
	HistoricalPeriods hisPeriods = new HistoricalPeriods();
	HistoricalEvents hisEvents = new HistoricalEvents();
	CulturalFestivals culFests = new CulturalFestivals();
	HistoricalSites hisSites = new HistoricalSites();
	HistoricalFigures hisFigs = new HistoricalFigures();
	
	// Methods
	// Search (Historical Period)
	@Override
	public List<HistoricalPeriod> searchPeriod (String input) {
		// search
		List<HistoricalPeriod> hisPeriod = hisPeriods.searchPeriod(input);
		
		// print information
		return hisPeriod;
	}
	
	@Override
	public List<HistoricalChildPeriod> searchChildPeriod (String input) {
		List<HistoricalChildPeriod> hisChildPer = new ArrayList<HistoricalChildPeriod>(); 
		
		List<HistoricalPeriod> hisPeriodList = hisPeriods.getHisVNPeriods();
		for (HistoricalPeriod period: hisPeriodList) {
			List<HistoricalChildPeriod> resultSearch = period.searchChildPeriod(input);
			hisChildPer.addAll(resultSearch);
		}
		
		// print information
		return hisChildPer;
	}
	
	@Override
	public List<HistoricalDynasty> searchDynasty (String input) {
		List<HistoricalDynasty> hisDyansty = new ArrayList<HistoricalDynasty>(); 
		
		List<HistoricalPeriod> hisPeriodList = hisPeriods.getHisVNPeriods();
		for (HistoricalPeriod hisPeriod: hisPeriodList) {
			List<HistoricalChildPeriod> dynastyList = hisPeriod.getChildPeriodList();
			
			for (HistoricalChildPeriod dynasty: dynastyList) {
				List<HistoricalDynasty> resultSearch = dynasty.searchDynasty(input);
				hisDyansty.addAll(resultSearch);
			}
		}
		
		// print information
		return hisDyansty;
	}
	
	// Search (Historical Event)
	@Override
	public List<HistoricalEvent> searchEvent (String input) {
		
		// search
		List<HistoricalEvent> hisEvent = hisEvents.searchEvent(input);
		
		//print information
		return hisEvent;
	}
	
	// Search (Historical Festival)
	@Override
	public List<CulturalFestival> searchFestival (String input) {
		// search
		List<CulturalFestival> culFest = culFests.searchFestival(input);
		
		// print information
		return culFest;
	}
	
	// Search (Historical Figures)
	@Override
	public List<HistoricalFigure> searchFigure (String input) {
		// search
		List<HistoricalFigure> hisFigure = hisFigs.searchFigure(input);
		
		// print information
		return hisFigure;
	}
	
	// Search (Historical Sites)
	@Override
	public List<HistoricalSite> searchSite (String input) {
		// search
		List<HistoricalSite> hisSite = hisSites.searchSite(input);
		
		// print information
		return hisSite;
	}
	
	// main search method
	@Override
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
