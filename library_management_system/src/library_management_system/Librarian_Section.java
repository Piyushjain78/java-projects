package library_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Date;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class Librarian_Section {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian_Section window = new Librarian_Section();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Librarian_Section() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 450, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.setBackground(UIManager.getColor("scrollbar"));
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				Add_Books.main(new String[]{});
			}
		});
		btnAddBooks.setBounds(143, 86, 152, 40);
		frame.getContentPane().add(btnAddBooks);
		
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0) {
				Database_stu db=new Database_stu();
				try {
					db.conn();
					db.view();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnViewBooks.setBounds(143, 137, 152, 40);
		frame.getContentPane().add(btnViewBooks);
		
		JButton btnIssueBooks = new JButton("Issue Books");
		btnIssueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Issue_Books.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBooks.setBounds(143, 188, 152, 40);
		frame.getContentPane().add(btnIssueBooks);
		
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Database_stu db=new Database_stu();
				try {
					db.conn();
					db.viewissue();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnViewIssuedBooks.setBounds(143, 239, 152, 39);
		frame.getContentPane().add(btnViewIssuedBooks);
		
		JButton btnReturnBooks = new JButton("Return Books");
		btnReturnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Return_Book.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnReturnBooks.setBounds(143, 292, 152, 40);
		frame.getContentPane().add(btnReturnBooks);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				manage.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setBounds(143, 346, 152, 40);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblLibrarianSection = new JLabel("Librarian Section");
		lblLibrarianSection.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLibrarianSection.setBounds(143, 0, 178, 55);
		frame.getContentPane().add(lblLibrarianSection);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_Library_Alternate_63699 (1).png"));
		lblNewLabel.setBounds(82, 82, 51, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\library (2).png"));
		lblNewLabel_1.setBounds(78, 137, 43, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\folder (1).png"));
		label.setBounds(85, 188, 43, 40);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\piyush\\Desktop\\icon\\book-open-icon.png"));
		lblNewLabel_2.setBounds(83, 238, 50, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\piyush\\Desktop\\icon\\Marvel-Book-icon.png"));
		lblNewLabel_3.setBounds(85, 292, 50, 48);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_logout_173050.png"));
		lblNewLabel_4.setBounds(71, 346, 50, 48);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
