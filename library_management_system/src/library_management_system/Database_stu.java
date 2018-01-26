package library_management_system;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Database_stu {
	
	 Connection c;
	 PreparedStatement s,s1,s2,s3,s4,s5,s6,s7;
	 //Statement s2;
	 ResultSet rs,rs1,rs3,rs4,rs5,rs6,rs7;
	 int state;
	 boolean bo;
	boolean ho;
	 ResultSetMetaData rsm,rsm3,rsm4;
		public void conn() throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","piyush12345"); 
		}
     
		public int addbook(String callno,String name,String author,String publisher,int quantity,Date dat)
		{
			try {
				s=c.prepareStatement("insert into addbooks values(myseq1.nextval,?,?,?,?,?,?)");
				s.setString(1, callno);
				s.setString(2, name);
				s.setString(3, author);
				s.setString(4, publisher);
				s.setInt(5, quantity);
				s.setDate(6, dat);
				state=s.executeUpdate();
				//c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return state;
			
			
		}
		
		public boolean checkbook(String bookcall)
		{
			
				try {
					s2=c.prepareStatement("select * from addbooks where callno=?");
					s2.setString(1, bookcall);
					rs1=s2.executeQuery();
					bo=rs1.next();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			return bo;
					
		}
		
		public boolean checkstudent(int student_id)
		{
			
				try {
					s2=c.prepareStatement("select * from issuebooks where student_id=?");
					s2.setInt(1, student_id);
					rs1=s2.executeQuery();
					ho=rs1.next();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			return ho;
					
		}
		
		
		
		public int issuebook(int student_id,String bookcall_no,String student_name,int student_contactno,Date issuedate)
		{
			
			try {
				s1=c.prepareStatement("insert into issuebooks values(myseq2.nextval,?,?,?,?,?)"); 
			    s1.setInt(1, student_id);
			    s1.setString(2, bookcall_no);
			    s1.setString(3, student_name);
			    s1.setInt(4, student_contactno);
			    s1.setDate(5, issuedate);
			    state=s1.executeUpdate();
		
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return state;
			
			
		}
		
		public void view()
		{
			String colomn[]=null;
			String data[][]=null;
			JFrame jf=new JFrame();
			try {
				s3=c.prepareStatement("select *from addbooks ",rs3.TYPE_SCROLL_SENSITIVE,rs3.CONCUR_UPDATABLE);
				rs3=s3.executeQuery();
				rsm3=rs3.getMetaData();
				int co=rsm3.getColumnCount();
				colomn =new String[co];
				for(int i=1;i<=co;i++)
				{
					colomn[i-1]=rsm3.getColumnName(i);
					
				}
				rs3.last();
				int rows=rs3.getRow();
				rs3.beforeFirst();
				data=new String[rows][co];
				int count=0;
				while(rs3.next()){
					for(int i=1;i<=co;i++)
					{
						data[count][i-1]=rs3.getString(i);
						
					}
					count++;
				}
				
				JTable jt=new JTable(data,colomn);
				JScrollPane sp1=new JScrollPane(jt);
				jf.add(sp1);
				//c.close();
				
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jf.setSize(1200, 400);
			jf.setVisible(true);
		
		}
		
		public void viewissue()
		{
			String[] colomn;
			String[][] data;
			JFrame js=new JFrame();
			try {
				s4=c.prepareStatement("select *from issuebooks inner join addbooks on bookcall_no=callno ",rs4.TYPE_SCROLL_SENSITIVE,rs4.CONCUR_UPDATABLE);
				rs4=s4.executeQuery();
				rsm4=rs4.getMetaData();
				int co=rsm4.getColumnCount();
				colomn=new String[co];
				for(int i=1;i<=co;i++)
				{
					colomn[i-1]=rsm4.getColumnName(i);
					
				}
				rs4.last();
				int rows=rs4.getRow();
				rs4.beforeFirst();
				data=new String[rows][co];
				int count=0;
				while(rs4.next()){
					for(int i=1;i<=co;i++)
					{
						data[count][i-1]=rs4.getString(i);
						
					}
					count++;
				}
				
				JTable jt=new JTable(data,colomn);
				JScrollPane sp1=new JScrollPane(jt);
				js.add(sp1);
		
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					js.setSize(1400, 400);
					js.setVisible(true);
		}

		public boolean checkissuebook(String callno)
		{
			
				try {
					s5=c.prepareStatement("select * from addbooks where callno=?");
					s5.setString(1, callno);		
					rs5=s5.executeQuery();
					bo=rs5.next();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			return bo;
					
		}
		
		public void Return(String bookcall_no,int student_id) throws SQLException
		{
			try {
				s6=c.prepareStatement("delete from issuebooks where bookcall_no=? and student_id=?");
				s6.setString(1, bookcall_no);
				s6.setInt(2,student_id);
				rs6=s6.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
}
