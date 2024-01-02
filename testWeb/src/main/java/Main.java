import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*public class Main 
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
    
}*/


import java.io.IOException;
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
            ArrayList<Keyword> keywords = KeywordConfig.getKeywordsWithInput(googleInput, 1000.0);

            for (int i = 0; i < googleSiteList.size(); i++) {
                WebPage page = new WebPage(googleSiteList.get(i), googleNameList.get(i));
                //page.setScore(keywords); 
                //webPages.add(page); 
                try {
                    page.setScore(keywords);
                    webPages.add(page); 
                } catch (IOException e) {
                    System.out.println("Error setting score for URL: " + page.url);
                    // 在这里添加逻辑以处理无法访问的网址，比如记录日志、跳过当前网址等
                    continue; // 跳过当前的循环迭代
                }
                System.out.println(i);
            }

            Sort sort = new Sort(webPages);
            sort.sortSite(0, webPages.size()-1);

            // print 排序後結果
            for (WebPage page : webPages) {
                System.out.println("URL: " + page.url + page.name + " - Score: " + page.score);
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}