package hust.hedspi.crawling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import hust.hedspi.base.hisfigure.HistoricalFigures;
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
		
		try {
			// create file .json
			File fileDyn = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataDyn.json");
			if (!fileDyn.exists()) {
				fileDyn.createNewFile(); 				
			}
			File fileFes = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataFes.json");
			if (!fileFes.exists()) {
				fileFes.createNewFile(); 				
			}
			File fileEvent = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataEvent.json");
			if (!fileEvent.exists()) {
				fileEvent.createNewFile(); 				
			}
			File fileSites = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataSites.json");
			if (!fileSites.exists()) {
				fileSites.createNewFile(); 				
			}
			File fileFigures = new File("C:\\Users\\PMT_2002\\eclipse-workspace\\ProjectScrawling\\src\\hust\\hedspi\\assets\\dataFigues.json");
			if (!fileFigures.exists()) {
				fileFigures.createNewFile(); 				
			}
				// Historical Dynasty
//				dataHisDyn.crawlingAndSaveToFile(fileDyn);
				// Historical Figures
				dataHisFigs.crawlingAndSaveToFile(fileFigures);
				// Historical Festivals
				dataCulFes.crawlingAndSaveToFile(fileFes);
				// Historical Events
				dataHisEvents.crawlingAndSaveToFile(fileEvent);
				// Historical Sites
				dataHisSites.crawlingAndSaveToFile(fileSites);
				
				
		} catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
