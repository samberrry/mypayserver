import com.google.gson.Gson;
import mypaydbmap.LogEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import responses.Response;

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
        /*response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        try{
            Response response1 = new Response();
            response1.setMetadata("Halloooo");
            response1.setResultcode(112);
            Gson gson = new Gson();
            String jsonString = gson.toJson(response1,Response.class);
            printWriter.println(jsonString);
        }
        catch (Exception e){
            printWriter.println("JSON Error");
        }*/
        HttpSession session = request.getSession();
        session.setAttribute("myatt","Hessam is....!");
        PrintWriter out = response.getWriter();
        out.println(session.getId().toString());


    }
}
