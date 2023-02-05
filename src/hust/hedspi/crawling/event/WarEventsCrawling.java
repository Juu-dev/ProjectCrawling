package hust.hedspi.crawling.event;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.crawling.Crawling;

public class WarEventsCrawling extends Crawling {
	private List<List<HistoricalEvent>>  hisEventList = new ArrayList<List<HistoricalEvent>> ();
	
	// Edit data event
	public List<HistoricalEvent> EditDataEvents(Elements tableRow, String nameDynasty) {
		List<HistoricalEvent> eventList = new ArrayList<HistoricalEvent>();
		
		for(int j=1; j<tableRow.size(); j++) {
			String nameYearEvent = tableRow.get(j).child(0).text();
			if (nameYearEvent.length() == 0) continue;
			String yearEvent = nameYearEvent.substring(nameYearEvent.indexOf("(")+1, nameYearEvent.indexOf(")"));
			String nameEvent = nameYearEvent.substring(0, nameYearEvent.indexOf("("));
			String contentEvent = tableRow.get(j).lastElementChild().text();
			String cpmYear = "năm ";
			
			if (yearEvent.compareTo("") == 0) {
				yearEvent += nameEvent.substring(nameEvent.indexOf(cpmYear)+4, nameEvent.length());
			}
			
			// create object HistoricalEvent and add data to it
            HistoricalEvent hisEvent = new HistoricalEvent(nameEvent, yearEvent, contentEvent, nameDynasty);
            eventList.add(hisEvent);	
		}
		
		return eventList;
	}
	
	// Get Events
	public void getWarEvents() {
		String url = "https://vi.wikipedia.org/wiki/C%C3%A1c_cu%E1%BB%99c_chi%E1%BA%BFn_tranh_Vi%E1%BB%87t_Nam_tham_gia"; 
		String query1 = "div.mw-parser-output h3 > span.mw-headline";
		String query2 = "div.mw-parser-output h3 + table > tbody";
		
		List<String> nameDynastyList = new ArrayList<String>(); 
		
		connectToWeb(url);
		
		Elements resultQuery1 = crawlingData(query1);
		Elements resultQuery2 = crawlingData(query2);
		
		resultQuery1.remove(resultQuery1.size()-1);
		resultQuery1.remove(resultQuery1.size()-1);
		resultQuery1.remove(resultQuery1.size()-2);
		resultQuery1.remove(resultQuery1.size()-3);
		resultQuery1.remove(resultQuery1.size()-12);
		
		
		// name child period
		for (int i=0 ; i<resultQuery1.size(); i++) {
			nameDynastyList.add(resultQuery1.get(i).text());
		}
		
		// name, year, content, nameDynasty Events
		for (int i=0 ; i<resultQuery2.size(); i++) {
			Element table = resultQuery2.get(i);
			
			Elements tableRow = table.getElementsByTag("tr");
			
			hisEventList.add(EditDataEvents(tableRow, nameDynastyList.get(i)));
		}
	}
	
	// Ky hong bang
	public List<HistoricalEvent> hongBangEvents() {
		return hisEventList.get(0);
	}
	
	// Nha thuc
	public List<HistoricalEvent> thucEvents() {
		return hisEventList.get(1);
	}
		
	// Nha trieu
	public List<HistoricalEvent> trieuEvents() {
		return hisEventList.get(2);
	}
	
	// Bac thuoc lan 1
	public List<HistoricalEvent> bacThuocLan1Events() {
		return hisEventList.get(3);
	}
	
	// Trưng Vương
	public List<HistoricalEvent> trungVuongEvents() {
		return hisEventList.get(4);
	}
	
	// Bac thuoc lan 2
	public List<HistoricalEvent> bacThuocLan2Events() {
		return hisEventList.get(5);
	}
	
	// Nha tien ly
	public List<HistoricalEvent> tienLyEvents() {
		return hisEventList.get(6);
	}
	
	// Bac thuoc lan 3
	public List<HistoricalEvent> bacThuocLan3Events() {
		return hisEventList.get(7);
	}
	
	// Nha ngo
	public List<HistoricalEvent> ngoEvents() {
		return hisEventList.get(8);
	}
	
	// Nha dinh
	public List<HistoricalEvent> dinhEvents() {
		return hisEventList.get(9);
	}
	
	// Nha tien le
	public List<HistoricalEvent> tienLeEvents() {
		return hisEventList.get(10);
	}
	
	// Nha ly
	public List<HistoricalEvent> lyEvents() {
		return hisEventList.get(11);
	}
	
	// Nha tran
	public List<HistoricalEvent> tranEvents() {
		return hisEventList.get(12);
	}
	
	// Nha ho
	public List<HistoricalEvent> hoEvents() {
		return hisEventList.get(13);
	}
	
	// Nha hau le - le so
	public List<HistoricalEvent> leSoEvents() {
		return hisEventList.get(14);
	}
	
	// Nha mac
	public List<HistoricalEvent> macEvents() {
		return hisEventList.get(15);
	}
	
	// Nha hau le - le trung hung
	public List<HistoricalEvent> hauLeEvents() {
		return hisEventList.get(16);
	}
	
	// Nha nguyen
	public List<HistoricalEvent> nguyenEvents() {
		return hisEventList.get(17);
	}
	
	// Nhat thuoc
	public List<HistoricalEvent> nhatThuocEvents() {
		return hisEventList.get(18);
	}
}
