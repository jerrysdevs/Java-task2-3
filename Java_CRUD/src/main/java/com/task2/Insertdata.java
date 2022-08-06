package com.task2;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Insertdata {
	public static Logger demoLogger = Logger.getLogger(Insertdata.class.getName());

	public void insert(String url,String user,String password) {
		String newLine = System.getProperty("line.separator");
		System.out.println("Please enter the Employee name");
		Scanner empn = new Scanner(System.in);
		String empname = empn.nextLine();
		System.out.println("Please enter the Employee salary");
		Scanner emps = new Scanner(System.in);
		String empsalary = emps.nextLine();
		System.out.println("Please enter the Employee type"+newLine+"1:Permanent"+newLine+"2:Contract"+newLine+"3:Parttime");
		Scanner empt = new Scanner(System.in);
		String emptype = empt.nextLine();
		try (Connection con = DriverManager.getConnection(url, user, password); Statement st = con.createStatement()) {
			// Inserting data in database
			String q1 = "insert into emp (empname,empsalary,emptype) values('" + empname + "', '" + empsalary + "', '"
					+ emptype + "')";
			int x = st.executeUpdate(q1);
			if (x > 0)
//				demoLogger.info("Successfully Inserted");
			System.out.println("Successfully Inserted");
			else
//				demoLogger.error("Insert Failed");
			System.out.println("Insert Failed");

			con.close();

		} catch (Exception e) {
			demoLogger.error(e);
		}

	}
//	public static void main(String args[]) {
//		insert();
//	}
}
