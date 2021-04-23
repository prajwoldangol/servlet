import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

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
			out.print("<html><head><title>Result</title></head><body><h1>Registered Students</h1><table border=\"1\">");
			out.print("<th>Student Id</th>");
			out.print("<th>First Name</th>");
			out.print("<th>Last Name</th>");
			out.print("<th>Middle Name</th>");
			out.print("<th>Phone</th>");
			out.print("<th>Email</th>");
			out.print("<th>Gender</th>");
			out.print("<th>Date OF Birth</th>");
			out.print("<th>Address 1</th>");
			out.print("<th>Address 2</th>");
			out.print("<th>State</th>");
			out.print("<th>City</th>");
			out.print("<th>Zip / Postal code</th>");
			out.print("<th>Actions</th>");

			while(rs.next())
			{
				out.print("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>"); 
				out.println("<td>"+rs.getString(2)+"</td>"); 
				out.println("<td>"+rs.getString(3)+"</td>"); 
				out.println("<td>"+rs.getString(4)+"</td>"); 
				out.println("<td>"+rs.getString(5)+"</td>"); 
				out.println("<td>"+rs.getString(6)+"</td>"); 
				out.println("<td>"+rs.getString(7)+"</td>"); 
				out.println("<td>"+rs.getString(8)+"</td>"); 
				out.println("<td>"+rs.getString(9)+"</td>"); 
				out.println("<td>"+rs.getString(10)+"</td>"); 
				out.println("<td>"+rs.getString(11)+"</td>"); 
				out.println("<td>"+rs.getString(12)+"</td>"); 
				out.println("<td>"+rs.getString(13)+"</td>");
				out.print("<td><a href=\""+InsertData.getDomain(request)+"/Delete?sid="+rs.getString(1)+"\" onclick=\"return confirm('Are you Sure to Delete the Record ?');\"> Delete </a>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<a href=\""+InsertData.getDomain(request)+"/edit?sid="+rs.getString(1)+"\" > Update </a></td>");
			
				out.println("</tr>");

			}
			out.print("</table><br/><a href=\""+InsertData.getDomain(request)+"/InsertData\"> Register New Student </a>");
			out.print("</body></html>");

			ps.close();


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}