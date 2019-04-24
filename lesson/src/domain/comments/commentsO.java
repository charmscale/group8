package domain.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import javax.servlet.http.Cookie;;

@WebServlet("/commentsI")
public class commentsO extends HttpServlet {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	private static final long serialVersionUID = 1L;
	
	public commentsO() {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		conn = db.getConnection();
		String pagePlus = request.getParameter("submit");
		String page = pagePlus.substring(15);
		ArrayList comment = new ArrayList();
		try {
			ps =conn.prepareStatement("select * from comments where page=?");
			ps.setString(1, page);
			ResultSet rs = ps.executeQuery();
			conn.close();
			while(rs.next()) {
				comments c = new comments();
				c.setTime(rs.getLong(1));
				c.setUsername(rs.getString(2));
				c.setComment(rs.getNString(3));
				c.setReviewed(rs.getBoolean(4));
				c.setPage(page);
				comment.add(c);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		String commentList="";
		for(int i=0; i<comment.size(); i++) {
			comments c = (comments) comment.get(i);
			if(c.getReviewed()) {
				commentList=c.getUsername()+" "+c.getTime()+"\n"+c.getComment()+"\n \n";
			}
		}
		request.setAttribute("comments", commentList);
	}
}