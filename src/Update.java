import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Arrays;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import Database Connection Class file


// Servlet Name
@WebServlet("/edit")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException
	{
//		PrintWriter out = response.getWriter();
		int id = Integer.parseInt( request.getParameter("sid") );
		RegisterStudent student = getById(id);
//		out.print(student.city);
//		out.print(student.getFname());
		RequestDispatcher ds	= request.getRequestDispatcher("/update.jsp") ;
		request.setAttribute("student", student);
		ds.forward(request, response);
		
	}
	
	public RegisterStudent getById(int id ) {
		RegisterStudent std = null ;
		try {
//			PrintWriter out = response.getWriter();
			
			Connection con = DBConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM std_registration WHERE std_id = ? ");
			ps.setInt(1, id);
			ResultSet rs   =   ps.executeQuery();
			while(rs.next())
			{
				std = new RegisterStudent(rs.getInt("std_id"), rs.getString("std_fname"),rs.getString("std_mname"),rs.getString("std_lname")
						,rs.getString("std_gender"),rs.getString("std_phone"),rs.getString("std_email"),rs.getString("std_dob")
						,rs.getString("std_address1"),rs.getString("std_address2"),rs.getString("std_state"),rs.getString("std_city"),rs.getString("std_zip"));

			}
			

			ps.close();


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return std;
	}
	public void updatebyId(HttpServletRequest request, 
			HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		try {
		Connection con = DBConnection.initializeDatabase();
		PreparedStatement st = con.prepareStatement(" UPDATE std_registration set std_fname=?,std_lname=?,std_mname=?,std_phone=?,std_email=?,std_gender=?,std_dob=?,std_address1=?,std_address2=?,std_state=?,std_city=?,std_zip=?  WHERE std_id = ? ");
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
		st.setInt(13, Integer.valueOf(request.getParameter("uid")));
		st.executeUpdate();
		st.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		String url = InsertData.getDomain(request);

		response.sendRedirect(url+"/ViewRecord");
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException{
//		doGet(request,response);
		try {
			updatebyId(request,response);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}