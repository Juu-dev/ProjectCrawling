package hust.hedspi.crawling.figure;

import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class TienLeDynastyCrawling extends FiguresCrawling implements FigCrawInterface {
	@Override
	public List<HistoricalFigure> crawling() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_L%C3%AA_s%C6%A1";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Tiền Lê");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Vua_nh%C3%A0_Ti%E1%BB%81n_L%C3%AA";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, true, "Vua", "Tiền Lê");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%99c_nh%C3%A0_Ti%E1%BB%81n_L%C3%AA";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Hoàng tử / Công chúa", "Tiền Lê");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		
		return hisFigureList;
	}
}
