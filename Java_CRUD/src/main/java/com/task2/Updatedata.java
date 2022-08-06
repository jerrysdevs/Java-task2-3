package com.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Updatedata {
	public static Logger demoLogger = Logger.getLogger(Updatedata.class.getName());

	public void update(String url,String user,String password) {
		
		String newLine = System.getProperty("line.separator");
		System.out.println("Please enter the emp id to update");
		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		int i = Integer.parseInt(str);
		try (Connection con = DriverManager.getConnection(url, user, password); Statement st = con.createStatement()) {
			System.out.println("Please enter the Employee name");
			Scanner empn = new Scanner(System.in);
			String empname = empn.nextLine();
			System.out.println("Please enter the Employee salary");
			Scanner emps = new Scanner(System.in);
			String empsalary = emps.nextLine();
			System.out.println("Please enter the Employee type"+newLine+" 1:Permanent"+newLine+"2:Contract"+newLine+"3:Parttime");
			Scanner empt = new Scanner(System.in);
			String emptype = empt.nextLine();
			// Update data in database
			String q1 = "UPDATE emp SET empname='" + empname + "',empsalary='" + empsalary + "',emptype='" + emptype
					+ "' WHERE empid='" + i + "'";
			
			int x = st.executeUpdate(q1);
			if (x > 0)
//				demoLogger.info("Updated Successfully");
			System.out.println("Updated Successfully");
			else
//				demoLogger.error("Update Failed, Please check the emp id");
			System.out.println("Update Failed, Please check the emp id");

			con.close();
			
		} catch (Exception e) {
			demoLogger.error(e);
		}
			
	}

}
