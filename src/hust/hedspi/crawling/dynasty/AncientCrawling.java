package hust.hedspi.crawling.dynasty;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalDynasty;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.event.WarEventsCrawling;

//method crawling data thoi ki co dai
public class AncientCrawling extends Crawling implements DynCrawInterface {
	@Override
	public HistoricalPeriod crawling() {
		HistoricalPeriod hisPeriod2 = new HistoricalPeriod("Thời kỳ cổ đại");
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		List<HistoricalDynasty> dynastyList = new ArrayList<HistoricalDynasty>();
		
		WarEventsCrawling hisEvents = new WarEventsCrawling();
		hisEvents.getWarEvents();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/";
		String query1 = "h2#thoi-ky-co-dai-2879-111-tcn ~ p > strong > em";
		String query2 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p";
		String query3 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p + p";
		String query4 = "h2#thoi-ky-co-dai-2879-111-tcn + p + p + p + p + p";
		
		connectToWeb(url);

		int i=0;
		int numberChildPeriod = 0;
		
        // Query 1 : name child period
		Elements resultQuery =  crawlingData(query1);
		for (Element element : resultQuery) {
			// handle data
            String str = element.text();
            String childPeriodName = str.substring(0, str.indexOf("("));
            String yearChildPeriod = str.substring(str.indexOf("(")+1, str.indexOf(")"));
            // add data to object
            HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(childPeriodName);
            hisChildPeriod.setYear(yearChildPeriod);
            
            switch (numberChildPeriod) {
			case 0: {
				hisChildPeriod.setEventList(hisEvents.hongBangEvents());
				break;
			}
			case 1: {
				hisChildPeriod.setEventList(hisEvents.thucEvents());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " +numberChildPeriod );
			}
            
 			
            childPeriodList.add(hisChildPeriod);
            
            numberChildPeriod++;
            i++;
            if (i == 2) break;
        }
		
		// Query 2 : name, content dynasty of period 1
		resultQuery =  crawlingData(query2);
        String str = resultQuery.text();
        String nameDynasty = str.substring(0, str.indexOf(":"));
        String contentDynasty = str.substring(str.indexOf(":") + 1, str.length()).trim();
        // add data to object
        HistoricalDynasty hisDynasty1 = new HistoricalDynasty(nameDynasty, contentDynasty);
        dynastyList.add(hisDynasty1);
        
        // Query 3 : name, content, year dynasty of period 1 
        resultQuery =  crawlingData(query3);
        str = resultQuery.text();
        // handle data
        nameDynasty = str.substring(0, str.indexOf("(")-1);
        String yearDynasty = "258-218 TCN";
        contentDynasty = str.substring(str.indexOf(":")+1, str.length()).trim();
        // add data to object
        HistoricalDynasty hisDynasty = new HistoricalDynasty(nameDynasty, yearDynasty, contentDynasty);
        dynastyList.add(hisDynasty);
        childPeriodList.get(0).setDynastyList(dynastyList);
        
        // Query 4 : content of period 2
        resultQuery =  crawlingData(query4);
        // handle data
        str = resultQuery.text();
        String contentPeriod2 = str.trim();
        // add data to object
        childPeriodList.get(1).setContent(contentPeriod2);
        hisPeriod2.setChildPeriodList(childPeriodList);
        return hisPeriod2;
	}
}
