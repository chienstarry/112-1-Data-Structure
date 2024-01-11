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
		// 處理搜索請求，這裡簡化，僅轉發
		String keyword = request.getParameter("keyword");
		int searchNum = Integer.parseInt(request.getParameter("searchNum"));

		// 這裡應添加處裡搜索邏輯的代碼，例如調用其他服務或算法

		// 假設我們得到了搜索結果，現在轉發到 googleitem.jsp
		request.setAttribute("query", new String[][] { /* 搜索結果數據 */ });
		request.getRequestDispatcher("googleitem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
