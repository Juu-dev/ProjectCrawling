package hust.hedspi.crawling.dynasty;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.base.hisperiod.HistoricalPeriods;

import hust.hedspi.crawling.DataHisInterface;

public class DataHisDynasties implements DataHisInterface {
	AncientCrawling ancientPeriod = new AncientCrawling();
	ColonyTimeCrawling colonyPeriod = new ColonyTimeCrawling();
	ModernPeriodCrawling modernPeriod = new ModernPeriodCrawling();
	MonarchyPeriodCrawling monarchyPeriod = new MonarchyPeriodCrawling();
	PreHistoricCrawling perhistoricPeriod = new PreHistoricCrawling();
	
	@Override
	public void crawlingAndSaveToFile(File file) throws Exception {
		HistoricalPeriods hisVNPeriods = new HistoricalPeriods();
		
		HistoricalPeriod hisPeriod1 = perhistoricPeriod.crawling();
		HistoricalPeriod hisPeriod2 = ancientPeriod.crawling();
		HistoricalPeriod hisPeriod3 = colonyPeriod.crawling();
		HistoricalPeriod hisPeriod4 = monarchyPeriod.crawling();
		HistoricalPeriod hisPeriod5 = modernPeriod.crawling();
		
		// add period to list period 
		hisVNPeriods.addElement(hisPeriod1);
		hisVNPeriods.addElement(hisPeriod2);
		hisVNPeriods.addElement(hisPeriod3);
		hisVNPeriods.addElement(hisPeriod4);
		hisVNPeriods.addElement(hisPeriod5);
	
		// convert java object to json and save to json file
		ObjectMapper mapper = new ObjectMapper();
        try {
        	
        	if (file != null) {
        		mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, hisVNPeriods);
        	}
        	else {
        		throw new Exception("Error: file is null");
        	}
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
