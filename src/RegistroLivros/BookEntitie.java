package RegistroLivros;

public class BookEntitie {
	private String isbn;
	private String title;
	private String autor;
	private String edit;
	private int year;
	private int pages;
	private String gender;
	
	public BookEntitie(String title, String autor, String edit, int year, int pages, String gender) {
		super();
		this.title = title;
		this.autor = autor;
		this.edit = edit;
		this.year = year;
		this.pages = pages;
		this.gender = gender;
	}

	public BookEntitie(String isbn, String title, String autor, String edit, int year, int pages, String gender) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.autor = autor;
		this.edit = edit;
		this.year = year;
		this.pages = pages;
		this.gender = gender;
	}
	
	public BookEntitie(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String toString() {
		return "BookEntitie [ISBN:" + isbn + " livro: " + title + ", autor:" + autor + ", editora:" + edit + ", ano:"
				+ year + ", número de páginas: " + pages + ", gênero:" + gender + "]";
	}
	
}
