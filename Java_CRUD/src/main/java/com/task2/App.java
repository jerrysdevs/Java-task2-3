package com.task2;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {

	public static void main(String[] args) {
//		BasicConfigurator.configure();
		String newLine = System.getProperty("line.separator");
//		Logger demoLogger = Logger.getLogger(App.class.getName());
		
		String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
		String user = "root";
		String password = "password";

	
		Deletedata del = new Deletedata();
		Getalldata get = new Getalldata();
		Insertdata ins = new Insertdata();
		Updatedata upd = new Updatedata();
// Using scanner to get kind of operation from user:
		System.out.println("Please Choose the following Methods"+ newLine +"Create : 1"+ newLine +"Get : 2" + newLine +"Update : 3" + newLine + "Delete : 4");
		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		int i = Integer.parseInt(str);
		
		switch(i) {
		case 1:
			ins.insert(url,user,password);
		break;
		case 2:
			get.getdata(url,user,password);
			break;
		case 3:
			upd.update(url,user,password);
		break;
		case 4:
			del.delete(url,user,password);
			break;
		}
		
	}

}
