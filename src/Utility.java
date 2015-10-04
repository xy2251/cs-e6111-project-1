import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

//Download and add this library to the build path.

public class Utility {
	static String bingUrl = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%27gates%27&$top=10&$format=Atom";
	public static void main(String[] args) throws IOException {
		
		InputStream inputStream = new FileInputStream("output.xml");
		Document doc = Jsoup.parse(inputStream, "UTF-8", bingUrl, Parser.xmlParser());
		int id = 0;
		for (Element e : doc.select("entry > content")) {
			String title = e.getElementsByTag("d:title").first().text();
			String url = e.getElementsByTag("d:url").first().text();
			String description = e.getElementsByTag("d:description").first().text();
			System.out.println("Page "+ (id++) + ":");
			System.out.println("title: " + title);
			System.out.println("url: " + url);
			System.out.println("description: " + description);

		}
	}

}