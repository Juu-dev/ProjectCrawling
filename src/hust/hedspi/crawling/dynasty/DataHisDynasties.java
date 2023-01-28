package hust.hedspi.crawling.dynasty;

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
import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalDynasty;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.base.hisperiod.HistoricalPeriods;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.event.DataHistoricalEvents;
import hust.hedspi.crawling.figure.DataHisFigures;

public class DataHisDynasties {
	static HistoricalPeriod hisPeriod1 = new HistoricalPeriod("Thời kỳ tiền sử");
	static HistoricalPeriod hisPeriod2 = new HistoricalPeriod("Thời kỳ cổ đại");
	static HistoricalPeriod hisPeriod3 = new HistoricalPeriod("Thời kỳ Bắc thuộc");
	static HistoricalPeriod hisPeriod4 = new HistoricalPeriod("Thời kỳ quân chủ");
	static HistoricalPeriod hisPeriod5 = new HistoricalPeriod("Thời kỳ hiện đại");
	
	static int numberChildPeriod = 0;
	
	// method crawling data thoi ki tien su
	public void dataPrehistoric() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		DataHistoricalEvents dataHisEvents = new DataHistoricalEvents();
		
		String url = "https://vi.wikipedia.org/wiki/L%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam#Th%E1%BB%9Di_k%E1%BB%B3_ti%E1%BB%81n_s%E1%BB%AD";
		String query1 = "h3 > span + span[id^=\"Thời_đại_đồ\"]";
		String query2 = "div.mw-parser-output > h3 + div + p";
		
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
        // Query 1 : name and content Child period
		Elements resultQuery1 =  data.crawlingData(query1);
		Elements resultQuery2 =  data.crawlingData(query2);
		
		for (int i=0; i<resultQuery1.size(); i++) {
			HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(resultQuery1.get(i).text(), resultQuery2.get(i).text());
			childPeriodList.add(hisChildPeriod);
        }

