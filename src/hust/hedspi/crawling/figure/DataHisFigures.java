package hust.hedspi.crawling.figure;

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
import hust.hedspi.base.hisfigure.HistoricalFigures;
import hust.hedspi.crawling.Crawling;
import hust.hedspi.crawling.dataHisInterface;

public class DataHisFigures implements dataHisInterface {
	public HistoricalFigures hisVNFigures = new HistoricalFigures();
	
	// Methods
	
	// get url list
	public List<String> getUrlList(String url, String query, String preUrl) {
		List<String> urlList = new ArrayList<String>();
		
		Crawling data = new Crawling();
		data.connectToWeb(url);
		
		Elements resultQuery = data.crawlingData(query);
		
		for (Element figure : resultQuery) {
			String newUrl = preUrl + figure.attr("href");
			
			urlList.add(newUrl);
		}
		
		return urlList;
	}
	
	// Figure Dynasty
	public List<HistoricalFigure> figureDynasty(List<String> urlList, boolean king, String job, String nameDynasty) {
		Crawling data = new Crawling();
		List<HistoricalFigure> hisFigureList = new ArrayList<HistoricalFigure>();

		String query1 = "h1#firstHeading > span";
		String query2 = "div.mw-parser-output > p";
		
		for (String newUrl: urlList) {
			data.connectToWeb(newUrl);
			
			String nameFigure = data.crawlingData(query1).text();
			String contentFigure = data.crawlingData(query2).text();
			boolean isKing = king;
			String jobFigure = job;
			String nameDynastyFigure = new String(nameDynasty);
			
			HistoricalFigure hisFigure = new HistoricalFigure(nameFigure, contentFigure, isKing, jobFigure, nameDynastyFigure);
			hisFigureList.add(hisFigure);
		}
		
		return hisFigureList;
	}
	
	// Tien le Dynasty
	public List<HistoricalFigure> tienLeDynasty() {
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
	
	// Tran Dynasty
	public List<HistoricalFigure> tranDynasty() {
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
	
	// Tay son Dynasty 
	public List<HistoricalFigure> taySonDynasty() {
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
	
	// Nguyen Dynasty
	public List<HistoricalFigure> nguyenDynasty() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_Nguy%E1%BB%85n";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Nguyễn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:C%C3%B4ng_ch%C3%BAa_nh%C3%A0_Nguy%E1%BB%85n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, false, "Công chúa", "Nguyễn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%AD_nh%C3%A0_Nguy%E1%BB%85n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Hoàng tử", "Nguyễn");
		
//		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_h%E1%BA%ADu_nh%C3%A0_Nguy%E1%BB%85n";
//		urlList = getUrlList(url, query, preUrl);
//		List<HistoricalFigure> hisFigureList3 = figureDynasty(urlList, false, "Hoàng hậu", "Nguyễn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%99c_nh%C3%A0_Tr%E1%BA%A7n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList4 = figureDynasty(urlList, false, "Hoàng tộc", "Nguyễn");
		
		url = "https://vi.wikipedia.org/w/index.php?title=Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_Nguy%E1%BB%85n&pageuntil=Ph%E1%BA%A1m+Huy+Quang#mw-pages";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList5 = figureDynasty(urlList, false, "Quan lại", "Nguyễn");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
//		hisFigureList.addAll(hisFigureList3);
		hisFigureList.addAll(hisFigureList4);
		hisFigureList.addAll(hisFigureList5);
		
		return hisFigureList;
	}
	
	// Ngo Dynasty
	public List<HistoricalFigure> ngoDynasty() {
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_Ng%C3%B4";
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		List<String> urlList = getUrlList(url, query, preUrl);
		
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Ngô");
		
		return hisFigureList;
	}
	
	// Mac Dynasty
	public List<HistoricalFigure> macDynasty() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_M%E1%BA%A1c";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Mạc");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:C%C3%B4ng_ch%C3%BAa_nh%C3%A0_M%E1%BA%A1c";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, false, "Công chúa", "Mạc");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%AD_nh%C3%A0_M%E1%BA%A1c";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Hoàng tử", "Mạc");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_M%E1%BA%A1c";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList3 = figureDynasty(urlList, false, "Quan lại", "Mạc");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		hisFigureList.addAll(hisFigureList3);
		
		return hisFigureList;
	}
	
