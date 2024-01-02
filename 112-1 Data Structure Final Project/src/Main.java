import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*public class Main 
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("Please input the google search: ");
			Scanner input = new Scanner(System.in);
			String googleInput = input.next();
			GoogleQuery google = new GoogleQuery(googleInput+" 小說");
			google.query();
			ArrayList<String> googleNameList = google.outputName;
			ArrayList<String> googleSiteList = google.outputSite;
			for (String site : googleSiteList) {
                System.out.println("Google Search URL: " + site);
            }
//			System.out.println(googleNameList);
//			System.out.println(googleSiteList);
			ArrayList<WebPage> webPagelist = new ArrayList<>();
			ArrayList<WebTree> webTreelist = new ArrayList<>();
			for(int i=0;i<googleNameList.size();i++) {
				WebPage rootPage = new WebPage(googleSiteList.get(i),googleNameList.get(i));
//				System.out.println(rootPage.url);
				webPagelist.add(rootPage);
				WebTree tree = new WebTree(rootPage);
				webTreelist.add(tree);
				GoogleQuery1 subSearch = new GoogleQuery1(googleSiteList.get(i));
				ArrayList<String> subList = new ArrayList<>();
				subList = subSearch.query();
				if(subList!=null) {
					for(int j=0;j<subList.size();j++) {
						tree.root.addChild(new WebNode(new WebPage(subList.get(j),"sub"+j)));
					}
				}
//				System.out.println(tree.root.children);
//				System.out.println(subList);
			}
			System.out.println("Please input (1)num of keywords (2)name and weight:");
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNextLine())
			{
				int numOfKeywords = scanner.nextInt();
				ArrayList<Keyword> keywords = new ArrayList<Keyword>();

				for (int i = 0; i < numOfKeywords; i++)
				{
					String name = scanner.next();
					double weight = scanner.nextDouble();
					Keyword k = new Keyword(name, weight);
					keywords.add(k);
				}

				for(int i=0;i<webTreelist.size();i++) {
//					if(webTreelist.get(i).root.children!=null) {
						webTreelist.get(i).setPostOrderScore(keywords);;
						webTreelist.get(i).eularPrintTree();
//					}
//					else {
//						
//					}
				}
			}
			scanner.close();
			input.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static ArrayList<Keyword> keywords;
    public static void main(String[] args) 
    {
        try 
        {
            System.out.println("Please input the google search: ");
            Scanner input = new Scanner(System.in);
            String googleInput = input.next();
            
            // 使用主搜索關鍵詞進行Google搜索
            GoogleQuery google = new GoogleQuery(googleInput + "小說");
            google.query();
            ArrayList<String> googleNameList = google.outputName;
            ArrayList<String> googleSiteList = google.outputSite;
            
            
			//print 網址（最後刪掉）
            // count to know the count of output url
            int count = 0;
            for (String site : googleSiteList) {
                System.out.println("Google Search URL: " + site);
                count++;
            }
            for (String name : googleNameList) {
                System.out.println("name: " + name);
               
            }

            System.out.print(count);

            
            ArrayList<WebPage> webPagelist = new ArrayList<>();
            ArrayList<WebTree> webTreelist = new ArrayList<>();

            
            // 搜尋結果處理
            for (int i = 0; i < googleNameList.size(); i++) {
                WebPage rootPage = new WebPage(googleSiteList.get(i), googleNameList.get(i));
                webPagelist.add(rootPage);
                WebTree tree = new WebTree(rootPage);
                webTreelist.add(tree);
                GoogleQuery1 subSearch = new GoogleQuery1(googleSiteList.get(i));
                ArrayList<String> subList = subSearch.query();
                if (subList != null) {
                    for (int j = 0; j < subList.size(); j++) {
                        tree.root.addChild(new WebNode(new WebPage(subList.get(j), "sub" + j)));
                    }
                }
            }
            
            ArrayList<Keyword> keywords = KeywordConfig.getKeywordsWithInput(googleInput, 10.0);

        
            // print tree
            for (int i = 0; i < webTreelist.size(); i++) {
                webTreelist.get(i).setPostOrderScore(keywords);
                webTreelist.get(i).eularPrintTree();
            }

            input.close();
            
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
}

/*import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Please input the google search: ");
            Scanner input = new Scanner(System.in);
            String googleInput = input.next();

            // 使用主搜索關鍵詞進行Google搜索
            GoogleQuery google = new GoogleQuery(googleInput + "小說");
            google.query();
            ArrayList<String> googleNameList = google.outputName;
            ArrayList<String> googleSiteList = google.outputSite;

            ArrayList<WebPage> webPages = new ArrayList<>();

            // 使用主搜索關鍵詞進行Google搜索
            ArrayList<Keyword> keywords = new ArrayList<>();

            keywords.add(new Keyword(googleInput, 10.0));
            keywords.add(new Keyword("小說", 3.0));
            keywords.add(new Keyword("作者", 4.0));
            keywords.add(new Keyword("最新", 2.0));
            keywords.add(new Keyword("介紹", 1.0));
            keywords.add(new Keyword("博客來", -1000.0));
            keywords.add(new Keyword("誠品", -1000.0));
            


            for (int i = 0; i < googleSiteList.size(); i++) {
                WebPage page = new WebPage(googleSiteList.get(i), googleNameList.get(i));
                page.setScore(keywords); 
                webPages.add(page); 
            }

            // 排序
            List<WebPage> sortedPages = webPages.stream()
                .sorted((page1, page2) -> Double.compare(page2.score, page1.score))
                .collect(Collectors.toList());

            // print 排序後結果
            for (WebPage page : sortedPages) {
                System.out.println("URL: " + page.url + page.name + " - Score: " + page.score);
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/


