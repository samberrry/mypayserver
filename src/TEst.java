import com.google.gson.Gson;
import models.ManageBeacon;
import mypaydbmap.LogEntity;
import mypaydbmap.StoreEntity;
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
        /*response.setContentType("application/json");
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
        }*/
        /*
        HttpSession session = request.getSession();
        session.setAttribute("myatt","Hessam is....!");
        PrintWriter out = response.getWriter();
        out.println(session.getId().toString());
*/
        /*response.setContentType("application/json");
        ManageBeacon manageBeacon = new ManageBeacon((SessionFactory) getServletContext().getAttribute("sessionfactoryobj"));

        StoreEntity store = manageBeacon.getStore("163EB541-B100-4BA5-8652-EB0C513FB0F4",5,10);
        //respond to client
        if (store != null)
        {
//            HttpSession session = request.getSession();
//            session.setAttribute("currentstore",store);
            StoreResponse rsp = new StoreResponse(500,"store was detected",store.getIdstore(),store.getName());
            Gson gson = new Gson();
            String jsonString = gson.toJson(rsp,StoreResponse.class);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonString);
        }*/
        /*else {
            StoreResponse storeResponse = new StoreResponse(510,"The store could not be detected",0,null);
            Gson gson = new Gson();
            String jsonString = gson.toJson(storeResponse,StoreResponse.class);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonString);
        }*/
    }
}
