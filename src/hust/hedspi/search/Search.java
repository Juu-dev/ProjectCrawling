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


public class Search implements SearchInterface {
	HistoricalPeriods hisPeriods = new HistoricalPeriods();
	HistoricalEvents hisEvents = new HistoricalEvents();
	CulturalFestivals culFests = new CulturalFestivals();
	HistoricalSites hisSites = new HistoricalSites();
	HistoricalFigures hisFigs = new HistoricalFigures();
	
	// Methods
	@Override
	public List<HistoricalPeriod> searchPeriod (String input) {
		List<HistoricalPeriod> hisPeriod = hisPeriods.searchPeriod(input);
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
		return hisDyansty;
	}
	
	@Override
	public List<HistoricalEvent> searchEvent (String input) {
		List<HistoricalEvent> hisEvent = hisEvents.searchEvent(input);
		return hisEvent;
	}
	
	@Override
	public List<CulturalFestival> searchFestival (String input) {
		List<CulturalFestival> culFest = culFests.searchFestival(input);
		return culFest;
	}
	
	@Override
	public List<HistoricalFigure> searchFigure (String input) {
		List<HistoricalFigure> hisFigure = hisFigs.searchFigure(input);
		return hisFigure;
	}
	
	@Override
	public List<HistoricalSite> searchSite (String input) {
		List<HistoricalSite> hisSite = hisSites.searchSite(input);
		return hisSite;
	}
	
	@Override
	public void searchMain () {
		File fileDyn = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dynastyData.json");
		File fileFes = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\festivalData.json");
		File fileEvent = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\eventData.json");
		File fileSites = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\siteData.json");
		File fileFigures = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\figureData.json");
		
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
