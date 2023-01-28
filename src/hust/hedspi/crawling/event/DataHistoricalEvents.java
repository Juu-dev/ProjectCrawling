package hust.hedspi.crawling.event;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisevent.HistoricalEvents;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.figure.DataHisFigures;


public class DataHistoricalEvents {
	HistoricalEvents hisVNEvents = new HistoricalEvents();
	
	// Methods
	
	public String dataEdit(String data) {
		StringBuffer data1 = new StringBuffer(data);
		
		String time1 = new String(data1);
		
  		for (int i = 0; i< data1.length();i++) { 
  			if (Character.compare(data1.charAt(i),'<') == 0) {
  				for (int j =i; j < data1.length();j++) {
  					if (Character.compare(data1.charAt(j),'>') == 0) {
  						data1.delete(i, j);
  						time1 = new String(data1);
  						break;
  					}
  				}
  			}
  		}

  		time1=time1.replaceAll(">", "");
  		time1=time1.replaceAll(" &nbsp", "");
  		time1=time1.replaceAll("&nbsp", "");
  		time1=time1.replaceAll("Chỉ huy chính:", "");
  		time1=time1.replaceAll("\\n \\n  \\n ", "");
  		time1=time1.replaceAll("\\n  \\n   \\n   ", "");
  		time1=time1.replaceAll("\n", "");
  		time1=time1.replaceAll(".", "");
  		time1=time1.replaceAll(";", "");
  		time1=time1.replaceAll("†", "");
  		time1=time1.replaceAll(":", "");
  		return time1.trim();
	}
	
	public List<String> DataEditList(String data) {
		StringBuffer data1 = new StringBuffer(data);
		int j=0;
		List<String> time1 = new ArrayList<String>();
		
  		for(int i=0; i < data1.length();i++) {
  			if ((Character.compare(data1.charAt(i),'<') == 0) && (Character.compare(data1.charAt(i+1),'b') == 0) && (Character.compare(data1.charAt(i+2),'r') == 0)) {
  				String dataInsert = new String(data1);
  				time1.add(dataEdit(dataInsert.substring(j, i)));
  				j=i;
  			}
  			if ((Character.compare(data1.charAt(i),'<') == 0) && (Character.compare(data1.charAt(i+1),'t') == 0) && (Character.compare(data1.charAt(i+2),'d') == 0) && j>0) {
  				String dataInsert = new String(data1);
  				time1.add(dataEdit(dataInsert.substring(j, i)));
  				j=i;
  			}
  		}
  		
  		return time1;
	}
	
	// get url list
	public List<String> getUrlList() {
		String url = "https://nguoikesu.com/tu-lieu/quan-su?filter_tag[0]=&start=";
		String query = "div.page-header h2 > a";
		
		List<String> urlList = new ArrayList<String>();
		
		Crawling data = new Crawling();
		
		for(int i=0; i<=70;i+=5) {
			data.connectToWeb(url + String.valueOf(i));	
			// crawling data events (5 event)
			Elements historicalEvents =  data.crawlingData(query);
			
			for (Element historicalEvent : historicalEvents) {
				String newUrl ="https://nguoikesu.com" + historicalEvent.attr("href");
				urlList.add(newUrl);
			}
		}
		
		return urlList;
	}
	
	// get data from url list by crawling (938 - nay)
	public void getEventAfter938(List<String> urlList) {
		DataHisFigures figureList = new DataHisFigures();
		
		String query1 = "div.page-header h1";
		String query2 = "table tbody tbody tr:first-child td:nth-child(2)";
		String query3 = "table tbody tbody tr:nth-child(2) td:nth-child(2)";
		String query4 = "table tbody tbody tr:nth-child(3) td:nth-child(2)";
		String query5 = "tbody tr:nth-child(7)";
		
		Crawling data = new Crawling();
		
		List<HistoricalFigure> hisFigures = figureList.getAllFigures2();
		
		for (String url: urlList) {
			data.connectToWeb(url);
			
			// crawling data event
			Elements name = data.crawlingData(query1);
            Elements time = data.crawlingData(query2);
            Elements location = data.crawlingData(query3);
            Elements content = data.crawlingData(query4);
            Elements historicalFigure = null;
            Elements check = data.crawlingData(query5);
            Elements check1 = data.crawlingData("tbody tbody tr:nth-child(6)");
            
            if (dataEdit(check1.text()).equals("Chỉ huy")){
            	historicalFigure = data.crawlingData("tbody tr:nth-child(7)");
            }
            
            if (dataEdit(check.text()).equals("Chỉ huy")){
            	historicalFigure = data.crawlingData("tbody tr:nth-child(8)");
            } 
            else historicalFigure = data.crawlingData(query5);
            
            // create object HistoricalEvent and add data to it
            String nameEvent = dataEdit(name.text());
            String timeEvent = dataEdit(time.text());
            String locationEvent = dataEdit(location.text());
            String contentEvent = dataEdit(content.text());
            List<String> figuresEvent = DataEditList(historicalFigure.html());
            List<HistoricalFigure> figuresList = new ArrayList<HistoricalFigure>();
            
            
            for (String figure: figuresEvent) {
				for (HistoricalFigure hisFigure: hisFigures) {
					if (figure.compareTo(hisFigure.getName()) == 0) {
						figuresList.add(hisFigure);
					}
				}
			}
            
            if (timeEvent.compareTo("") == 0) {
            	timeEvent += nameEvent.substring(nameEvent.indexOf("năm ")+4, nameEvent.length());
			}

            
            HistoricalEvent hisEvent = new HistoricalEvent(nameEvent, timeEvent, contentEvent, locationEvent, figuresEvent, figuresList);
            
            // add historical event to list event
            hisVNEvents.addElement(hisEvent);
		}
	}
	
