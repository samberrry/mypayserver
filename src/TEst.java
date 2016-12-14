import com.google.gson.Gson;
import mypaydbmap.LogEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import responses.Response;
import responses.StoreResponse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Hessam! on 04.12.2016.
 */
@WebServlet("/test")
public class TEst extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        try{
            HttpSession session = request.getSession();
            session.setAttribute("user","hesssaaaamm!!D");
            StoreResponse response1 = new StoreResponse(500,"meta data",12,"pich pich");
            Gson gson = new Gson();
            String jsonString = gson.toJson(response1,StoreResponse.class);
            printWriter.println(jsonString);
        }
        catch (Exception e) {
            printWriter.println("JSON Error");
        }
        /*
        HttpSession session = request.getSession();
        session.setAttribute("myatt","Hessam is....!");
        PrintWriter out = response.getWriter();
        out.println(session.getId().toString());
*/

    }
}
