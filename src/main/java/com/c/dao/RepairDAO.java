package com.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.c.bean.CarProblem;
@Component
public class RepairDAO {
Connection con;
@Autowired
DataSource datasource;
@PostConstruct
public void doinit() {
		try {
			con = datasource.getConnection();
			System.out.println("Connection Established!!!!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
public void addData(CarProblem c) {
    try {
   
    	PreparedStatement ps = con.prepareStatement("select count(*) from vehiclereport");
    	ResultSet rs = ps.executeQuery();
    	int id= 0;
    	while(rs.next()) {
    		id = rs.getInt(1);
    	}
    	id = id+1;
    	String status = "pending";
        ps = con.prepareStatement("Insert into vehiclereport values(?,?,?,?,?)");
        ps.setLong(1, id);
        
        ps.setString(2, c.getRegistrationNo());
        ps.setString(3, c.getRepairingdate());
        ps.setString(4, c.getIssue());
        ps.setString(5, status);
        int x= ps.executeUpdate();
        System.out.println(x+ " Record added");
} catch (Exception e) {
        System.out.println(e);
}
}

public void update(int id) {
	 try {
		 PreparedStatement ps = con.prepareStatement("select flagstatus from vehiclereport where requestid=?");
		  ps.setInt(1,id);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next()) {
			  if(rs.getString(1).equalsIgnoreCase("Repaired")) {
					System.out.println("Car corresponding to this id is already repaired");
		  }
		      else{
			ps = con.prepareStatement("update vehiclereport set flagstatus = ? where requestid = ?");
			ps.setString(1, "Repaired");
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Repaired");
		      }
		  }
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
}

public ResultSet displaytable() {
	ResultSet rs = null;
	try {
		PreparedStatement ps = con.prepareStatement("select * from vehiclereport");
		 rs = ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Table is Empty");
	}
	return rs;
}

}
