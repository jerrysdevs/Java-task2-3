package com.task2;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import org.apache.log4j.Logger;

public class Insertdata {
	public static Logger demoLogger=Logger.getLogger(Insertdata.class.getName());
	public static void main(String[] args) {

		String empname = "Siranjeevi";
		Integer empsalary = 100000;
		Integer emptype = 1;

		String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
		String user = "root";
		String password = "password";


		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()) {
			// Inserting data in database
			String q1 = "insert into emp (empname,empsalary,emptype) values('" + empname + "', '" + empsalary + "', '" + emptype + "')";
			int x = st.executeUpdate(q1);
			if (x > 0)
				demoLogger.info("Successfully Inserted");
			else
				demoLogger.error("Insert Failed");

			con.close();

		} catch (Exception e) {
			demoLogger.error(e);
		}

	}

}
