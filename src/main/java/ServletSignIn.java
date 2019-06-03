import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletSignIn", urlPatterns = "/signIn")
public class ServletSignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        int passwordHash = password.hashCode();

        BDWorker bdWorker = new BDWorker();
        String query = "select login, password from user";

        try {
            Statement statement = bdWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);



            while (resultSet.next()) {

                String loginInBD = resultSet.getString("login");
                int passwordInBD = resultSet.getInt("password");

                if (login.equals(loginInBD) && passwordHash == passwordInBD) {
                    HttpSession session = req.getSession();
                    session.setAttribute("login", login);
                    req.getRequestDispatcher("home.jsp").forward(req, resp);
                    return;
                }

            }


            req.setAttribute("error", "Неверный пароль!");

            req.getRequestDispatcher("signIn.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signIn.jsp");

    }
}
