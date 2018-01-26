package library_management_system;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;



import javax.swing.WindowConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Librarian1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JOptionPane jp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Librarian1 window = new Add_Librarian1();
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
	public Add_Librarian1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(187, 51, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		//((Object) textField_1).setEchoChar("*");
		textField_1.setBounds(187, 94, 161, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(188, 135, 160, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 178, 161, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(187, 221, 161, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(187, 263, 161, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(72, 54, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(72, 97, 87, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAddress.setBounds(72, 138, 87, 14);
		frame.getContentPane().add(lblEmailAddress);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(72, 181, 64, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCity.setBounds(72, 221, 46, 14);
		frame.getContentPane().add(lblCity);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNo.setBounds(72, 266, 77, 14);
		frame.getContentPane().add(lblContactNo);
		
		JLabel lblAddLibrarian = new JLabel("Add  Librarian");
		lblAddLibrarian.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddLibrarian.setBounds(183, 1, 149, 39);
		frame.getContentPane().add(lblAddLibrarian);
		
		JButton btnAddLibrarian = new JButton("Add Librarian");
		btnAddLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				database db=new database();
				try
				{
				db.conn();
				db.update1(String.valueOf(textField.getText()),String.valueOf(textField_1.getText()),
						String.valueOf(textField_2.getText())
						,String.valueOf(textField_3.getText()),String.valueOf(textField_4.getText()),
						Integer.parseInt(textField_5.getText()));
				        jp=new JOptionPane();
				        
				        //jp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				//System.out.println("state is"+db.state);
				if(db.state==1)		
				{
				
					jp.showMessageDialog(null,"Record Successfully Saved","Success",JOptionPane.DEFAULT_OPTION);
					/*JDialog dia=jp.createDialog("title");
			        dia.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			        dia.setVisible(true);*/
					textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                    textField_4.setText("");
                    textField_5.setText("");


				}
								
				}
				catch(Exception e)
				{
					if(db.state!=1)
					{
						jp.showMessageDialog(null,"Record Not Saved Please Try Again ","Fail",JOptionPane.ERROR_MESSAGE);
                         textField.setText("");
                         textField_1.setText("");
                         textField_2.setText("");
                         textField_3.setText("");
                         textField_4.setText("");
                         textField_5.setText("");
				
					}

//					e.printStackTrace();
				}
			}
		});
		btnAddLibrarian.setBounds(248, 325, 149, 31);
		frame.getContentPane().add(btnAddLibrarian);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				Admin_Section.main(new String[]{});
			}
		});
		btnBack.setBounds(72, 325, 103, 31);
		frame.getContentPane().add(btnBack);
		
	}

}

