package hust.hedspi.crawling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import hust.hedspi.crawling.dynasty.DataHisDynasties;
import hust.hedspi.crawling.event.DataHistoricalEvents;
import hust.hedspi.crawling.festival.DataCulFestivals;
import hust.hedspi.crawling.figure.DataHisFigures;
import hust.hedspi.crawling.site.DataHisSites;


public class HistoricalCrawling {
	public void hisCrawling () throws Exception {
		DataHisDynasties dataHisDyn = new DataHisDynasties(); 
		DataCulFestivals dataCulFes = new DataCulFestivals();
		DataHistoricalEvents dataHisEvents = new DataHistoricalEvents();
		DataHisSites dataHisSites = new DataHisSites();
		DataHisFigures dataHisFigs = new DataHisFigures();
		
		final File fileDynData = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dynastyData.json");
		final File fileFesData = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\festivalData.json");
		final File fileEventData = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\eventData.json");
		final File fileSiteData = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\siteData.json");
		final File fileFigData = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\figureData.json");
		
		try {
			// create file .json
			if (!fileDynData.exists()) {
				fileDynData.createNewFile(); 				
			}
			
			if (!fileFesData.exists()) {
				fileFesData.createNewFile(); 				
			}
			
			if (!fileEventData.exists()) {
				fileEventData.createNewFile(); 				
			}
			
			if (!fileSiteData.exists()) {
				fileSiteData.createNewFile(); 				
			}
			
			if (!fileFigData.exists()) {
				fileFigData.createNewFile(); 				
			}
			
			// Historical Dynasty
			dataHisDyn.crawlingAndSaveToFile(fileDynData);
			// Historical Figures
			dataHisFigs.crawlingAndSaveToFile(fileFigData);
			// Historical Festivals
			dataCulFes.crawlingAndSaveToFile(fileFesData);
			// Historical Events
			dataHisEvents.crawlingAndSaveToFile(fileEventData);
			// Historical Sites
			dataHisSites.crawlingAndSaveToFile(fileSiteData);
					
		} catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
