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

public class GoogleQuery1 {

	public String url;
	public String content;

	public GoogleQuery1(String url) {

		try {
			this.url = url;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String fetchContent() throws IOException {

		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		// set HTTP header
		conn.setRequestProperty("User-agent", "Chrome/107.0.5304.107");
		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while ((line = bufReader.readLine()) != null) {
			retVal += line;
		}
		return retVal;
	}

	public ArrayList<String> query() {
		ArrayList<String> output = new ArrayList<>();
		try {
			if (content == null) {
				content = fetchContent();
			}
			Document doc = Jsoup.parse(content);
			Elements lis = doc.select("div").select(".kCrYT");

			for (Element li : lis) {
				try {
					String citedUrl = li.select("a").get(0).attr("href").replace("/url?q=", "");
					String decodedUrl = URLDecoder.decode(citedUrl, StandardCharsets.UTF_8.name());

					int endIndex = decodedUrl.indexOf("&sa=");
					if (endIndex != -1) {
						decodedUrl = decodedUrl.substring(0, endIndex);
					}

					// 檢查是否為完整URL
					if (!decodedUrl.startsWith("http://") && !decodedUrl.startsWith("https://")) {
						decodedUrl = url + decodedUrl;
					}

					if (!output.contains(decodedUrl)) {
						output.add(decodedUrl);
					}
				} catch (Exception e) {
					// 處理錯誤
				}
			}
		} catch (Exception e) {
			// 處理錯誤
		}
		return output;

	}

}
