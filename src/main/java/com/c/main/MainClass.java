package com.c.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.c.bean.CarProblem;
import com.c.dao.RepairDAO;

public class MainClass {
   public static void main(String[] args) {
	  
	   ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-conf.xml");
	   RepairDAO dao =  (RepairDAO) ctx.getBean("repairDAO");
	   CarProblem cp =  (CarProblem) ctx.getBean("carProblem");
	   System.out.println("a) Press 1 to enter the new request");
	   System.out.println("b) Press 2 to update the car repairing status");
	   System.out.println("c) Press 3 to Display report");
	   System.out.println("d) Press 4 to exit");
	   Scanner sc = new Scanner(System.in);
	   int n;
	   boolean b  = true;
	   while(b) {
	   n = sc.nextInt();
	   if(n==1) {
		   System.out.println("Please Enter Your Name:");
		   String name = sc.next();
		   System.out.println("Please Enter Your Car Registration Number:");
		   String regno = sc.next();
		   System.out.println("Please enter Car repairing date:");
		   String date = sc.next();
		   System.out.println("Please Enter the problems you are facing in your car:");
		   String issue = sc.next();
			    cp.setRegistrationNo(regno);
			    cp.setRepairingdate(date);
			    cp.setIssue(issue);
			    cp.setName(name);
			    System.out.println(cp);
			    dao.addData(cp);
	
	    }
	     else if(n==2) {
		   System.out.println("Enter the Request Id: ");
		   int id = sc.nextInt();
		   dao.update(id);
	   }
	   else if(n==3) {
		 ResultSet rs  = dao.displaytable();
		 try {
			while(rs.next()) {
				 System.out.println( rs.getInt(1) + ". "+ " "+ rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   else if(n==4) {
		   b = false;
	   }
	   } 
}
}
