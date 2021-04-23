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
@WebServlet("/Delete")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException
	{
		try {
//			PrintWriter out = response.getWriter();
		
			Connection con = DBConnection.initializeDatabase();

			PreparedStatement ps = con.prepareStatement("DELETE FROM std_registration where std_id= ? ");
			ps.setInt(1, Integer.valueOf(request.getParameter("sid")));
			ps.executeUpdate();

			ps.close();
			con.close();
			String url = InsertData.getDomain(request)+"/ViewRecord" ;
			response.sendRedirect(url);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}