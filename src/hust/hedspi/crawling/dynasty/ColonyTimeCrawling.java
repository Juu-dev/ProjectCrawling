package hust.hedspi.crawling.dynasty;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.event.WarEventsCrawling;
import hust.hedspi.crawling.figure.HaiBaTrungDynastyCrawling;

//method crawling data thoi ki bac thuoc
public class ColonyTimeCrawling extends Crawling implements DynCrawInterface {
	@Override
	public HistoricalPeriod crawling() {
		HistoricalPeriod hisPeriod3 = new HistoricalPeriod("Thời kỳ Bắc thuộc");
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		HaiBaTrungDynastyCrawling haiBaTrungDyn = new HaiBaTrungDynastyCrawling();
		
		WarEventsCrawling hisEvents = new WarEventsCrawling();
		hisEvents.getWarEvents();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/#thoi-bac-thuoc-111-tcn-938";
		String query1 = "h2#thoi-bac-thuoc-111-tcn-938 ~ p > strong > em";
		String query1_ex1 = "h2#thoi-bac-thuoc-111-tcn-938 ~ h2";
		String query2 = "h2#thoi-bac-thuoc-111-tcn-938 ~ p";
		
		connectToWeb(url);
		
		String[] nameChildPeriod = {"", "", "", "", "", ""};
		String[] yearChildPeriod = {"", "", "", "", "", ""};
		String[] contentChildPeriod = {"", "", "", "", "", ""};
		
		int i=0, j=0;
		int numberChildPeriod = 3;
		
        // Query 1 : name child period
		Elements resultQuery =  crawlingData(query1);
		for (Element element : resultQuery) {
            String str = element.text();
            nameChildPeriod[i] = str.substring(0, str.indexOf("("));
            yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            i++;
            if (i == 4) break;
        }
		
		// Query 1_1 : name child period
		resultQuery =  crawlingData(query1_ex1);
		for (Element element : resultQuery) {
            String str = element.text();
            nameChildPeriod[i] = str.substring(0, str.indexOf("("));
            yearChildPeriod[i] = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            i++;
            if (i == 6) break;
        }
		
		// Query 2 : content of each period
		resultQuery =  crawlingData(query2);
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
        
        // set dataHisEvents in child period
        for (int jj=0; jj<6; jj++) {
        	HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(nameChildPeriod[jj], yearChildPeriod[jj], contentChildPeriod[jj]);
 			
 			switch (numberChildPeriod) {
			case 3: {
				hisChildPeriod.setEventList(hisEvents.bacThuocLan1Events());
				break;
			}
			case 4: {
				hisChildPeriod.setEventList(hisEvents.trungVuongEvents());
				break;
			}
			case 5: {
				hisChildPeriod.setEventList(hisEvents.bacThuocLan2Events());
				break;
			}
			case 6: {
				hisChildPeriod.setEventList(hisEvents.tienLyEvents());
				break;
			}
			case 7: {
				hisChildPeriod.setEventList(hisEvents.bacThuocLan3Events());
				break;
			}
			case 8: {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + numberChildPeriod);
			}
 			
 			numberChildPeriod++;
 			// set dataHisFigure
 			if (jj == 1) {
 				hisChildPeriod.setFigureList(haiBaTrungDyn.crawling());
        	}
 			
        	childPeriodList.add(hisChildPeriod);
        }
        
        // complete hisPeriod3
     	hisPeriod3.setChildPeriodList(childPeriodList);
     	return hisPeriod3;
	}
}
