import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static ArrayList<Keyword> keywords;

	public static void main(String[] args) {
		try {
			System.out.println("Please input the google search: ");
			Scanner input = new Scanner(System.in);
			String googleInput = input.next();
	        String searchKeyword = googleInput + (isEnglish(googleInput) ? " novel" : " 小說");

			// 使用主搜索關鍵詞進行Google搜索
			GoogleQuery google = new GoogleQuery(searchKeyword + "");
			google.query();
			ArrayList<String> googleNameList = google.outputName;
			ArrayList<String> googleSiteList = google.outputSite;
			ArrayList<WebPage> webPages = new ArrayList<>();

			// 使用主搜索關鍵詞進行Google搜索
			ArrayList<Keyword> keywords = KeywordConfig.getKeywords(googleInput, 1000.0);

			for (int i = 0; i < googleSiteList.size(); i++) {
				WebPage page = new WebPage(googleSiteList.get(i), googleNameList.get(i));
				// page.setScore(keywords);
				// webPages.add(page);
				try {
					page.setScore(keywords);
					webPages.add(page);
				} catch (IOException e) {
					System.out.println("Error setting score for URL: " + page.url);
					// 在這裡加邏輯以處裡無法訪問的網址，比如紀錄日誌、跳過當前網址等
					continue; // 跳過當前的循環迭代
				}
				System.out.println(i);
			}

			Sort sort = new Sort(webPages);
			sort.sortSite(0, webPages.size() - 1);
			sort.delcontact(webPages);
			// sort_包含這些內容的名稱刪除

			// print 排序後結果
			for (WebPage page : webPages) {
				System.out.println("URL: " + page.url + " - Score: " + page.score + "\n" + page.name);
			}

			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static boolean isEnglish(String text) {
	        return text.matches("[A-Za-z ]+");
    }
}