	// get data from url list by crawling (truoc - 938)
	public void getEventBefore938() {
		String url = "https://vi.wikipedia.org/wiki/C%C3%A1c_cu%E1%BB%99c_chi%E1%BA%BFn_tranh_Vi%E1%BB%87t_Nam_tham_gia"; 
		String query1 = "div.mw-parser-output h3 > span.mw-headline";
		String query2 = "div.mw-parser-output h3 + table > tbody";
		
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
		// name child period
		Elements resultQuery = data.crawlingData(query1);
//		for (int i=0 ; i<9; i++) {
//			System.out.println(resultQuery.get(i).text());
//			System.out.println();
//		}
		
		// data event
		resultQuery = data.crawlingData(query2);
		for (int i=0 ; i<9; i++) {
			Element table = resultQuery.get(i);
			
			Elements tableRow = table.getElementsByTag("tr");
			
			for(int j=1; j<tableRow.size(); j++) {
				String nameYearEvent = tableRow.get(j).child(0).text();
				String yearEvent = nameYearEvent.substring(nameYearEvent.indexOf("(")+1, nameYearEvent.indexOf(")"));
				String nameEvent = nameYearEvent.substring(0, nameYearEvent.indexOf("("));
				String contentEvent = tableRow.get(j).lastElementChild().text();
				
				String cpmYear = "năm ";
				
				if (yearEvent.compareTo("") == 0) {
					yearEvent += nameEvent.substring(nameEvent.indexOf(cpmYear)+4, nameEvent.length());
				}
				
				// create object HistoricalEvent and add data to it
	            HistoricalEvent hisEvent = new HistoricalEvent(nameEvent, yearEvent, contentEvent);
				
				// add historical event to list event
	            hisVNEvents.addElement(hisEvent);	
			}
		}
		
	}
	
	// get event with each dynasty
	public List<HistoricalEvent> getEventDynasty(int i) {
		String url = "https://vi.wikipedia.org/wiki/C%C3%A1c_cu%E1%BB%99c_chi%E1%BA%BFn_tranh_Vi%E1%BB%87t_Nam_tham_gia"; 
		String query2 = "div.mw-parser-output h3 + table > tbody";
		
		List<HistoricalEvent> childPeriodEvents = new ArrayList<HistoricalEvent>();
		
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
		// data event
		Elements resultQuery = data.crawlingData(query2);

		// 0 - 8
		Element table = resultQuery.get(i);
		
		Elements tableRow = table.getElementsByTag("tr");
		
		for(int j=1; j<tableRow.size(); j++) {
			String nameYearEvent = tableRow.get(j).child(0).text();
			String yearEvent = nameYearEvent.substring(nameYearEvent.indexOf("(")+1, nameYearEvent.indexOf(")"));
			String nameEvent = nameYearEvent.substring(0, nameYearEvent.indexOf("("));
			String contentEvent = tableRow.get(j).lastElementChild().text();
			
			String cpmYear = "năm ";
			
			if (yearEvent.compareTo("") == 0) {
				yearEvent += nameEvent.substring(nameEvent.indexOf(cpmYear)+4, nameEvent.length());
			}
			
			// create object HistoricalEvent and add data to it
            HistoricalEvent hisEvent = new HistoricalEvent(nameEvent, yearEvent, contentEvent);
			
			// add historical event to list event
            childPeriodEvents.add(hisEvent);	
		}
		
		return childPeriodEvents;
	}
	
	// main methods
	public void crawlingAndSaveToFile(File file) throws Exception {		
		// crawling data 1
		getEventBefore938();
		
		// crawling data 2
		List<String> urlList = new ArrayList<String>();
		urlList = getUrlList();
		getEventAfter938(urlList);
		
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