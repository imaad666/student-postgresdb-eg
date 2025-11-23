package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentservice {
	private static String url = "jdbc:postgresql;//localhost:5432/school?user=postgres&password=6969";
	private static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded");
			
			con = DriverManager.getConnection(url);
			System.out.println("connection established");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int save(student st) {
		int res = 0;
		String sql = "INSERT into student values(?,?,?)";
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, st.getId());
			pstm.setString(2, st.getName());
			pstm.setInt(3, st.getAge());
			
			res=pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int update(student st) {
		int res = 0;
		String sql = "UPDATE student age=?,name=?,where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, st.getAge());
			pstm.setString(2, st.getName());
			pstm.setInt(3, st.getId());
			
			res = pstm.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public int delete(int id) {
		int res = 0;
		String sql = "DELETE from student where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<student> getAll(){
		List<student> list = new ArrayList<>();
		String sql = "SELECT * from student";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet resset = pstm.executeQuery();
			while(resset.next()) {
				System.out.println("fetched");
				list.add(new student(resset.getInt(1),resset.getString(2),resset.getInt(3)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean exit() {
		boolean flag = false;
		try {
			con.close();
			flag=false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
