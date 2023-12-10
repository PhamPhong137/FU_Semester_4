package dal;

/**
 *
 * @author PC-Phong
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Account;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Dao d = new Dao();
        String u = request.getParameter("u");
        String p = request.getParameter("p");
        List<Account> listAcc = d.getAllAcc();
        request.setAttribute("mes", "Login failed");
        for (Account acc : listAcc) {
            if (acc.getId().equals(u) && acc.getPass().equals(p)) {
                HttpSession ses = request.getSession();
                ses.setAttribute("acc", acc);
                request.setAttribute("mes", "Login successful");
            }
        }
        doGet(request, response);
    }

}
