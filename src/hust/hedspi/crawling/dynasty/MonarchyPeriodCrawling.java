package hust.hedspi.crawling.dynasty;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisfigure.HistoricalFigure;
import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalDynasty;
import hust.hedspi.base.hisperiod.HistoricalPeriod;

import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.event.WarEventsCrawling;
import hust.hedspi.crawling.figure.DinhDynastyCrawling;
import hust.hedspi.crawling.figure.HoDynastyCrawling;
import hust.hedspi.crawling.figure.LyDynastyCrawling;
import hust.hedspi.crawling.figure.MacDynastyCrawling;
import hust.hedspi.crawling.figure.NgoDynastyCrawling;
import hust.hedspi.crawling.figure.NguyenDynastyCrawling;
import hust.hedspi.crawling.figure.TaySonDynastyCrawling;
import hust.hedspi.crawling.figure.TienLeDynastyCrawling;
import hust.hedspi.crawling.figure.TranDynastyCrawling;

//Method crawling data thoi ky quan chu
public class MonarchyPeriodCrawling extends Crawling implements DynCrawInterface {
	@Override
	public HistoricalPeriod crawling() {
		HistoricalPeriod hisPeriod4 = new HistoricalPeriod("Thời kỳ quân chủ");
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		DinhDynastyCrawling dinhDyn = new DinhDynastyCrawling();
		HoDynastyCrawling hoDyn = new HoDynastyCrawling();
		LyDynastyCrawling lyDyn = new LyDynastyCrawling();
		MacDynastyCrawling macDyn = new MacDynastyCrawling();
		NgoDynastyCrawling ngoDyn = new NgoDynastyCrawling();
		NguyenDynastyCrawling nguyenDyn = new NguyenDynastyCrawling();
		TaySonDynastyCrawling taySonDyn = new TaySonDynastyCrawling();
		TienLeDynastyCrawling tienLeDyn = new TienLeDynastyCrawling();
		TranDynastyCrawling tranDyn = new TranDynastyCrawling(); 
		
		WarEventsCrawling hisEvents = new WarEventsCrawling();
		hisEvents.getWarEvents();
		
		String url1 = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/#thoi-bac-thuoc-111-tcn-938";
		String query1 = "h2#thoi-ky-quan-chu-939-1945 ~ p > strong > em";
        String query2 = "h2#thoi-ky-bac-thuoc-lan-thu-iv-1413-1428";
        String query3 = "h2#thoi-ky-bac-thuoc-lan-thu-iv-1413-1428 + p";
        String query4 = "h2#thoi-ky-trung-hung-nha-hau-le-1428-1527";
        String query5 = "h2#thoi-ky-chia-cat-1527-1802";
        String query6 = "h2#thoi-ky-thong-nhat-1788-1858";
		
		String url2 = "https://vanhoatamlinh.com/10-trieu-dai-phong-kien-viet-nam/";
		String query7 = "div.lightgallery h3";
        String query8 = "div.lightgallery h3 + p";
        String query9 = "div.lightgallery h3 + p + p";
		
		// URL 1
		connectToWeb(url1);
		
		String[] nameChildPeriod = {"", "", "", "", "", ""};
		String[] yearChildPeriod = {"", "", "", "", "", ""};
		String[] contentChildPeriod = {"", "", "", "", "", ""};
		int i =0;
		
		// query 1: period 1 (name, year)
		Elements resultQuery =  crawlingData(query1);
		String str = resultQuery.first().text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// query 2: period 2 (name, year)
		resultQuery =  crawlingData(query2);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		// query 3: period 2 (content)
		resultQuery =  crawlingData(query3);
		str = resultQuery.text();
		contentChildPeriod[i] = contentChildPeriod[i].concat(str); 
		i++;
		
		// query 4: period 3 (name, year)
		resultQuery =  crawlingData(query4);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// query 5: period 4 (name, year)
		resultQuery =  crawlingData(query5);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// query 6: period 5 (name, year)
		resultQuery =  crawlingData(query6);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// URL 2
		connectToWeb(url2);
		
		String[] nameDynasties = {"", "", "", "", "", "", "", "", "", ""};
		String[] yearDynasties = {"", "", "", "", "", "", "", "", "", ""};
		String[] contentDynasties = {"", "", "", "", "", "", "", "", "", ""};
		String[] nameCountryDynasties = {"", "", "", "", "", "", "", "", "", ""};
		i=0;
		
        // Query 7 : name and year of dynasty
		resultQuery =  crawlingData(query7);
		for (Element element : resultQuery) {
            str = element.html();
            str = str.substring(str.indexOf(' '), str.length());
            String nameDynasty = str.substring(0,str.indexOf('(')).trim();
            if (nameDynasty.charAt(nameDynasty.length()-1) == ':') {
                nameDynasty = nameDynasty.substring(0, nameDynasty.length()-1);
            }
            String yearDynasty = str.substring(str.indexOf('(')+1, str.indexOf(')')).trim();   
            // assign name and year dynasty
            nameDynasties[i] = nameDynasties[i].concat(nameDynasty);
            yearDynasties[i] = yearDynasties[i].concat(yearDynasty);
            i++;
        }
		
		// Query 8 : nameCountry
		i = 0;
        resultQuery =  crawlingData(query8);
        for (Element element : resultQuery) {
            String nameCountry = element.text();
            nameCountry = nameCountry.substring(nameCountry.indexOf(':')+1, nameCountry.length());
            nameCountryDynasties[i] = nameCountryDynasties[i].concat(nameCountry);
            i++;
        }
		
		// Query 9: content dynasty
		i = 0;
        resultQuery =  crawlingData(query9);
        for (Element element : resultQuery) {
            String content = element.text();
            contentDynasties[i] = contentDynasties[i].concat(content); 
            i++;
        }
        
        // get figure and set kings dynasty
        for (int ii=0; ii<5; ii++) {
        	switch (ii) {
			case 0: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
				for (int jj = 0; jj < 6; jj++) {
					HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasties[jj], yearDynasties[jj], contentDynasties[jj], nameCountryDynasties[jj]);
					if (jj == 0) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = ngoDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().contains("Vua")) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.ngoEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					else if (jj == 1) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = dinhDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().compareTo("Vua") == 0) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.dinhEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					else if (jj == 2) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = tienLeDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().compareTo("Vua") == 0) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.tienLeEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					else if (jj == 3) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = lyDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().compareTo("Vua") == 0) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.lyEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					else if (jj == 4) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = tranDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().compareTo("Vua") == 0) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.tranEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					else if (jj == 5) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = hoDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().compareTo("Vua") == 0) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.hoEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					
					dynastyList.add(hisDynasty);
				}
				
				hisChildPeriod.setDynastyList(dynastyList);
				childPeriodList.add(hisChildPeriod);
				
				break;
			}
			case 1: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				childPeriodList.add(hisChildPeriod);	
				break;
			}
			case 2: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
				for (int jj = 6; jj <7 ; jj++) {
					HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasties[jj], yearDynasties[jj], contentDynasties[jj], nameCountryDynasties[jj]);
					dynastyList.add(hisDynasty);
				}
				hisChildPeriod.setEventList(hisEvents.hauLeEvents());
				hisChildPeriod.setDynastyList(dynastyList);
				childPeriodList.add(hisChildPeriod);
				break;
			}
			case 3: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
				for (int jj = 7; jj <8 ; jj++) {
					HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasties[jj], yearDynasties[jj], contentDynasties[jj], nameCountryDynasties[jj]);
					
					List<String> historicalKings = new ArrayList<String>();
					List<HistoricalFigure> hisFigureList = macDyn.crawling();
					hisDynasty.setHistoricalFigures(hisFigureList);
					hisDynasty.setHisFigList(getNameFigures(hisFigureList));
					for (HistoricalFigure hisFigure: hisFigureList) {
						if (hisFigure.getJob().compareTo("Vua") == 0) {
							historicalKings.add(hisFigure.getName());
						}
					}
					hisDynasty.setEventList(hisEvents.macEvents());
					hisDynasty.setHistoricalKings(historicalKings);
					hisDynasty.setHisKingList(String.join(", ", historicalKings));
					dynastyList.add(hisDynasty);
				}
				hisChildPeriod.setDynastyList(dynastyList);
				childPeriodList.add(hisChildPeriod);
				break;
			}
			case 4: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
				for (int jj = 8; jj <10 ; jj++) {
					HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasties[jj], yearDynasties[jj], contentDynasties[jj], nameCountryDynasties[jj]);
					if (jj == 8) {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = taySonDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().contains("Vua")) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					else {
						List<String> historicalKings = new ArrayList<String>();
						List<HistoricalFigure> hisFigureList = nguyenDyn.crawling();
						hisDynasty.setHistoricalFigures(hisFigureList);
						hisDynasty.setHisFigList(getNameFigures(hisFigureList));
						for (HistoricalFigure hisFigure: hisFigureList) {
							if (hisFigure.getJob().contains("Vua")) {
								historicalKings.add(hisFigure.getName());
							}
						}
						hisDynasty.setEventList(hisEvents.nguyenEvents());
						hisDynasty.setHistoricalKings(historicalKings);
						hisDynasty.setHisKingList(String.join(", ", historicalKings));
					}
					dynastyList.add(hisDynasty);
				}
				hisChildPeriod.setDynastyList(dynastyList);
				childPeriodList.add(hisChildPeriod);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ii);
			}
        }
        
        // complete hisPeriod4
        hisPeriod4.setChildPeriodList(childPeriodList);
        return hisPeriod4;
	}
	
	public String getNameFigures(List<HistoricalFigure> hisfigures) {
		List<String> nameFigList = new ArrayList<String>();
		
		for (HistoricalFigure hisfig: hisfigures) {
			nameFigList.add(hisfig.getName());
		}
		
		String nameAll = String.join(", ", nameFigList);
		
		return nameAll;
	}
}
