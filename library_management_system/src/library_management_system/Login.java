package library_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

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
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLoginForm = new JLabel("Admin Login Form");
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdminLoginForm.setBounds(164, 39, 138, 31);
		frame.getContentPane().add(lblAdminLoginForm);
		
		textField = new JTextField();
		textField.setBounds(193, 102, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(193, 157, 138, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterName.setBounds(75, 105, 84, 14);
		frame.getContentPane().add(lblEnterName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterPassword.setBounds(75, 157, 97, 20);
		frame.getContentPane().add(lblEnterPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(String.valueOf(textField.getText()).equals("piyush")&&String.valueOf(textField_1.getText()).equals("piyush123"))
				{
					Admin_Section.main(new String[]{});
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
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(242, 215, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				manage.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setBounds(75, 215, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
