package RegistroLivros;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookDao {
	
	//MÉTODO SAVE
	public static Integer save (BookEntitie book) {
		Integer result = 0;
		String sql = "Insert into REGISTER (ISBN, TITULO, AUTOR, EDITORA, PUBLICACAO, PAGINAS, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement save = con.connection.prepareStatement(sql);
			
			save.setString(1, book.getIsbn());
			save.setString(2, book.getTitle());
			save.setString(3,book.getAutor());
			save.setString(4, book.getEdit());
			save.setInt(5, book.getYear());
			save.setInt(6, book.getPages());
			save.setString(7, book.getGender());
			
			result = save.executeUpdate();
			con.connection.close();
			
		}
		catch(SQLException err) {
			System.out.println(err);
		}
		return result;
	}
	
	//MÉTODO SELECT
	public static List<BookEntitie> listbooks (String isbn){
		
		List<BookEntitie> bookList = new ArrayList<>();
		String sql = "";
		
		if(isbn.equals("")) {
			sql = "Select * from REGISTER";
			
			try {
				BaseConnection con = new BaseConnection();
				PreparedStatement st = con.connection.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					BookEntitie book = new BookEntitie(
							rs.getString("ISBN"),
							rs.getString("TITULO"),
							rs.getString("AUTOR"),
							rs.getString("EDITORA"),
							rs.getInt("PUBLICACAO"),
							rs.getInt("PAGINAS"),
							rs.getString("GENERO"));
					bookList.add(book);						
				}
			}
			catch(SQLException err) {
				System.out.println(err);
			}
		}
		else {
			sql = "Select * from REGISTER where ISBN = ?";
			
			try {
				BaseConnection con = new BaseConnection();
				PreparedStatement st = con.connection.prepareStatement(sql);
				
				st.setString(1, isbn);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					BookEntitie book = new BookEntitie(
							rs.getString("ISBN"),
							rs.getString("TITULO"),
							rs.getString("AUTOR"),
							rs.getString("EDITORA"),
							rs.getInt("PUBLICACAO"),
							rs.getInt("PAGINAS"),
							rs.getString("GENERO"));
					bookList.add(book);				
				}
			}
			catch(SQLException err) {
				System.out.println(err);
			}
		}
		return bookList;
	}
	
	
	//MÉTODO UPDATE
	public static Integer update(BookEntitie book) {
		
		Integer result = 0;
		
		Logger logger = Logger.getLogger(BookDao.class.getName());
		
		String sql = "UPDATE REGISTER SET ISBN = ?, "
				+ "TITULO = ?,"
				+ "AUTOR = ?,"
				+ "EDITORA = ?,"
				+ "PUBLICACAO = ?,"
				+ "PAGINAS = ?,"
				+ "GENERO = ?;";
		
		try {
			
			BaseConnection con = new BaseConnection();
			PreparedStatement update = con.connection.prepareStatement(sql);
			
			update.setString(1, book.getIsbn());
			update.setString(2, book.getTitle());
			update.setString(3,book.getAutor());
			update.setString(4, book.getEdit());
			update.setInt(5, book.getYear());
			update.setInt(6, book.getPages());
			update.setString(7, book.getGender());
			
			result = update.executeUpdate();					
		}
		catch(SQLException err) {
			
			logger.info(err.getMessage());
		}
		return result;
	}
	
	//MÉTODO DELETE
	
	public static Integer delete(BookEntitie book) {
		Integer result = 0;
		
		Logger logger = Logger.getLogger(BookDao.class.getCanonicalName());
		
		String sql = "DELETE FROM REGISTER WHERE ISBN = ?;";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement delete = con.connection.prepareStatement(sql);
			
			delete.setString(1, book.getIsbn());
			
			result = delete.executeUpdate();
			con.connection.close();
		}
		catch(SQLException err) {
			logger.info(err.getMessage());
		}
		return result;
		
	}
	
}
