package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import JSON.JSONInputStream;
import JSON.*;

/**
 * Created by cs_ch on 10/25/2016.
 */
@WebServlet(name = "testingServlet", urlPatterns = {"/YEAH"})
public class testingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
        JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());
        try {
            System.out.println("Waiting for a message from the client.");
            Object requesting = inFromClient.readObject();
            System.out.println("Just got:" + requesting + " from client");


            outToClient.writeObject("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
