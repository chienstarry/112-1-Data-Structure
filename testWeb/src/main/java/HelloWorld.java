import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class HelloWorld extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 處理搜索请求，這裡簡化，僅轉發
		String keyword = request.getParameter("keyword");
		int searchNum = Integer.parseInt(request.getParameter("searchNum"));

		// 这里应添加处理搜索逻辑的代码，例如调用其他服务或算法

		// 假设我们得到了搜索结果，现在转发到 googleitem.jsp
		request.setAttribute("query", new String[][] { /* 搜索结果数据 */ });
		request.getRequestDispatcher("googleitem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
