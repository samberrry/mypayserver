package controllers;

import com.google.gson.Gson;
import com.kavenegar.sdk.KavenegarApi;
import com.kavenegar.sdk.excepctions.HttpException;
import com.kavenegar.sdk.models.SendResult;
import responses.Response;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import com.kavenegar.sdk.excepctions.ApiException;

/**
 * Created by Hessam! on 24.12.2016.
 */
@WebServlet("/smsverification")
public class SmsVerification extends HttpServlet {
    //Properties
    KavenegarApi api = new KavenegarApi("70677175415870435A78384C71692B327373484F75413D3D");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//set MIME type to JSON
        response.setContentType("application/json");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        Integer age = 0;
        if(ageStr != null)
        {
            age = Integer.valueOf(ageStr);
        }
        Random rd = new Random();
        //random.nextInt(max - min + 1) + min
        Integer random = rd.nextInt(9999-1000+1)+1000;
        //respond to client
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("phone",phone);
        session.setAttribute("email",email);
        session.setAttribute("age",age);
        session.setAttribute("randon",random);
        Response rsp = new Response();
        try{
            SendResult result;
            result = api.Send("10006707323323",phone,"MyPay Verification Code: "+random);
            System.out.println(result.getStatusText());

            rsp.setResultcode(700);
            rsp.setMetadata("SMS has been sent");
        }catch (ApiException e){
            rsp.setResultcode(701);
            rsp.setMetadata("SMS Parameter error");
        }catch (HttpException e){
            rsp.setResultcode(705);
            rsp.setMetadata("SMS WebService error");
        }
        Gson gson = new Gson();
        String jsonString = gson.toJson(rsp,Response.class);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
