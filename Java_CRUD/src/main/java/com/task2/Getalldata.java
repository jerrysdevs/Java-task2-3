package com.task2;

import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;


public class Getalldata {
	public static Logger demoLogger=Logger.getLogger(Getalldata.class.getName());
	public static JSONArray convert(ResultSet rs) throws Exception {

		JSONArray jsonArray = new JSONArray();

		while (rs.next()) {

			int columns = rs.getMetaData().getColumnCount();
			JSONObject obj = new JSONObject();

			for (int i = 0; i < columns; i++)
				obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));

			jsonArray.add(obj);
		}
		return jsonArray;
	}

	public void getdata(String url,String user,String password) {
		String newLine = System.getProperty("line.separator");
		System.out.println("Please enter the Employee Type"+ newLine +"Permanent Employee : 1"+ newLine +"Contract Employee : 2"+ newLine +"Parttime Employee :3"+ newLine +"all Employee: 0");
		String query = "";
		Scanner inp = new Scanner(System.in);
			String str = inp.nextLine();
			int i = Integer.parseInt(str);
			if(i==0) query = "SELECT * FROM emp";
			else query = "SELECT * FROM emp WHERE emptype='"+i+"'";
			
			if(i>=4)demoLogger.error("Please enter the correct emptype");
			
			
		
		try (Connection con = DriverManager.getConnection(url, user, password);
			
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				JSONArray result = convert(rs);
//				demoLogger.info(result);
				System.out.println(result);
			}

		} catch (Exception e) {
			demoLogger.error(e);
		}
	}
//	public static void main(String[] args) {
//	getdata();
//}

}