import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletHome", urlPatterns = "/home")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("name");

            req.setAttribute("hello", "hello, " + name);
            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            req.setAttribute("error", "Please login first");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        }

    }
}
