import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_A_crawlingbasic {

	public static void main(String[] args) {
		String url = "https://sports.news.naver.com/basketball/index.nhn";
		org.jsoup.nodes.Document doc = null;
		try {
			doc=Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		Elements element = doc.select("div.home_news");
		String title = element.select("h2").text().substring(0, 4);
		System.out.println("================================");
		System.out.println(title);
		System.out.println("================================");
		for(Element el : element.select("li")) {
			System.out.println(el.text());
		}
		System.out.println("================================");
		
	}

}
