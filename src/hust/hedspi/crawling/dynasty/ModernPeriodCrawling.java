package hust.hedspi.crawling.dynasty;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.event.WarEventsCrawling;

//Method crawling data thoi ky hien dai
public class ModernPeriodCrawling extends Crawling implements DynCrawInterface {
	@Override
	public HistoricalPeriod crawling() {
		HistoricalPeriod hisPeriod5 = new HistoricalPeriod("Thời kỳ hiện đại");
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		
		WarEventsCrawling hisEvents = new WarEventsCrawling();
		hisEvents.getWarEvents();
		
		String url = "https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/#thoi-bac-thuoc-111-tcn-938";
		String query1 = "h2#thoi-ky-hien-dai-1858-nay ~ p > strong > em";
		String query2 = "h2#thoi-ky-hien-dai-1858-nay ~ p";

		connectToWeb(url); 
		
		String[] nameChildPeriod = {"", "", "", "", "", ""};
		String[] yearChildPeriod = {"", "", "", "", "", ""};
		String[] contentChildPeriod = {"", "", "", "", "", ""};
		int i=0, j=0;
		
        // Query 1 : name and year child period
		Elements resultQuery =  crawlingData(query1);
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
		resultQuery =  crawlingData(query2);
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
        	if (jj ==0) {
        		hisChildPeriod.setEventList(hisEvents.nhatThuocEvents());
        	}
        	childPeriodList.add(hisChildPeriod);
        }
        
        // complete hisPeriod5
     	hisPeriod5.setChildPeriodList(childPeriodList);
     	return hisPeriod5;
	}
}
