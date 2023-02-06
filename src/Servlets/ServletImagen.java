package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.ConexionBD;

@WebServlet("/ServletImagen")
public class ServletImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sesion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		String correo;

		Connection con;

		con = ConexionBD.conectar();

		byte[] buf = null;

		String phototype = "jpg";

		correo = (String) sesion.getAttribute("email");

		// ID Find photos
		String query = "SELECT imagen FROM \"TFG\".cliente WHERE correo =?";

		try {

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, correo);

			System.out.println(query);

			ResultSet rs = stmt.executeQuery();
			// Image data is read into the buffer
			if (rs.next()) {
				buf = rs.getBytes(1);
			} else {
				buf = new byte[0];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Response.setContentType (content_type);
		// Tells the browser to output pictures
		response.setContentType("image /" + phototype);
		// Output image output stream
		OutputStream out = response.getOutputStream();
		// Output to the input of the buffer page
		out.write(buf);
		// Input is completed, clear buffer
		out.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		String correo;

		correo = (String) sesion.getAttribute("email");

		File file = null;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;

		String filePath;
		String contentType;

		FileItem fi;
		List<FileItem> fileItems;
		DiskFileItemFactory factory;
		String fileName = null;
		FileInputStream fis;

//		filePath = "data";
		filePath = this.getServletContext().getRealPath("/WEB-INF/data");

		contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {

			factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);
			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("."));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);
			try {
				// Parse the request to get file items.
				fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator<FileItem> i = fileItems.iterator();

				while (i.hasNext()) {
					fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						@SuppressWarnings("unused")
						String fieldName = fi.getFieldName();
						fileName = fi.getName();

						// Write the file
						if (fileName.lastIndexOf("/") >= 0) {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("/")));
						} else {
							file = new File(filePath + "/" + fileName.substring(fileName.lastIndexOf("/") + 1));
						}
						fi.write(file);
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@SuppressWarnings("unused")
		byte buf[];
		@SuppressWarnings("unused")
		String rutaImagen;

		Connection con;

		con = ConexionBD.conectar();

		rutaImagen = filePath + "/" + fileName;
		// File file=new File(rutaImagen);

		try {

			// Open the file
			fis = new FileInputStream(file);

			PreparedStatement pstmt = con.prepareStatement("UPDATE \"TFG\".cliente SET imagen = ? WHERE correo = ?");

			pstmt.setBinaryStream(1, fis, file.length());
			pstmt.setString(2, correo);
			pstmt.executeUpdate();

			System.out.println(correo + "   " + fis);

			pstmt.close();
			con.close();
			fis.close();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/Perfil.jsp").forward(request, response);

	}

}
