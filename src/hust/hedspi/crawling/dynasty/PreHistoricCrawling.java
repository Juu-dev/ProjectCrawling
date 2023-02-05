package hust.hedspi.crawling.dynasty;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

import hust.hedspi.base.hisperiod.HistoricalChildPeriod;
import hust.hedspi.base.hisperiod.HistoricalPeriod;
import hust.hedspi.crawling.Crawling;

//method crawling data thoi ki tien su
public class PreHistoricCrawling extends Crawling implements DynCrawInterface {
	@Override
	public HistoricalPeriod crawling() {
		HistoricalPeriod hisPeriod1 = new HistoricalPeriod("Thời kỳ tiền sử");
		List<HistoricalChildPeriod> childPeriodList = new ArrayList<HistoricalChildPeriod>();
		
		String url = "https://vi.wikipedia.org/wiki/L%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam#Th%E1%BB%9Di_k%E1%BB%B3_ti%E1%BB%81n_s%E1%BB%AD";
		String query1 = "h3 > span + span[id^=\"Thời_đại_đồ\"]";
		String query2 = "div.mw-parser-output > h3 + div + p";
		
		connectToWeb(url);
		
        // Query 1 : name and content Child period
		Elements resultQuery1 =  crawlingData(query1);
		Elements resultQuery2 =  crawlingData(query2);
		
		for (int i=0; i<resultQuery1.size(); i++) {
			HistoricalChildPeriod hisChildPeriod = new HistoricalChildPeriod(resultQuery1.get(i).text(), resultQuery2.get(i).text());
			childPeriodList.add(hisChildPeriod);
        }

		// complete hisPeriod1
		hisPeriod1.setChildPeriodList(childPeriodList);
		return hisPeriod1;
	}
}
