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
import java.time.LocalDate;
import java.awt.Color;

public class Issue_Books {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue_Books window = new Issue_Books();
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
	public Issue_Books() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookCallNo = new JLabel("Book Call No:");
		lblBookCallNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookCallNo.setBounds(101, 60, 79, 14);
		frame.getContentPane().add(lblBookCallNo);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentId.setBounds(101, 99, 79, 14);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentName.setBounds(101, 143, 103, 14);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblStudentContact = new JLabel("Student Contact:");
		lblStudentContact.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentContact.setBounds(101, 187, 121, 14);
		frame.getContentPane().add(lblStudentContact);
		
		textField = new JTextField();
		textField.setBounds(247, 60, 154, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(247, 96, 154, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(247, 140, 154, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(247, 184, 154, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Librarian_Section.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setBounds(89, 308, 115, 28);
		frame.getContentPane().add(btnBack);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener(){
			JOptionPane jp=new JOptionPane();
			Database_stu db=new Database_stu();
			Add_Books ad=new Add_Books();
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					LocalDate date = LocalDate.parse(String.valueOf(textField_4.getText()));
					java.sql.Date d2=java.sql.Date.valueOf(date);
					db.conn();
					if(db.checkbook(textField.getText()))
							{
					
					db.issuebook(Integer.parseInt(textField_1.getText()),textField.getText(),
							textField_2.getText(),Integer.parseInt(textField_3.getText()),d2);
					jp.showMessageDialog(null,"Book Issued Successfully","Success",JOptionPane.DEFAULT_OPTION);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
							}
							
					else
					{jp.showMessageDialog(null,"Book Callno Not Found,Fail To Issue Book ","Fail",JOptionPane.ERROR_MESSAGE);}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					jp.showMessageDialog(null,"Fail To Issue Book Please Enter Detail Carefully","Fail",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnIssueBook.setBounds(275, 308, 126, 28);
		frame.getContentPane().add(btnIssueBook);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIssueBook.setBounds(191, 11, 103, 28);
		frame.getContentPane().add(lblIssueBook);
		
		JLabel lblDate = new JLabel("IssueDate:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(101, 228, 103, 14);
		frame.getContentPane().add(lblDate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(247, 224, 154, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNotemuatEnterDate = new JLabel("Note:Must Enter Date In YYYY-MM-DD Format");
		lblNotemuatEnterDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNotemuatEnterDate.setForeground(Color.RED);
		lblNotemuatEnterDate.setBounds(101, 269, 300, 14);
		frame.getContentPane().add(lblNotemuatEnterDate);
	}
}
