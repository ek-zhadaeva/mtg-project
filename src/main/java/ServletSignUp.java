import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletSignUp", urlPatterns = "/signUp")
public class ServletSignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameAdd = req.getParameter("name");
        String lastNameAdd = req.getParameter("last_name");
        String cityAdd = req.getParameter("city");
        String loginAdd = req.getParameter("login");
        String passwordAdd = req.getParameter("password");

        BDWorker bdWorker = new BDWorker();
        String query = "INSERT into user(name, last_name, login, password, address) VALUES (?, ?, ?, ?, ?)";

      //  Statement statement = null;
        try {
         //   statement = bdWorker.getConnection().createStatement();
         //   statement.executeUpdate(query);



            PreparedStatement preparedStmt = bdWorker.getConnection().prepareStatement(query);

            preparedStmt.setString (1, nameAdd);
            preparedStmt.setString (2, lastNameAdd);
            preparedStmt.setString (3, loginAdd);
            preparedStmt.setString (4, passwordAdd);
            preparedStmt.setString (5, cityAdd);

            preparedStmt.execute();

           if(nameAdd != null && lastNameAdd != null && cityAdd != null && loginAdd != null && passwordAdd != null){
               resp.sendRedirect("signIn.jsp");
//                req.getRequestDispatcher("info.jsp").forward(req, resp);

           }





        } catch (SQLException e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signUp.jsp");

    }
}
