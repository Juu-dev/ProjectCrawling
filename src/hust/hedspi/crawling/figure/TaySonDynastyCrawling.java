package hust.hedspi.crawling.figure;

import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class TaySonDynastyCrawling extends FiguresCrawling implements FigCrawInterface {
	@Override
	public List<HistoricalFigure> crawling() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
				
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_T%C3%A2y_S%C6%A1n";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Tây Sơn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Vua_nh%C3%A0_T%C3%A2y_S%C6%A1n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, true, "Vua", "Tây Sơn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%99c_nh%C3%A0_T%C3%A2y_S%C6%A1n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Hoàng tộc", "Tây Sơn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_T%C3%A2y_S%C6%A1n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList3 = figureDynasty(urlList, false, "Quan lại", "Tây Sơn");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		hisFigureList.addAll(hisFigureList3);
		return hisFigureList;
	}
}
