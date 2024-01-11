import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;

	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);
	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		// calculate the score of this webPage
		for (int i = 0; i < keywords.size(); i++) {
			score += counter.countKeyword(keywords.get(i).name) * keywords.get(i).weight;
		}

	}

	public double getScore() {

		return score;

	}

}
