package wp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public Download() {
        super();

    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		response.setHeader("Context-Disposition","inline;filename=computer.jpg");
		FileInputStream in =new FileInputStream("E:\\Study\\Study At School\\Web Programming\\Java\\Project_ServletBasic\\WebContent\\countdown.jpg");
		byte[] buffer=new byte[2048];
		OutputStream out = response.getOutputStream();
		int bytesRead;
		while((bytesRead = in.read(buffer))>0) {
			out.write(buffer,0,bytesRead);
		}
		in.close();
	}

}
