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
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.ImageIcon;

public class Add_Books {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Books window = new Add_Books();
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
	public Add_Books() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCallNo.setBounds(68, 49, 46, 14);
		frame.getContentPane().add(lblCallNo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(68, 85, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthor.setBounds(68, 117, 46, 14);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPublisher.setBounds(68, 153, 73, 14);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity.setBounds(68, 188, 73, 14);
		frame.getContentPane().add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(179, 46, 171, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 82, 171, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(179, 114, 171, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 150, 171, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(179, 185, 171, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener(){
			Database_stu st=new Database_stu();
			JOptionPane jp=new JOptionPane();
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					LocalDate date = LocalDate.parse(String.valueOf(textField_5.getText()));
					java.sql.Date d2=java.sql.Date.valueOf(date);
					st.conn();
					st.addbook(textField.getText(),String.valueOf(textField_1.getText())
							,String.valueOf(textField_2.getText())
							,String.valueOf(textField_3.getText()),Integer.parseInt(textField_4.getText())
							,d2);
				 
					if(st.state==1)
					{
						jp.showMessageDialog(null,"Book Added Successfully","Success",JOptionPane.DEFAULT_OPTION);
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
				 catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					if(st.state!=1)
					{
						jp.showMessageDialog(null,"Book Not Added Please Try Again Or Please Made Changes Correctly","Fail",JOptionPane.ERROR_MESSAGE);
                        
					}

				}
			}
		});
		btnAddBooks.setBounds(264, 309, 111, 29);
		frame.getContentPane().add(btnAddBooks);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				Librarian_Section.main(new String[]{});
			}
		});
		btnBack.setBounds(67, 309, 100, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddBooks.setBounds(194, 11, 111, 24);
		frame.getContentPane().add(lblAddBooks);
		
		textField_5 = new JTextField();
		textField_5.setBounds(179, 216, 171, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(68, 219, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblNoteMustEnter = new JLabel("Note: Must Enter Date In YYYY-MM-DD Format ");
		lblNoteMustEnter.setForeground(Color.RED);
		lblNoteMustEnter.setBackground(Color.GREEN);
		lblNoteMustEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoteMustEnter.setBounds(68, 269, 307, 14);
		frame.getContentPane().add(lblNoteMustEnter);
	}
}
