package RegistroLivros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtAutor;
	private JTextField txtEdit;
	private JTextField txtYear;
	private JTextField txtPages;
	private JTextField txtisbn;
	private JTextField txtisbn1;
	private JTextField txtsearch;
	private JTextField txtsearch1;
	private JTable tblSearch;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable searchTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBook frame = new ViewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewBook() {
		setFont(new Font("Arial Narrow", Font.BOLD, 12));
		setTitle("REGISTRO DE LIVROS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 575, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("T\u00EDtulo");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setBounds(10, 11, 46, 14);
		panel.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(10, 32, 265, 20);
		panel.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutor.setBounds(285, 11, 46, 14);
		panel.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(285, 32, 280, 20);
		panel.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblEdit = new JLabel("Editora");
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEdit.setBounds(10, 55, 46, 14);
		panel.add(lblEdit);
		
		txtEdit = new JTextField();
		txtEdit.setBounds(10, 75, 265, 20);
		panel.add(txtEdit);
		txtEdit.setColumns(10);
		
		JLabel lblYear = new JLabel("Ano Publica\u00E7\u00E3o");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYear.setBounds(10, 100, 90, 14);
		panel.add(lblYear);
		
		txtYear = new JTextField();
		txtYear.setBounds(10, 117, 124, 20);
		panel.add(txtYear);
		txtYear.setColumns(10);
		
		JLabel lblPages = new JLabel("N\u00BA Paginas");
		lblPages.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPages.setBounds(144, 100, 79, 14);
		panel.add(lblPages);
		
		txtPages = new JTextField();
		txtPages.setBounds(144, 117, 131, 20);
		panel.add(txtPages);
		txtPages.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("G\u00EAnero");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(285, 100, 63, 14);
		panel.add(lblNewLabel);
		
		JComboBox boxGender = new JComboBox();
		boxGender.setModel(new DefaultComboBoxModel(new String[] {"<Selecione um item>", "Autoajuda", "Aventura", "Biografias e Mem\u00F3rias", "Contos e Cr\u00F4nicas", "Ensaio", "Espiritualidade", "F\u00E1bula", "Fantasia", "Fic\u00E7\u00E3o Cient\u00EDfica", "Humor", "Infanto-Juvenil", "Jovem-Adulto", "Poesia", "Policial", "Romance", "Suspense e Terror", "Teatro", "T\u00E9cnicos e Acad\u00EAmicos"}));
		boxGender.setBounds(285, 116, 280, 22);
		panel.add(boxGender);
		
		JButton btnSave = new JButton("SALVAR");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookController.save(formataDados(txtisbn1.getText()), txtTitle.getText(),  txtAutor.getText(),  txtEdit.getText(),
						Integer.parseInt(txtYear.getText()),  Integer.parseInt(txtPages.getText()), boxGender.getSelectedItem().toString());
				
				txtisbn1.setText("");
				txtTitle.setText("");
				txtAutor.setText("");
				txtEdit.setText("");
				txtYear.setText("");
				txtPages.setText("");
				boxGender.setSelectedIndex(0);
			
			}
		});
		btnSave.setBounds(43, 227, 89, 23);
		panel.add(btnSave);
		
						
		JLabel lblisbn = new JLabel("ISBN");
		lblisbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblisbn.setBounds(285, 55, 46, 14);
		panel.add(lblisbn);
		
		txtisbn = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("###-##-#####-##-#");
			txtisbn1 = new javax.swing.JFormattedTextField(format_textField3);
		} catch (Exception e) {}	
		txtisbn1.setBounds(285, 75, 280, 20);
		panel.add(txtisbn1);
		txtisbn1.setColumns(10);
		
		JScrollPane scrollPane_table = new JScrollPane();
		scrollPane_table.setBounds(10, 179, 555, 37);
		contentPane.add(scrollPane_table);
	
		tblSearch = new JTable();
				tblSearch.setFont(new Font("Tahoma", Font.PLAIN, 9));
		scrollPane_table.setViewportView(tblSearch);
		String[] rows = {"ISBN", "TÍTULO", "AUTOR","EDITORA","ANO", "PAG", "GEN"};
		dtm.setColumnIdentifiers(rows);
		JScrollPane forTable = new JScrollPane();
		getContentPane().add(forTable);
		tblSearch.setModel(dtm);
		tblSearch.setBounds(10, 179, 414, 37);
		DefaultTableModel modelo = (DefaultTableModel) tblSearch.getModel();
										
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.setNumRows(0);
				String isbn = formataDados(txtsearch1.getText());
				searchResult(modelo, isbn);
				txtsearch1.setText("");
				
				}	
		});
		btnNewButton.setBounds(175, 227, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("EDITAR");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateData(tblSearch, modelo);
			
			}
		});
		btnUpdate.setBounds(307, 227, 89, 23);
		panel.add(btnUpdate);
		
		JLabel lblisbnsearch = new JLabel("Insira o ISBN do livro");
		lblisbnsearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblisbnsearch.setBounds(10, 148, 124, 14);
		panel.add(lblisbnsearch);
		
		txtsearch = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("###-##-#####-##-#");
			txtsearch1 = new javax.swing.JFormattedTextField(format_textField3);
		} catch (Exception e) {}
		txtsearch1.setBounds(144, 145, 421, 20);
		panel.add(txtsearch1);
		txtsearch1.setColumns(10);
		
		JButton btnDelete = new JButton("DELETAR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookController.delete(formataDados(txtsearch1.getText()));

			}
		});
		btnDelete.setBounds(439, 227, 89, 23);
		panel.add(btnDelete);
		
				
	
	}
	
	
		public static String formataDados(String dado){
			
			   return dado.replaceAll("[^0-9]+", "");
			}
		
		public static String[] searchBook(String search) {
			String[] result = {"","","","","","",""};
			result = new String[] {"ISBN", "TÍTULO", "AUTOR","EDITORA","ANO", "PAG", "GEN"};
			
			return result;
		}
		
		public static void searchResult (DefaultTableModel table, String isbn) {
			List<BookEntitie> book = BookController.getValues(isbn);
			for (BookEntitie bk: book) {
				table.addRow(new Object[] {
						bk.getIsbn(),
						bk.getTitle(),
						bk.getAutor(),
						bk.getEdit(),
						bk.getYear(),
						bk.getPages(),
						bk.getGender()
						
				});
			}
		}
		
		public static void updateData(JTable table, DefaultTableModel modelTable) {
			Integer row = table.getSelectedRow();
			String rowValues = modelTable.getDataVector().elementAt(row).toString();
			rowValues = rowValues.replaceAll("\\[", "");
			rowValues = rowValues.replaceAll("\\]", "");
			String[] objectValues = rowValues.split(", ");
			
			BookEntitie book = new BookEntitie(objectValues[0], objectValues[1], objectValues[2], objectValues[3], Integer.parseInt(objectValues[4]), 
					Integer.parseInt(objectValues[5]), objectValues[6]);
			BookController.update(book);
			
		}
		
}