	// Ly Dynasty
	public List<HistoricalFigure> lyDynasty() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_L%C3%BD";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Lý");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:C%C3%B4ng_ch%C3%BAa_nh%C3%A0_L%C3%BD";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, false, "Công chúa", "Lý");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Vua_nh%C3%A0_L%C3%BD";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, true, "Vua", "Lý");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%99c_nh%C3%A0_L%C3%BD";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList3 = figureDynasty(urlList, false, "Hoàng tộc", "Lý");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_L%C3%BD";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList4 = figureDynasty(urlList, false, "Quan lại", "Lý");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		hisFigureList.addAll(hisFigureList3);
		hisFigureList.addAll(hisFigureList4);
		
		return hisFigureList;
	}
	
	// Ho Dynasty
	public List<HistoricalFigure> hoDynasty() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_H%E1%BB%93";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Hồ");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Vua_nh%C3%A0_H%E1%BB%93";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, true, "Vua", "Hồ");

		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_H%E1%BB%93";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Quan lại", "Hồ");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		
		return hisFigureList;
	}
		
	// Hai ba trung Dynasty
	public List<HistoricalFigure> haiBaTrungDynasty() {
		String url = "https://vi.wikipedia.org/wiki/Hai_B%C3%A0_Tr%C6%B0ng";
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		List<String> urlList = getUrlList(url, query, preUrl);
		
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Nữ tướng", "Hai bà trưng");
		
		return hisFigureList;
	}
		
	// Dinh Dynasty
	public List<HistoricalFigure> dinhDynasty() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_nh%C3%A0_%C4%90inh";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Đinh");

		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Vua_nh%C3%A0_%C4%90inh";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, true, "Vua", "Đinh");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Ho%C3%A0ng_t%E1%BB%AD_nh%C3%A0_%C4%90inh";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList2 = figureDynasty(urlList, false, "Hoàng tử", "Đinh");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_nh%C3%A0_%C4%90inh";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList3 = figureDynasty(urlList, false, "Quan lại", "Đinh");
		
		hisFigureList.addAll(hisFigureList1);
		hisFigureList.addAll(hisFigureList2);
		hisFigureList.addAll(hisFigureList3);
		
		return hisFigureList;
	}

	// Chua Trinh Dynasty
	public List<HistoricalFigure> chuaTrinhDynasty() {
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
		
	// Chua Nguyen Dynasty
	public List<HistoricalFigure> chuaNguyenDynasty() {
		String query = "div.mw-category-group > ul > li > a";
		String preUrl = "https://vi.wikipedia.org";
		
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:V%C3%B5_t%C6%B0%E1%BB%9Bng_ch%C3%BAa_Nguy%E1%BB%85n";
		List<String> urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList = figureDynasty(urlList, false, "Võ tướng", "Chúa Nguyễn");
		
		url = "https://vi.wikipedia.org/wiki/Th%E1%BB%83_lo%E1%BA%A1i:Quan_l%E1%BA%A1i_ch%C3%BAa_Nguy%E1%BB%85n";
		urlList = getUrlList(url, query, preUrl);
		List<HistoricalFigure> hisFigureList1 = figureDynasty(urlList, false, "Quan lại", "Chúa Nguyễn");
		
		hisFigureList.addAll(hisFigureList1);
		
		return hisFigureList;
	}
	
	// get all figure in VN's history
	public HistoricalFigures getAllFigures1() {
		HistoricalFigures hisVNFigures = new HistoricalFigures();
		List<HistoricalFigure> figuresExp = new ArrayList<HistoricalFigure>();
		
		figuresExp = tienLeDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = tranDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = taySonDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = nguyenDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = ngoDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = lyDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = hoDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = haiBaTrungDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = dinhDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = chuaTrinhDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		figuresExp = chuaNguyenDynasty();
		hisVNFigures.addAllElement(figuresExp);
		
		return hisVNFigures;
	}

	// get all figure in VN's history
	public List<HistoricalFigure> getAllFigures2() {
			List<HistoricalFigure> figuresExp = new ArrayList<HistoricalFigure>();
			List<HistoricalFigure> allFigures = new ArrayList<HistoricalFigure>();
			
			figuresExp = tienLeDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = tranDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = taySonDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = nguyenDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = ngoDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = lyDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = hoDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = haiBaTrungDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = dinhDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = chuaTrinhDynasty();
			allFigures.addAll(figuresExp);
			
			figuresExp = chuaNguyenDynasty();
			allFigures.addAll(figuresExp);
			
			return allFigures;
		}

	@Override
	public void crawlingAndSaveToFile(File file) throws Exception {
		// data sites
		hisVNFigures = getAllFigures1();
		
		// Write JSON file to the root folder
		ObjectMapper mapper = new ObjectMapper();
		try {
      	
			if (file != null) {	
      		// System.out.println("Lưu đối tượng dưới dạng json vào file json");
	      	mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(file, hisVNFigures);
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
