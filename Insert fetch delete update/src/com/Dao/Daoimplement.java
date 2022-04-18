package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Bean;
import com.Dbconnection.Dbconn;

public class Daoimplement implements Dao {

	@Override
	public void insert(Bean b)  {
		
		try {
			Connection conn;
			conn=Dbconn.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into asif values(?,?,?)");
			ps.setString(1, b.getId());
			ps.setString(2, b.getName());
			ps.setString(3, b.getSurname());
			ps.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Bean> fetch() {
		
			List<Bean>list=new ArrayList<Bean>();
			
			Connection con=null;
			ResultSet rs=null;
			try {
				con=Dbconn.getConnection();
				String fetchquery="select * from asif";
				PreparedStatement ps=con.prepareStatement(fetchquery);
				rs=ps.executeQuery();
				while(rs.next()) {
					
					Bean bean=new Bean();
					bean.setId(rs.getString(1));
					bean.setName(rs.getString(2));
					bean.setSurname(rs.getString(3));
					list.add(bean);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
	public void delete(Bean bean) {

		try {
			Connection con=null;
			con=Dbconn.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from asif where id=?");
			ps.setString(1, bean.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Bean b) {
		Connection con=null;
		try {
			 con=Dbconn.getConnection();
			 PreparedStatement ps=con.prepareStatement("update asif set name=?,surname=? where id=?");
			 ps.setString(1, b.getName());
			 ps.setString(2, b.getSurname());
			 ps.setString(3, b.getId());
			 ps.executeUpdate();
			 con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

