package library_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librarian_Login_Form {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian_Login_Form window = new Librarian_Login_Form();
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
	public Librarian_Login_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLibrarianLoginForm = new JLabel("Librarian Login Form");
		lblLibrarianLoginForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLibrarianLoginForm.setBounds(133, 11, 199, 36);
		frame.getContentPane().add(lblLibrarianLoginForm);
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterName.setBounds(54, 91, 91, 14);
		frame.getContentPane().add(lblEnterName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterPassword.setBounds(54, 141, 91, 14);
		frame.getContentPane().add(lblEnterPassword);
		
		textField = new JTextField();
		textField.setBounds(174, 88, 176, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(174, 138, 176, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(String.valueOf(textField.getText()).equals("piyush")&&String.valueOf(textField_1.getText()).equals("piyush123"))
				{
					Librarian_Section.main(new String[]{});
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username and Password Please Try Again Later","Access Denied",JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField_1.setText("");
					
				}
			}
		});
		btnLogin.setBounds(236, 196, 114, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				manage.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setBounds(54, 196, 103, 29);
		frame.getContentPane().add(btnNewButton);
	}

}
