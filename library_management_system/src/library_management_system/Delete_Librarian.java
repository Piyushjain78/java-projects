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

public class Delete_Librarian {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Librarian window = new Delete_Librarian();
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
	public Delete_Librarian() {
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
		
		JLabel lblDeleteLibrarian = new JLabel("Delete Librarian");
		lblDeleteLibrarian.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeleteLibrarian.setBounds(179, 21, 106, 28);
		frame.getContentPane().add(lblDeleteLibrarian);
		
		textField = new JTextField();
		textField.setBounds(211, 82, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterId = new JLabel("Enter Id:");
		lblEnterId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterId.setBounds(115, 85, 86, 14);
		frame.getContentPane().add(lblEnterId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			private String s;
			private int del;
            database db=new database();
            JOptionPane jp=new JOptionPane();
			public void actionPerformed(ActionEvent arg0) {
				
				s = textField.getText();
				if(s==null||s.trim().equals(""))
				{
					jp.showMessageDialog(null,"Record Not Deleted Please Don't Leave The Box Blank","Fail",JOptionPane.ERROR_MESSAGE);
					
				}
				else
				{
				del = Integer.parseInt(s);	
				
				try {
					db.conn();
					db.delete(del); 
					if(db.state==1)		
					{
					
						jp.showMessageDialog(null,"Record Successfully deleted","Success",JOptionPane.DEFAULT_OPTION);
					    textField.setText("");
					}
					if(db.state!=1)		
					{
					
						jp.showMessageDialog(null,"Record Not Deleted Please Try Again","Fail",JOptionPane.ERROR_MESSAGE);
						 textField.setText("");

					}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}});
		
		btnDelete.setBounds(250, 173, 86, 26);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Admin_Section.main(new String[]{});
			}
		});
		btnNewButton.setBounds(110, 172, 91, 28);
		frame.getContentPane().add(btnNewButton);
	}

}
