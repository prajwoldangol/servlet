import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import Database Connection Class file


// Servlet Name
@WebServlet("/ViewRecord")
public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		try {
			PrintWriter out = response.getWriter();

			Connection con = DBConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM std_registration");
			ResultSet rs   =   ps.executeQuery();
			String domain  = InsertData.getDomain(request);

			List<RegisterStudent> students = new ArrayList<>();
			while(rs.next())
			{
				
				students.add(new RegisterStudent(rs.getInt("std_id"), rs.getString("std_fname"),rs.getString("std_mname"),rs.getString("std_lname")
						,rs.getString("std_gender"),rs.getString("std_phone"),rs.getString("std_email"),rs.getString("std_dob")
						,rs.getString("std_address1"),rs.getString("std_address2"),rs.getString("std_state"),rs.getString("std_city"),rs.getString("std_zip")));


			}
//			out.print("acv");
//			out.print(students);
			RequestDispatcher res	= request.getRequestDispatcher("/result.jsp") ;
			request.setAttribute("students", students);
			request.setAttribute("url", domain);
			res.forward(request,response);
	
			ps.close();


		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

}
