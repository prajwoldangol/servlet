import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddingNums")
public class AdditionServlet extends HttpServlet {

	@Override
	public void doPost( HttpServletRequest req, HttpServletResponse res) throws IOException{
		PrintWriter pw = res.getWriter();
		try {
			
			int num1 = Integer.parseInt(req.getParameter("num1"));
			int num2 = Integer.parseInt(req.getParameter("num2"));
			
			int sum = num1+num2;
			
			
			pw.println("Sum is of "+num1 +" and " +num2 + " is " + sum );
		}
		catch(Exception e) {
			pw.println( " Something Went Wrong !! ");
		}
	}
}
