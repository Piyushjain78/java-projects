package library_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Return_Book {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return_Book window = new Return_Book();
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
	public Return_Book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReturnBook.setBounds(198, 28, 116, 29);
		frame.getContentPane().add(lblReturnBook);
		
		JLabel lblBookCallNo = new JLabel("Book Call No:");
		lblBookCallNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookCallNo.setBounds(63, 90, 99, 14);
		frame.getContentPane().add(lblBookCallNo);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentId.setBounds(63, 139, 104, 14);
		frame.getContentPane().add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(177, 87, 178, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 136, 178, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnReturnBooks = new JButton("Return Books");
		btnReturnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Database_stu db=new Database_stu();
				try {
					db.conn();
					db.checkissuebook(textField.getText());
					db.checkstudent(Integer.parseInt(textField_1.getText()));
					if(db.bo==true&&db.ho==true)
					{
					db.Return(textField.getText(),Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(null,"Book Returned Successfully","Success",JOptionPane.DEFAULT_OPTION);
					}
					if(db.bo==false&&db.ho==false||db.bo==false&&db.ho==true||db.bo==true&&db.ho==false)
					{
						JOptionPane.showMessageDialog(null,"Book Never Issued","Fail",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Book Not Issued","Fail",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnReturnBooks.setBounds(239, 192, 116, 29);
		frame.getContentPane().add(btnReturnBooks);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Librarian_Section.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setBounds(63, 192, 122, 29);
		frame.getContentPane().add(btnBack);
	}

}