		// complete hisPeriod1
		hisPeriod1.setChildPeriodList(childPeriodList);
	}

	// method crawling data thoi ki co dai
	public void dataAncient() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
		DataHistoricalEvents dataHisEvents = new DataHistoricalEvents();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/";
		String query1 = "h2#thoi-ky-co-dai-2879-111-tcn ~ p > strong > em";
		String query2 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p";
		String query3 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p + p";
		String query4 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p + p + p + p";
		
		Crawling data = new Crawling();
		
		data.connectToWeb(url);

		int i=0;
		
        // Query 1 : name child period
		Elements resultQuery =  data.crawlingData(query1);
		for (Element element : resultQuery) {
            String str = element.text();
            // handle data
            String childPeriodName = str.substring(0, str.indexOf("("));
            String yearChildPeriod = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            // create period and assign data
            HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(childPeriodName);
            hisChildPeriod.setYear(yearChildPeriod);
            // set dataHisEvents in child period
 			hisChildPeriod.setEventList(dataHisEvents.getEventDynasty(numberChildPeriod));
 			numberChildPeriod++;
            // add childPeriodList
            childPeriodList.add(hisChildPeriod);
            i++;
            if (i == 2) break;
        }
		numberChildPeriod++;
		
		// Query 2 : name, content dynasty of period 1
		resultQuery =  data.crawlingData(query2);
        String str = resultQuery.text();
        String nameDynasty = str.substring(0, str.indexOf(":"));
        String contentDynasty = str.substring(str.indexOf(":") + 1, str.length()).trim();
        // create HistoricalDynasty
        HistoricalDynasty hisDynasty1 = new HistoricalDynasty(nameDynasty, contentDynasty);
        // assign data to dynastyList
        dynastyList.add(hisDynasty1);
        
        // Query 3 : name, content, year dynasty of period 1 
        resultQuery =  data.crawlingData(query3);
        str = resultQuery.text();
        // handle data
        nameDynasty = str.substring(0, str.indexOf("(")-1);
        String yearDynasty = "258-218 TCN";
        contentDynasty = str.substring(str.indexOf(":")+1, str.length()).trim();
        // create HistoricalDynasty
        HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasty, yearDynasty, contentDynasty);
        // assign data to dynastyList
        dynastyList.add(hisDynasty);
        
        // add dynasty list to childPeriodList 1
        childPeriodList.get(0).setDynastyList(dynastyList);
        
        // Query 4 : content of period 2
        resultQuery =  data.crawlingData(query4);
        str = resultQuery.text();
        String contentPeriod2 = str.trim();
        // add content list to childPeriodList 2
        childPeriodList.get(1).setContent(contentPeriod2);
        // complete hisPeriod2
        hisPeriod2.setChildPeriodList(childPeriodList);
	}
	
	// method crawling data thoi ki bac thuoc
	public void dataColonyTime() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		DataHistoricalEvents dataHisEvents = new DataHistoricalEvents();
		DataHisFigures dataHisFig = new DataHisFigures();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/#thoi-bac-thuoc-111-tcn-938";
		String query1 = "h2#thoi-bac-thuoc-111-tcn-938 ~ p > strong > em";
		String query1_ex1 = "h2#thoi-bac-thuoc-111-tcn-938 ~ h2";
		String query2 = "h2#thoi-bac-thuoc-111-tcn-938 ~ p";
		
		Crawling data = new Crawling();
		
		data.connectToWeb(url);
		
		String[] nameChildPeriod = {"", "", "", "", "", ""};
		String[] yearChildPeriod = {"", "", "", "", "", ""};
		String[] contentChildPeriod = {"", "", "", "", "", ""};
		
		int i=0, j=0;
		
        // Query 1 : name child period
		Elements resultQuery =  data.crawlingData(query1);
		for (Element element : resultQuery) {
            String str = element.text();
            nameChildPeriod[i] = str.substring(0, str.indexOf("("));
            yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            i++;
            if (i == 4) break;
        }
		
		// Query 1_1 : name child period
		resultQuery =  data.crawlingData(query1_ex1);
		for (Element element : resultQuery) {
            String str = element.text();
            nameChildPeriod[i] = str.substring(0, str.indexOf("("));
            yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            i++;
            if (i == 6) break;
        }
		
		// Query 2 : content of each period
		resultQuery =  data.crawlingData(query2);
        for (Element element : resultQuery) {
        	j++;
        	
        	switch (j) {
			case 2:
			case 3: {
				String str = element.text();
				contentChildPeriod[0] = contentChildPeriod[0].concat(str);
				break;
			}
			case 5:
			case 6: {
				String str = element.text();
				contentChildPeriod[1] = contentChildPeriod[1].concat(str);
				break;
			}
			case 8:
			case 9: {
				String str = element.text();
				contentChildPeriod[2] = contentChildPeriod[2].concat(str);
				break;
			}
			case 11: {
				String str = element.text();
				contentChildPeriod[3] = contentChildPeriod[3].concat(str);
				break;
			}
			case 13:
			case 14: {
				String str = element.text();
				contentChildPeriod[4] = contentChildPeriod[4].concat(str);
				break;
			}
			case 15: {
				String str = element.text();
				contentChildPeriod[5] = contentChildPeriod[5].concat(str);
				break;
			}
			case 16: 
				break;
			}
        	
        	if (j == 16) break;
        }
        
        
        
        for (int jj=0; jj<6; jj++) {
        	HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[jj], yearChildPeriod[jj], contentChildPeriod[jj]);
        	// set dataHisEvents in child period
 			hisChildPeriod.setEventList(dataHisEvents.getEventDynasty(numberChildPeriod));
 			numberChildPeriod++;
 			// set dataHisFigure
 			if (jj == 1) {
 				hisChildPeriod.setFigureList(dataHisFig.haiBaTrungDynasty());
        	}
 			
 			// add childPeriodList
        	childPeriodList.add(hisChildPeriod);
        }
        
        // complete hisPeriod3
     	hisPeriod3.setChildPeriodList(childPeriodList);
	}

	
	// Method crawling data thoi ky quan chu
	public void dataMonarchyPeriod() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		DataHisFigures dataHisFig = new DataHisFigures();
		
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
		
		Crawling data = new Crawling();
		
		// URL 1
		data.connectToWeb(url1);
		
		String[] nameChildPeriod = {"", "", "", "", "", ""};
		String[] yearChildPeriod = {"", "", "", "", "", ""};
		String[] contentChildPeriod = {"", "", "", "", "", ""};
		int i =0;
		
		// query 1: period 1 (name, year)
		Elements resultQuery =  data.crawlingData(query1);
		String str = resultQuery.first().text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// query 2: period 2 (name, year)
		resultQuery =  data.crawlingData(query2);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		// query 3: period 2 (content)
		resultQuery =  data.crawlingData(query3);
		str = resultQuery.text();
		contentChildPeriod[i] = contentChildPeriod[i].concat(str); 
		i++;
		
		// query 4: period 3 (name, year)
		resultQuery =  data.crawlingData(query4);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// query 5: period 4 (name, year)
		resultQuery =  data.crawlingData(query5);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// query 6: period 5 (name, year)
		resultQuery =  data.crawlingData(query6);
		str = resultQuery.text();
		nameChildPeriod[i] = nameChildPeriod[i].concat(str.substring(0,str.indexOf('(')).trim());
		yearChildPeriod[i] = yearChildPeriod[i].concat(str.substring(str.indexOf("(")+1, str.indexOf(")"))); 
		i++;
		
		// URL 2
		data.connectToWeb(url2);
		
		String[] nameDynasties = {"", "", "", "", "", "", "", "", "", ""};
		String[] yearDynasties = {"", "", "", "", "", "", "", "", "", ""};
		String[] contentDynasties = {"", "", "", "", "", "", "", "", "", ""};
		String[] nameCountryDynasties = {"", "", "", "", "", "", "", "", "", ""};
		i=0;
		
        // Query 7 : name and year of dynasty
		resultQuery =  data.crawlingData(query7);
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
        resultQuery =  data.crawlingData(query8);
        for (Element element : resultQuery) {
            String nameCountry = element.text();
            nameCountry = nameCountry.substring(nameCountry.indexOf(':')+1, nameCountry.length());
            nameCountryDynasties[i] = nameCountryDynasties[i].concat(nameCountry);
            i++;
        }
		
		// Query 9: content dynasty
		i = 0;
        resultQuery =  data.crawlingData(query9);
        for (Element element : resultQuery) {
            String content = element.text();
            contentDynasties[i] = contentDynasties[i].concat(content); 
            i++;
        }
        
        // 
        for (int ii=0; ii<5; ii++) {
        	switch (ii) {
			case 0: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
				for (int jj = 0; jj < 6; jj++) {
					HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasties[jj], yearDynasties[jj], contentDynasties[jj], nameCountryDynasties[jj]);
					if (jj == 0) {
						hisDynasty.setHistoricalFigures(dataHisFig.ngoDynasty());
					}
					else if (jj == 1) {
						hisDynasty.setHistoricalFigures(dataHisFig.dinhDynasty());
					}
					else if (jj == 2) {
						hisDynasty.setHistoricalFigures(dataHisFig.tienLeDynasty());
					}
					else if (jj == 3) {
						hisDynasty.setHistoricalFigures(dataHisFig.lyDynasty());
					}
					else if (jj == 4) {
						hisDynasty.setHistoricalFigures(dataHisFig.tranDynasty());
					}
					else if (jj == 5) {
						hisDynasty.setHistoricalFigures(dataHisFig.hoDynasty());
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
				hisChildPeriod.setDynastyList(dynastyList);
				childPeriodList.add(hisChildPeriod);
				break;
			}
			case 3: {
				HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[ii], yearChildPeriod[ii], contentChildPeriod[ii]);
				List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
				for (int jj = 7; jj <8 ; jj++) {
					HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasties[jj], yearDynasties[jj], contentDynasties[jj], nameCountryDynasties[jj]);
					hisDynasty.setHistoricalFigures(dataHisFig.macDynasty());
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
						hisDynasty.setHistoricalFigures(dataHisFig.taySonDynasty());
					}
					else {
						hisDynasty.setHistoricalFigures(dataHisFig.chuaNguyenDynasty());
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
	}
	
	// Method crawling data thoi ky hien dai
	public void dataModernPeriod() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/#thoi-bac-thuoc-111-tcn-938";
		String query1 = "h2#thoi-ky-hien-dai-1858-nay ~ p > strong > em";
		String query2 = "h2#thoi-ky-hien-dai-1858-nay ~ p";
		
		Crawling data = new Crawling();
		
		data.connectToWeb(url); 
		
		String[] nameChildPeriod = {"", "", "", "", "", ""};
		String[] yearChildPeriod = {"", "", "", "", "", ""};
		String[] contentChildPeriod = {"", "", "", "", "", ""};
		int i=0, j=0;
		
        // Query 1 : name and year child period
		Elements resultQuery =  data.crawlingData(query1);
		for (Element element : resultQuery) {
            if (i != 1) {
            	String str = element.text();
            	nameChildPeriod[i] = str.substring(0, str.indexOf("("));
                yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            }
            else {
            	String str = element.text();
            	nameChildPeriod[i] = str;
                yearChildPeriod[i] = "1945-1976";
            }
            i++;
            if (i == 4) break;
        }
		// Query 2 : content of each period
		resultQuery =  data.crawlingData(query2);
        for (Element element : resultQuery) {
        	j++;

        	switch (j) {
			case 2: {
				String str = element.text();
				contentChildPeriod[0] = contentChildPeriod[0].concat(str);
				break;
			}
			case 5: {
				String str = element.text();
				contentChildPeriod[1] = contentChildPeriod[1].concat(str);
				break;
			}
			case 7:
			case 8:
			case 9: {
				String str = element.text();
				contentChildPeriod[2] = contentChildPeriod[2].concat(str);
				break;
			}
			case 11: 
			case 12:
			case 13: {
				String str = element.text();
				contentChildPeriod[3] = contentChildPeriod[3].concat(str);
				break;
			}
			case 14: 
				break;
			}
        	
        	if (j == 14) break;
        }
        
        for (int jj=0; jj<4; jj++) {
        	HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[jj], yearChildPeriod[jj], contentChildPeriod[jj]);
        	childPeriodList.add(hisChildPeriod);
        }
        
     // complete hisPeriod5
     		hisPeriod5.setChildPeriodList(childPeriodList);
	}

	// main fuction
	public void crawlingAndSaveToFile(File file) throws Exception {
		HistoricalPeriods hisVNPeriods = new HistoricalPeriods();
		
		DataHisDynasties data = new DataHisDynasties();
		
		// crawling data
		data.dataPrehistoric();
		data.dataAncient();
		data.dataColonyTime();
		data.dataMonarchyPeriod();
		data.dataModernPeriod();
		
		// add period to list period 
		hisVNPeriods.addElement(hisPeriod1);
		hisVNPeriods.addElement(hisPeriod2);
		hisVNPeriods.addElement(hisPeriod3);
		hisVNPeriods.addElement(hisPeriod4);
		hisVNPeriods.addElement(hisPeriod5);

		ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = null;
        
		// convert java object to json and save to json file
        try {
        	
        	if (file != null) {
        	
//            System.out.println("Chuyển đổi đối tượng thành chuỗi JSON:");
//            jsonInString = mapper.writeValueAsString(hisPeriod1);
//            System.out.println(jsonInString);
//            System.out.println();
 
//            System.out.println("Chuyển đổi đối tượng thành chuỗi JSON với Format:");
//            jsonInString = mapper.writerWithDefaultPrettyPrinter()
//                    .writeValueAsString(HisVNPeriods);
//            System.out.println(jsonInString);
        	
//        	System.out.println("Lưu đối tượng dưới dạng json vào file json");
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
