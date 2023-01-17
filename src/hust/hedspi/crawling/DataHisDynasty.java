package hust.hedspi.crawling;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisPeriod.HistoricalChildPeriod;
import hust.hedspi.base.hisPeriod.HistoricalDynasty;
import hust.hedspi.base.hisPeriod.HistoricalPeriod;

public class DataHisDynasty {
	static HistoricalPeriod hisPeriod1 = new HistoricalPeriod("Thời kỳ tiền sử");
	static HistoricalPeriod hisPeriod2 = new HistoricalPeriod("Thời kỳ cổ đại");
	static HistoricalPeriod hisPeriod3 = new HistoricalPeriod("Thời kỳ Bắc thuộc");
	static HistoricalPeriod hisPeriod4 = new HistoricalPeriod("Thời kỳ quân chủ");
	static HistoricalPeriod hisPeriod5 = new HistoricalPeriod("Thời kỳ hiện đại");
	
	// method crawling data thoi ki tien su
	public static void dataPrehistoric() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		
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
	public static void dataAncient() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/";
		String query1 = "h2#thoi-ky-co-dai-2879-111-tcn ~ p > strong > em";
		String query2 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p";
		String query3 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p + p";
		String query4 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p + p + p";
		
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
            // add childPeriodList
            childPeriodList.add(hisChildPeriod);
            i++;
            if (i == 2) break;
        }
		
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
	public static void dataColonyTime(String[] args) {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		
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
            System.out.println(nameChildPeriod[i]);
            System.out.println(yearChildPeriod[i]);
            i++;
            if (i == 4) break;
        }
		
		// Query 1_1 : name child period
		resultQuery =  data.crawlingData(query1_ex1);
		for (Element element : resultQuery) {
            String str = element.text();
            nameChildPeriod[i] = str.substring(0, str.indexOf("("));
            yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            System.out.println(nameChildPeriod[i]);
            System.out.println(yearChildPeriod[i]);
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
        	childPeriodList.add(hisChildPeriod);
        }
        
        // complete hisPeriod3
     	hisPeriod3.setChildPeriodList(childPeriodList);
	}
	
	
	// Method crawling data 10 trieu dai phong kien viet nam
	public static void dataMonarchyPeriod() {
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
		
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
		String[] nameKingsDynasties = {"", "", "", "", "", "", "", "", "", ""};
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
            String nameKings = element.text();
            nameKings = nameKings.substring(nameKings.indexOf(':')+1, nameKings.length());
            nameKingsDynasties[i] = nameKingsDynasties[i].concat(nameKings);
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
        
        
        
        
	}
	
	
	
	
	// Method crawling data thoi ky hien dai
//	public static void main(String[] args) {
//		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/#thoi-bac-thuoc-111-tcn-938";
//		String query1 = "h2#thoi-ky-hien-dai-1858-nay ~ p > strong > em";
//		String query2 = "h2#thoi-ky-hien-dai-1858-nay ~ p";
//		
//		Crawling data = new Crawling();
//		
//		data.connectToWeb(url); 
//		
//		String[] childPeriod = {"", "", "", "", "", ""};
//		String[] yearChildPeriod = {"", "", "", "", "", ""};
//		String[] contentChildPeriod = {"", "", "", "", "", ""};
//		int i=0, j=0;
//		
//        // Query 1 : name child period
//		Elements resultQuery =  data.crawlingData(query1);
//		for (Element element : resultQuery) {
//            if (i != 1) {
//            	String str = element.text();
//                childPeriod[i] = str.substring(0, str.indexOf("("));
//                yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
//                System.out.println(childPeriod[i]);
//                System.out.println(yearChildPeriod[i]);
//            }
//            else {
//            	String str = element.text();
//                childPeriod[i] = str;
//                yearChildPeriod[i] = "1945-1976";
//                System.out.println(childPeriod[i]);
//                System.out.println(yearChildPeriod[i]);
//            }
//            i++;
//            if (i == 4) break;
//        }
//		// Query 2 : content of each period
//		resultQuery =  data.crawlingData(query2);
//        for (Element element : resultQuery) {
//        	j++;
//
//        	switch (j) {
//			case 2: {
//				String str = element.text();
//				contentChildPeriod[0] = contentChildPeriod[0].concat(str);
//				break;
//			}
//			case 5: {
//				String str = element.text();
//				contentChildPeriod[1] = contentChildPeriod[1].concat(str);
//				break;
//			}
//			case 7:
//			case 8:
//			case 9: {
//				String str = element.text();
//				contentChildPeriod[2] = contentChildPeriod[2].concat(str);
//				break;
//			}
//			case 11: 
//			case 12:
//			case 13: {
//				String str = element.text();
//				contentChildPeriod[3] = contentChildPeriod[3].concat(str);
//				break;
//			}
//			case 14: 
//				break;
//			}
//        	
//        	if (j == 14) break;
//        }
//        
//        for (int jj=0; jj<4; jj++) {
//        	System.out.println(contentChildPeriod[jj]);
//        	System.out.println();
//        }
//	}

	public static void main(String[] args) {
		
	}
	
}
