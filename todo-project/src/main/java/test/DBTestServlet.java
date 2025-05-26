package test;

import com.todo.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/dbtest")
public class DBTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try (Connection conn = JDBCUtils.getConnection()) {
            if (conn != null) {
                out.println("<h2>✅ DB 연결 성공!</h2>");
            } else {
                out.println("<h2>❌ DB 연결 실패!</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
