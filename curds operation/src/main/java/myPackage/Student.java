package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

	public void createDatabase() {

		try {
			String url = "jdbc:mysql://localhost:3306";
			String userName = "root";
			String password = "123456";

			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stm = conn.createStatement();
			String query = "create database db2";

			stm.execute(query);

			System.out.println("Database created Successfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTable() {

		try {
			String url = "jdbc:mysql://localhost:3306/db2";
			String userName = "root";
			String password = "123456";
			

			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stm = conn.createStatement();
			String query = "create table student (sid int(3), sname varchar(45), semail varchar(45))";

			stm.execute(query);

			System.out.println("Table created Successfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createData() {

		try {
			String url = "jdbc:mysql://localhost:3306/db2";
			String userName = "root";
			String password = "123456";
			

			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO student (sid, sname, semail) VALUES (?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, 2);
			pstm.setString(2, "aaaa");
			pstm.setString(3, "aaaa@gmail.com");
			
			pstm.execute();

			System.out.println("Data Inserted Successfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readData() {

		try {
			String url = "jdbc:mysql://localhost:3306/db2";
			String userName = "root";
			String password = "123456";
			

			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "SELECT * FROM student ";
		

			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("id = "+rs.getInt(1));
				System.out.println("name = "+rs.getString(2));
				System.out.println("email = "+rs.getString(3));
				System.out.println("");
				
				
			}
			
			System.out.println("Data Read Successfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}