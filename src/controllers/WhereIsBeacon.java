package controllers;

import com.google.gson.Gson;
import models.ManageBeacon;
import mypaydbmap.StoreEntity;
import org.hibernate.SessionFactory;
import responses.StoreResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Hessam! on 13.12.2016.
 */
@WebServlet("/getstore")
public class WhereIsBeacon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//set MIME type to JSON
        response.setContentType("application/json");
        ManageBeacon manageBeacon = new ManageBeacon((SessionFactory) getServletContext().getAttribute("sessionfactoryobj"));
        String uuid = request.getParameter("uuid");
        int major =  Integer.parseInt(request.getParameter("major"));
        int minor = Integer.parseInt(request.getParameter("minor"));

        StoreEntity store = manageBeacon.getStore(uuid,major,minor);
        //respond to client
        if (store != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("currentstore",store);
            StoreResponse rsp = new StoreResponse(500,"store was detected",store.getIdstore(),store.getName());
            Gson gson = new Gson();
            String jsonString = gson.toJson(rsp,StoreResponse.class);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonString);
        }
        else {
            StoreResponse storeResponse = new StoreResponse(510,"The store could not be detected",0,null);
            Gson gson = new Gson();
            String jsonString = gson.toJson(storeResponse,StoreResponse.class);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonString);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
