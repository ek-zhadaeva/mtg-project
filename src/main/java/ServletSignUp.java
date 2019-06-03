import dao.UserService;
import models.User;

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

//        UserService userService = new UserService();

        String nameAdd = req.getParameter("name");
        String lastNameAdd = req.getParameter("last_name");
        String cityAdd = req.getParameter("city");
        String loginAdd = req.getParameter("login");
        String passwordAdd = req.getParameter("password");
        String passwordAdd2 = req.getParameter("password2");


        BDWorker bdWorker = new BDWorker();
        String query1 = "INSERT into user(name, last_name, login, password, address) VALUES (?, ?, ?, ?, ?)";
        String query2 = "select login from user";



        try {
            Statement statement = bdWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query2);

            while (resultSet.next()){
                String loginInBD = resultSet.getString("login");


                if(nameAdd != "" & lastNameAdd != "" & cityAdd != "" & loginAdd != "" & passwordAdd != ""){

                    if(loginAdd.equals(loginInBD)){

                        req.setAttribute("error1", "Пользователь с таким логином уже существует!");

                        req.getRequestDispatcher("signUp.jsp").forward(req, resp);
                        return;
                    }

                }else {
                    req.setAttribute("error2", "Вы заполнили не все поля!");

                    req.getRequestDispatcher("signUp.jsp").forward(req, resp);
                    return;
                }


            }

            int passwordHash = passwordAdd.hashCode();
            int passwordHash2 = passwordAdd2.hashCode();

            if(passwordHash != passwordHash2){
                req.setAttribute("error3", "Неверный пароль!");

                req.getRequestDispatcher("signUp.jsp").forward(req, resp);
                return;
            }


            PreparedStatement preparedStmt = bdWorker.getConnection().prepareStatement(query1);




            preparedStmt.setString (1, nameAdd);
            preparedStmt.setString (2, lastNameAdd);
            preparedStmt.setString (3, loginAdd);
            preparedStmt.setInt (4, passwordHash);
            preparedStmt.setString (5, cityAdd);

            preparedStmt.execute();

            resp.sendRedirect("signIn.jsp");

//               User user = new User(nameAdd, lastNameAdd, loginAdd, passwordAdd, cityAdd);
//               userService.saveUser(user);



        } catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signUp.jsp");

    }
}
