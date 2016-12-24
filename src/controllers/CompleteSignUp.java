package controllers;

import com.google.gson.Gson;
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
 * Created by Hessam! on 24.12.2016.
 */
@WebServlet("/completesignup")
public class CompleteSignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set MIME type to JSON
        response.setContentType("application/json");
        ManageUser manageUser = new ManageUser((SessionFactory) getServletContext().getAttribute("sessionfactoryobj"));
        //getting HTTP parameters
        String randomStr = request.getParameter("random");
        int random = 0;
        if(randomStr != null)
        {
            random = Integer.valueOf(randomStr);
        }
        //getting Session Attributes
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String phone = (String) session.getAttribute("phone");
        String email = (String) session.getAttribute("email");
        Integer age = (Integer) session.getAttribute("age");
        int sessionRandom = (Integer) session.getAttribute("random");

        if (random == sessionRandom) {
            //Insert user to database
            Integer id = manageUser.addUser(username, password, "customer", phone, email, age);
            //respond to client
            if (id == 0) {
                Response rsp = new Response();
                rsp.setResultcode(300);
                rsp.setMetadata("Successfully created");
                Gson gson = new Gson();
                String jsonString = gson.toJson(rsp, Response.class);
                PrintWriter printWriter = response.getWriter();
                printWriter.println(jsonString);
            } else {
                System.out.println("Some Error!");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
