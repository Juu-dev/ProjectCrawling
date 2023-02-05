package hust.hedspi.crawling.figure;

import java.util.List;

import hust.hedspi.base.hisfigure.HistoricalFigure;

public class ChuaTrinhDynastyCrawling extends FiguresCrawling implements FigCrawInterface {
	@Override
	public List<HistoricalFigure> crawling() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_ch%C3%BAa_Tr%E1%BB%8Bnh";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Chúa Trịnh");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_ch%C3%BAa_Tr%E1%BB%8Bnh";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, false, "Quan lại", "Chúa Trịnh");
		
		hisFigureList.addAll(hisFigureList1);
		return hisFigureList;
	}
}
