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

public class OtherQuery 
{
	public String url;
	public String content;
	
	public OtherQuery(String url)
	{
		try 
		{
			this.url = url;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private String fetchContent() throws IOException
	{
		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		//set HTTP header
		conn.setRequestProperty("User-agent", "Chrome/107.0.5304.107");
		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line = bufReader.readLine()) != null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public ArrayList<String> query() throws IOException
	{
		ArrayList<String> output = new ArrayList<>();
		if(content == null)
		{
			content = fetchContent();
		}
		//using Jsoup analyze html string
		Document doc = Jsoup.parse(content);
		
		//select particular element(tag) which you want 
		Elements lis = doc.select("div");
//		lis = lis.select(".kCrYT");
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href").replace("/url?q=", "");
				if((citeUrl.length()>1)) {
					citeUrl = url+citeUrl;
					if(output.indexOf(citeUrl)==-1) {
						output.add(citeUrl);
					}
				}
//				String title = li.select("a").get(0).select(".vvjwJb").text();
//				String title = "title";
//				if(title.equals("")) 
//				{
//					continue;
//				}
				
//				System.out.println("Title: " + title + " , url: " + citeUrl);
//				System.out.println("url: " + citeUrl);
				
				//put title and pair into HashMap
//				retVal.put("title", citeUrl);
//				output.add(citeUrl);
//				count++;

			} catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		
//		return retVal;
		return output;
	}
	public ArrayList<String> query1() throws IOException
	{
		ArrayList<String> output = new ArrayList<>();
		if(content == null)
		{
			content = fetchContent();
		}
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		int count = 0;
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href").replace("/url?q=", "");
				citeUrl = url+citeUrl;
				output.add(citeUrl);
				count++;

			} catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		
		return output;
	}
}

