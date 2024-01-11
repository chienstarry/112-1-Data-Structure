import java.awt.geom.PathIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery {

	public String searchKeyword;
	public String url;
	public String content;
	public ArrayList<String> outputName = new ArrayList<>();
	public ArrayList<String> outputSite = new ArrayList<>();

	public GoogleQuery(String searchKeyword) {

		this.searchKeyword = searchKeyword;
		try {

			String encodeKeyword = java.net.URLEncoder.encode(searchKeyword, "utf-8");
			this.url = "https://www.google.com/search?q=" + encodeKeyword + "&oe=utf8&num=10";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String fetchContent() throws IOException {

		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		// set HTTP header
		conn.setRequestProperty("User-agent", "Chrome/107.0.5304.106");
		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while ((line = bufReader.readLine()) != null) {
			retVal += line;
		}
		return retVal;
	}

	public HashMap<String, String> query() throws IOException {
		if (content == null) {
			content = fetchContent();
		}

		Document doc = Jsoup.parse(content);
		HashMap<String, String> sites = new HashMap<String, String>();
		Elements lis = doc.select("div").select(".kCrYT");

		for (Element li : lis) {

			try {
				String encodeUrl = li.select("a").get(0).attr("href").replace("/url?q=", "");
				String decodedUrl = URLDecoder.decode(encodeUrl, StandardCharsets.UTF_8.name());
				// 刪除不需要的部分，'&sa=' 之後的
				String title = li.select("a").get(0).select(".vvjwJb").text();

				if (title.equals("")) {
					continue;
				}
				int endIndex = decodedUrl.indexOf("&sa=");
				if (endIndex != -1) {
					decodedUrl = decodedUrl.substring(0, endIndex);
				}
				// 儲存url
				outputSite.add(decodedUrl);
				outputName.add(title);
				sites.put(title, decodedUrl);

			} catch (Exception e) {
				// 處理錯誤(print 錯誤)
			}
		}
		return sites;
	}
}