package hust.hedspi.crawling.figure;

import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class TranDynastyCrawling extends FiguresCrawling implements FigCrawInterface {
	@Override
	public List<HistoricalFigure> crawling() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_Tr%E1%BA%A7n";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Trần");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:C%C3%B4ng_ch%C3%BAa_nh%C3%A0_Tr%E1%BA%A7n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, false, "Công chúa", "Trần");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%AD_nh%C3%A0_Tr%E1%BA%A7n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Hoàng tử", "Trần");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Vua_nh%C3%A0_Tr%E1%BA%A7n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList3 = figureDynasty(urlList, true, "Vua", "Trần");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%99c_nh%C3%A0_Tr%E1%BA%A7n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList4 = figureDynasty(urlList, false, "Hoàng tộc", "Trần");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_Tr%E1%BA%A7n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList5 = figureDynasty(urlList, false, "Quan lại", "Trần");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		hisFigureList.addAll(hisFigureList3);
		hisFigureList.addAll(hisFigureList4);
		hisFigureList.addAll(hisFigureList5);
		
		return hisFigureList;
	}
}
