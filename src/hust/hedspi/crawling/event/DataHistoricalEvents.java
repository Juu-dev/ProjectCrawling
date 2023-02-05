package hust.hedspi.crawling.event;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.hisevent.HistoricalEvents;
import hust.hedspi.crawling.DataHisInterface;


public class DataHistoricalEvents implements DataHisInterface {
	
	HistoricalEvents hisVNEvents = new HistoricalEvents();

	// main methods
	@Override
	public void crawlingAndSaveToFile(File file) throws Exception {		
		WarEventsCrawling warEventsCraw = new WarEventsCrawling();
		OthersEventCrawling othersEventCraw = new OthersEventCrawling();
		
		// crawling war events data 1
		warEventsCraw.getWarEvents();
		
		hisVNEvents.addElement(warEventsCraw.hongBangEvents());
		hisVNEvents.addElement(warEventsCraw.thucEvents());
		hisVNEvents.addElement(warEventsCraw.trieuEvents());
		hisVNEvents.addElement(warEventsCraw.bacThuocLan1Events());
		hisVNEvents.addElement(warEventsCraw.trungVuongEvents());
		hisVNEvents.addElement(warEventsCraw.bacThuocLan2Events());
		hisVNEvents.addElement(warEventsCraw.tienLyEvents());
		hisVNEvents.addElement(warEventsCraw.bacThuocLan3Events());
		hisVNEvents.addElement(warEventsCraw.ngoEvents());
		hisVNEvents.addElement(warEventsCraw.dinhEvents());
		hisVNEvents.addElement(warEventsCraw.tienLeEvents());
		hisVNEvents.addElement(warEventsCraw.lyEvents());
		hisVNEvents.addElement(warEventsCraw.tranEvents());
		hisVNEvents.addElement(warEventsCraw.hoEvents());
		hisVNEvents.addElement(warEventsCraw.leSoEvents());
		hisVNEvents.addElement(warEventsCraw.macEvents());
		hisVNEvents.addElement(warEventsCraw.hauLeEvents());
		hisVNEvents.addElement(warEventsCraw.nguyenEvents());
		hisVNEvents.addElement(warEventsCraw.nhatThuocEvents());
		
		// crawling others event data 2
		othersEventCraw.getEvent();
		hisVNEvents.addElement(othersEventCraw.getHisEventList());
		
		// add data to json file
		ObjectMapper mapper = new ObjectMapper();
		try {
        	if (file != null) {
        	// System.out.println("Lưu đối tượng dưới dạng json vào file json");
        	mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, hisVNEvents);
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