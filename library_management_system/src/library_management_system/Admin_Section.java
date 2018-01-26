package library_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Admin_Section {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Section window = new Admin_Section();
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
	public Admin_Section() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 450, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminSection = new JLabel("Admin Section");
		lblAdminSection.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminSection.setBounds(165, 25, 134, 56);
		frame.getContentPane().add(lblAdminSection);
		
		JButton btnAddLibrarian = new JButton("Add Librarian");
		btnAddLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Librarian1.main(new String[]{});
				frame.dispose();
			}
		});
		btnAddLibrarian.setBounds(153, 105, 134, 33);
		frame.getContentPane().add(btnAddLibrarian);
		
		JButton btnViewLibrarian = new JButton("View Librarian");
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				database db=new database();
				//frame.dispose();
				try {
					db.conn();
					db.view();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnViewLibrarian.setBounds(153, 159, 134, 33);
		frame.getContentPane().add(btnViewLibrarian);
		
		JButton btnDeleteLibrarian = new JButton("Delete Librarian");
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				Delete_Librarian.main(new String[]{});
			}
		});
		btnDeleteLibrarian.setBounds(153, 210, 134, 33);
		frame.getContentPane().add(btnDeleteLibrarian);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				manage.main(new String[]{});
			}
		});
		btnLogout.setBounds(153, 261, 134, 33);
		frame.getContentPane().add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_Teacher_131497.png"));
		label.setBounds(85, 92, 48, 52);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_administrator_43663.png"));
		lblNewLabel.setBounds(85, 156, 48, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_004_95890.png"));
		lblNewLabel_1.setBounds(85, 210, 55, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\piyush\\Downloads\\if_logout_173050.png"));
		lblNewLabel_2.setBounds(78, 261, 55, 52);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
