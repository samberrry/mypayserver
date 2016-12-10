package controllers;

import com.google.gson.Gson;
import models.ManageLog;
import models.ManageUser;
import org.hibernate.SessionFactory;
import responses.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Hessam! on 09.12.2016.
 */
@WebServlet("/signin")
public class SignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set MIME type to JSON
        response.setContentType("application/json");
        ManageUser manageUser = new ManageUser((SessionFactory) getServletContext().getAttribute("sessionfactoryobj"));
//        ManageLog manageLog = new ManageLog((SessionFactory) getServletContext().getAttribute("sessionfactoryobj"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Insert user to database
        boolean authenticated = manageUser.authenticateUser(username,password);
        //respond to client
        if (authenticated)
        {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            Response rsp = new Response();
            rsp.setResultcode(200);
            rsp.setMetadata("Successfully logedin");
            Gson gson = new Gson();
            String jsonString = gson.toJson(rsp,Response.class);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonString);
        }
        else {
            Response rsp = new Response();
            rsp.setResultcode(101);
            rsp.setMetadata("username or password is incorrect!");
//            manageLog.addLog(101,"unauthorized access","user "+username+" wanted unauthorized access by this password: "+password);
            Gson gson = new Gson();
            String jsonString = gson.toJson(rsp,Response.class);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonString);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
