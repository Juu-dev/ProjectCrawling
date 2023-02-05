package hust.hedspi.crawling.site;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.base.hissite.HistoricalSite;
import hust.hedspi.base.hissite.HistoricalSites;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.DataHisInterface;
import hust.hedspi.crawling.figure.DataHisFigures;

public class DataHisSites extends Crawling implements DataHisInterface {
	
	private HistoricalSites hisVNSites = new HistoricalSites();
	
	// Methods
	public List<HistoricalSite> getListSite1() {
		String url = "https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam";
		String query1 = "div.mw-parser-output > h3 > span.mw-headline";
		String query2 = "div.mw-parser-output > h3 + table > tbody";
		
		String comp1 = "Lịch sử";
		String comp2 = "Lịch sử đặc biệt";
		String comp3 = "Lịch sử văn hóa";
		
		List<HistoricalSite> hisSites = new ArrayList<HistoricalSite>();
		
//		DataHisFigures figuresList = new DataHisFigures();
		
		connectToWeb(url);
		
		// crawling data
		Elements resultQuery1 = crawlingData(query1);
		Elements resultQuery2= crawlingData(query2);

		List<String> nameCountryList = new ArrayList<String>();
		
		// name city 
		for (int i=0; i<resultQuery1.size(); i++) {
			nameCountryList.add(resultQuery1.get(i).text());
		}
		
//		List<HistoricalFigure> hisFiguresList = figuresList.getAllFigures2();
		
		// data sites
		for (int i=0; i<resultQuery2.size(); i++) {
			Elements sites = resultQuery2.get(i).getElementsByTag("tr");
			
			for (Element site: sites) {
				String dataSite = site.child(2).text();
				if (dataSite.compareTo(comp1) == 0 || dataSite.compareTo(comp2) == 0 || dataSite.compareTo(comp3) == 0) {
					String nameSite = site.child(0).text();
					String dateSite = site.child(3).text();
					String locationSite = site.child(1).text();
					List<String> hisFiguresExp = new ArrayList<String>(); 
							
					String strContain1 = "thờ ";
					String strContain2 = "( ";
					String strContain3 = ", ";
						
					// handle nameSite to get historical figure
					if (nameSite.contains(strContain1)) {
						if(nameSite.contains(strContain2)) {
							String figures = nameSite.substring(nameSite.indexOf("( ")+1, nameSite.indexOf(")"));
							if (nameSite.contains(strContain3)) {
								String[] figureList = figures.split(",");
								for (String figure: figureList) {
									hisFiguresExp.add(figure);
								}
							}
							else {
								hisFiguresExp.add(figures);
							}
						}
						else {
							String figures = nameSite.substring(nameSite.indexOf("thờ ")+4, nameSite.length());
							if (nameSite.contains(strContain3)) {
								String[] figureList = figures.split(",");
								for (String figure: figureList) {
									hisFiguresExp.add(figure);
								}
							}
							else {
								hisFiguresExp.add(figures);
							}
						}
					}
		
					
					HistoricalSite hisSite = new HistoricalSite(nameSite, dateSite, locationSite);
					
					if (site.child(0).firstChild().attr("href") != "") {
							String newUrl = "https://vi.wikipedia.org" + site.child(0).firstChild().attr("href");
							String query3 = "div.mw-parser-output > p";
							String query4 = "table.infobox > tbody > tr > td > b > a";
							
							// connect to web
							connectToWeb(newUrl);
							// crawling data
							String content = crawlingData(query3).text();
							String hisFigures = crawlingData(query4).text();
							
							if (!(hisFigures.length() == 0) && hisFigures != null) {
								if (hisFigures.contains(strContain3)) {
									String[] hisFigureList = hisFigures.split(","); 
									for (String str: hisFigureList) {
										hisFiguresExp.add(str);
									}
								}
								else hisFiguresExp.add(hisFigures);
							}
							
							hisSite.setContent(content);
							hisSite.setHistoricalFigure(hisFiguresExp);
							hisSite.setHisFigList(String.join(", ", hisFiguresExp));
					}
					
					List<HistoricalFigure> figuresListVN = new ArrayList<HistoricalFigure>();
					
					// set figures
//					for (String hisFigureExp: hisFiguresExp) {
//						for (HistoricalFigure hisFigure: hisFiguresList ) {
//							if (hisFigureExp.contains(hisFigure.getName())) {
//								figuresListVN.add(hisFigure);
//							}
//						}
//					}
					
					hisSite.setFiguresList(figuresListVN);
					
					hisSites.add(hisSite);
				}
			}
		}
		
		return hisSites;
	}

	public void getListSite2() {
		hisVNSites.addElement(getListSite1());
	}
	
	// main methods
	@Override
	public void crawlingAndSaveToFile(File file) throws Exception {
		getListSite2();
		// Write JSON file to the root folder
		ObjectMapper mapper = new ObjectMapper();
		try {
      	
			if (file != null) {	
      		// System.out.println("Lưu đối tượng dưới dạng json vào file json");
	      	mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(file, hisVNSites);
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
	