import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import Database Connection Class file


// Servlet Name
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException
	{
		try {
			// Initialize the database
			Connection con = DBConnection.initializeDatabase();
			PreparedStatement st = con
					.prepareStatement("insert into std_registration (std_fname,std_lname,std_mname,std_phone,std_email,std_gender,std_dob,std_address1,std_address2,std_state,std_city,std_zip) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, request.getParameter("fname"));
			st.setString(2, request.getParameter("lname"));
			st.setString(3, request.getParameter("mname"));
			st.setString(4, request.getParameter("tel"));
			st.setString(5, request.getParameter("email"));
			st.setString(6, request.getParameter("gender"));
			st.setString(7, request.getParameter("age"));
			st.setString(8, request.getParameter("address"));
			st.setString(9, request.getParameter("addressline"));
			st.setString(10, request.getParameter("state"));
			st.setString(11, request.getParameter("city"));
			st.setString(12, request.getParameter("zip"));
			st.executeUpdate();
			st.close();
			con.close();
			// getscheme retDurns http protocol, getservername returns domain + contextpath returns root folder projecct
			String url = getDomain(request);

			response.sendRedirect(url+"/ViewRecord");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException
	{
		String url = getDomain(request);

		try {
			
			int sid = Integer.valueOf(request.getParameter("sid"));
		
		}catch(Exception e) {
			response.sendRedirect(url);
		}
	
	}

	public static String getDomain(HttpServletRequest request) {
		return request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+request.getContextPath() ;
	}


}