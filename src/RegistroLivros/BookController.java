package RegistroLivros;

import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class BookController {
	
	public static void save (String isbn, String title, String autor, String edit, Integer year, Integer pages, String gender) {
		BookEntitie book = new BookEntitie(isbn, title, autor, edit, year, pages, gender);
		if(BookDao.save(book) == 1) {
			showMessageDialog(null, "Dados cadastrados com Sucesso!");
		}
	}
	public static List<BookEntitie> getValues(String isbn){
		List<BookEntitie> books = BookDao.listbooks(isbn);
		return books;
	}
	
	public static void update(BookEntitie book) {
		if(BookDao.update(book) == 1) {
				showMessageDialog(null, "Dados alterados com sucesso!");				
			}
			else {
				showMessageDialog(null, "Dados do tipo incorreto, verifique e tente novamente.");
			}
		}
	
	public static void delete(String isbn) {
		BookEntitie book = new BookEntitie(isbn);
		if(BookDao.delete(book) == 1) {
			showMessageDialog(null, "Dados excluídos com sucesso!");
		}
	}
	}




