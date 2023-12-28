import java.awt.geom.PathIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		// root node
		GoogleQuery googleQuery = new GoogleQuery("小說");
		ArrayList<String> googleList = new ArrayList<>();
		googleList = googleQuery.query();
		ArrayList<WebPage> webPagelist = new ArrayList<>();
		ArrayList<WebTree> webTreelist = new ArrayList<>();
		for(int i=0;i<googleList.size();i++) {
			WebPage rootPage = new WebPage(googleList.get(i), "googleSearch");
			webPagelist.add(rootPage);
			WebTree tree = new WebTree(rootPage);
			webTreelist.add(tree);
			OtherQuery subOtherQuery = new OtherQuery(rootPage.url);
			ArrayList<String> subList = new ArrayList<>();
			for(int j=0;j<subList.size();j++) {
				tree.root.addChild(new WebNode(new WebPage(subList.get(j),"sub")));
			}
			
		}
		WebPage rootPage = new WebPage(googleList.get(1), "googleSearch");
		WebTree tree = new WebTree(rootPage);

		// build childnode
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html", "Publication")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html", "Projects")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "Member")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Courses.html", "Course")));
		// This website has something wrong, ignore it.
		// tree.root.children.get(1).addChild(new WebNode(new WebPage("http://soslab.xyz:7777", "AppBeach")));
				
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

			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		scanner.close();
	}

}
