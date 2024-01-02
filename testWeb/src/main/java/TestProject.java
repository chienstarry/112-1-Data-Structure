import java.awt.print.Pageable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (request.getParameter("keyword") == null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		String googleInput = request.getParameter("keyword");
        String searchKeyword = googleInput + (isEnglish(googleInput) ? " novel" : " 小說");
		GoogleQuery google = new GoogleQuery(searchKeyword);
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
				// 在这里添加逻辑以处理无法访问的网址，比如记录日志、跳过当前网址等
				continue; // 跳过当前的循环迭代
			}
			System.out.println(i);
		}

		Sort sort = new Sort(webPages);
		sort.sortSite(0, webPages.size() - 1);
		sort.delcontact(webPages);
		
		
		
		
		
		String[][] s = new String[webPages.size()][2];
		
		int num = 0;
		for (WebPage page : webPages) {
			s[num][0] = page.name;
			s[num][1] = page.url;
			num++;
		}
		request.setAttribute("query", s);
		request.getRequestDispatcher("googleitem.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private static boolean isEnglish(String text) {
        return text.matches("[A-Za-z ]+");
}

}