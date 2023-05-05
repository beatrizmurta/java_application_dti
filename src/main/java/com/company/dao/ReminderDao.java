package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.lang.Exception;

import com.company.nomeprojeto.Reminder;

public class ReminderDao {
	
	public static Connection getConnection() {
		  //criando a conexão com o banco de dados
		  Connection con = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reminders?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Afgbr739.");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return con;
	}
		
	public static List<Reminder> getAllReminders() {
		
		List<Reminder> list = new ArrayList<Reminder>();
		//selecionando os dados que estão na tabela do banco de dados
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM reminders");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reminder reminder = new Reminder();
				reminder.setDate(rs.getDate("date"));
				reminder.setName(rs.getString("name"));
				list.add(reminder);
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return list;
	}
}
