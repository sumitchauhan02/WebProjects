package com.wipro.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wipro.constants.Constants;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/uploadFile")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String UPLOAD_DIRECTORY = "TMP_UPLOAD";

    /**
     * Default constructor. 
     */
    public FileUploadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside FileUploadServlet.doPost() method...");
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		System.out.println("uploadPath : "+ uploadPath);
		
		File uploadDir = new File(uploadPath);
		if (! uploadDir.exists())
			uploadDir.mkdir();
		
		String fileName = null;
		for (Part part : request.getParts()) {
		    fileName = getFileName(part);
		  //  System.out.println("fileName: "+ fileName                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   );
		    part.write(uploadPath + File.separator + fileName);
		    
		    
		}
		String message = "File Uploaded Successfully";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
		//doGet(request, response);
	}
	
	private String getFileName(Part part) {
		System.out.println("content-disposition header: "+part.getHeader("content-disposition"));
		for (String content : part.getHeader("content-disposition").split(";")) {
	    	System.out.println("content: " +content);
	        if (content.trim().startsWith("filename"))
	            return content.substring(content.indexOf("=") + 2, content.length() - 1); // Use split() method...
	        }
	    return Constants.DEFAULT_FILENAME;
	}

}
