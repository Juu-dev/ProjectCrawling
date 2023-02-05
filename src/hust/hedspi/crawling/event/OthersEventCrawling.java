package hust.hedspi.crawling.event;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisevent.HistoricalEvent;
import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.figure.DataHisFigures;

public class OthersEventCrawling extends Crawling {
	private List<HistoricalEvent>  hisEventList = new ArrayList<HistoricalEvent> ();

	public List<HistoricalEvent> getHisEventList() {
		return hisEventList;
	}

	public void setHisEventList(List<HistoricalEvent> hisEventList) {
		this.hisEventList = hisEventList;
	}
	
	
	// Methods
	// get data from url list by crawling (938 - nay)
	public void getEvent() {
		List<String> urlList = getUrlList();
		
		DataHisFigures figureList = new DataHisFigures();
		
		String query1 = "div.page-header h1";
		String query2 = "table tbody tbody tr:first-child td:nth-child(2)";
		String query3 = "table tbody tbody tr:nth-child(2) td:nth-child(2)";
		String query4 = "table tbody tbody tr:nth-child(3) td:nth-child(2)";
		String query5 = "tbody tr:nth-child(7)";
		
		List<HistoricalFigure> hisFigures = figureList.getAllFigures2();
		
		for (String url: urlList) {
			connectToWeb(url);
			
			// crawling data event
			Elements name = crawlingData(query1);
            Elements time = crawlingData(query2);
            Elements location = crawlingData(query3);
            Elements content = crawlingData(query4);
            Elements historicalFigure = null;
            Elements check = crawlingData(query5);
            Elements check1 = crawlingData("tbody tbody tr:nth-child(6)");
            
            if (dataEdit(check1.text()).equals("Chỉ huy")){
            	historicalFigure = crawlingData("tbody tr:nth-child(7)");
            }
            
            if (dataEdit(check.text()).equals("Chỉ huy")){
            	historicalFigure = crawlingData("tbody tr:nth-child(8)");
            } 
            else historicalFigure = crawlingData(query5);
            
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
            
            if (timeEvent.compareTo("") == 0 && nameEvent.length() != 0) {
            	timeEvent += nameEvent.substring(nameEvent.indexOf("năm ")+4, nameEvent.length());
			}

            
            
            HistoricalEvent hisEvent = new HistoricalEvent(nameEvent, timeEvent, contentEvent, locationEvent, figuresEvent, figuresList);
            hisEvent.setHisFigList(String.join(", ", figuresEvent));
            
            // add historical event to list event
            hisEventList.add(hisEvent);
		}
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

  		time1 = time1.replaceAll(">", "");
  		time1 = time1.replaceAll(" &nbsp", "");
  		time1 =time1.replaceAll("&nbsp", "");
  		time1 = time1.replaceAll(";", "");
  		time1 = time1.replaceAll(":", "");
  		time1 = time1.replaceAll("Chỉ huy chính", "");
  		time1 = time1.replaceAll("\\n \\n  \\n ", "");
  		time1 = time1.replaceAll("\\n  \\n   \\n   ", "");
  		time1 = time1.replaceAll("\n", "");
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
}
