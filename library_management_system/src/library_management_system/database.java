package library_management_system;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class database {
 Connection c;
 PreparedStatement s,s1,s2;
 //Statement s2;
 ResultSet rs;
 int state;
 JFrame jf;
 ResultSetMetaData rsm;
	public void conn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","piyush12345"); 
	}
	
	public int update1(String name,String password,String emailadd,String address,String city,int contactno) throws Exception
	{
		s = c.prepareStatement("insert into addlibrarian1 values(myseq.nextval,?,?,?,?,?,?)");
	    s.setString(1,name);
	    s.setString(2,password);
	    s.setString(3,emailadd);
	    s.setString(4,address);
	    s.setString(5,city);
	    s.setInt(6,contactno);
	    state=s.executeUpdate();
		c.close();
		return state;
	
	}
	
	public int delete(int dele)
	{
		try {
			s1 = c.prepareStatement("delete from addlibrarian1 where id=?");
			s1.setInt(1,dele);
			state=s1.executeUpdate();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
		
	}
	
	public void view()
	{
		String colomn[]=null;
		String data[][]=null;
		jf = new JFrame();
		try {
			s2=c.prepareStatement("select *from addlibrarian1",rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
			rs=s2.executeQuery();
			rsm = rs.getMetaData();
			int co=rsm.getColumnCount();
			colomn=new String[co];
			for(int i=1;i<=co;i++)
			{
				colomn[i-1]=rsm.getColumnName(i);
			}
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			data=new String[rows][co];
			int count=0;
			while(rs.next()){
				for(int j=1;j<=co;j++)
				{
					data[count][j-1]=rs.getString(j);
					
				}
				count++;
			}
			
			JTable jt=new JTable(data,colomn);
			JScrollPane sp=new JScrollPane(jt);
			jf.add(sp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jf.setSize(1200,400);
		jf.setVisible(true);
		
	}

}
