import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userInput = request.getParameter("input");
		// 假設 searchManager 是一個可以獲得建議的類
		Suggestion searchManager = new Suggestion(Main.keywords);
		List<String> suggestions = searchManager.getSuggestions(userInput);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		for (String suggestion : suggestions) {
			out.println("<li>" + suggestion + "</li>");
		}
	}
}
