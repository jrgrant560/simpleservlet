package com.example.simpleservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    //private static final long serialVersionUID = 6632886175268784375L;    // The tutorial had this as a backup identifier, since class names get duplicated? It may not be essential.

    public void init() throws ServletException {
        super.init();
    }

    // resource management
    public void destroy() {
        super.destroy();
    }

    // Create
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost was called.");
    }

    // Read
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the "Test-Header" value from the HTTP request header
        String testHeaderID = request.getHeader("Test-Header"); // assigns the value of "Test-Header" header
        String testHeader404 = request.getHeader("Test-Header404"); // assigns the value of "Test-Header" header
        String testHeaderResponse;

        // set the status of the response to 200 (OK)
        //response.setStatus(HttpServletResponse.SC_OK);

        if (testHeader404 != null) {
            testHeaderResponse = "um... 404 test.";
            // send the error to the client (Resource Not Found)
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "The specified resource does not exist on this server. Lolz");
        } else if (testHeaderID != null && !testHeaderID.isEmpty()) { // If the response is not null, and has a value, replace with said value.
            testHeaderResponse = testHeaderID;
        } else {
            testHeaderResponse = "nothing";
            // Changes the response status to 400 Bad Request.
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        // Store the 'responseText' string in the response object (to be sent to the client)
        String responseText = "You sent " + testHeaderResponse + " to the server. ";

        // writes the text to the response.
        response.getWriter().append(responseText);


        System.out.println("doGet was called.");
        System.out.println(testHeaderID);
        System.out.println(testHeaderResponse);
    }

    // Update
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPut was called.");
    }

    // Delete
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doDelete was called.");
    }
}
