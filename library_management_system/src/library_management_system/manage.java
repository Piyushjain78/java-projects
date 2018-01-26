package library_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class manage {

	private JFrame frmLibraryManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manage window = new manage();
					window.frmLibraryManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public manage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibraryManagement = new JFrame();
		frmLibraryManagement.getContentPane().setBackground(new Color(0, 128, 128));
		frmLibraryManagement.setTitle("LIBRARY MANAGEMENT");
		frmLibraryManagement.setBackground(Color.WHITE);
		frmLibraryManagement.setBounds(100, 100, 450, 300);
		frmLibraryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryManagement.getContentPane().setLayout(null);
		
		JLabel lblLibraryManagement = new JLabel("Library Management");
		lblLibraryManagement.setFont(new Font("Arial", Font.BOLD, 16));
		lblLibraryManagement.setBounds(149, 22, 188, 46);
		frmLibraryManagement.getContentPane().add(lblLibraryManagement);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login.main(new String[]{});
				frmLibraryManagement.dispose();				
			}
		});
		btnAdminLogin.setBounds(149, 89, 121, 36);
		frmLibraryManagement.getContentPane().add(btnAdminLogin);
		
		JButton btnLibrarianLogin = new JButton("Librarian login");
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Librarian_Login_Form.main(new String[]{});
				frmLibraryManagement.dispose();
			}
		});
		btnLibrarianLogin.setBounds(149, 153, 121, 36);
		frmLibraryManagement.getContentPane().add(btnLibrarianLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_Bank_128393.png"));
		lblNewLabel.setBounds(33, 11, 106, 98);
		frmLibraryManagement.getContentPane().add(lblNewLabel);
	}
}
