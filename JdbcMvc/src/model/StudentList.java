package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.Connect;

public class StudentList {
	private ArrayList<Student> list;
	private Statement state;
	private ResultSet result;
	private ResultSetMetaData meta;

	public StudentList() {
		list = new ArrayList<>();
		try {
			state = Connect.connectDB().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fillStudentList() throws SQLException{
		result = state.executeQuery("select * from student");
	
		while(result.next()){
			Student st = new Student();
			st.setId(result.getInt(1));
			st.setName(result.getString(2));
			st.setSname(result.getString(3));
			st.setDate(result.getDate(4));
			st.setPay(result.getInt(5));
			list.add(st);
		}
	}
	
	public ArrayList<Student> getStudentList(){
		return list;
	}
	
	public void info(){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public void addStudent(Student s) throws SQLException{    //grel Student s parametrov
		String name = s.getName();
		String sname = s.getSname();
		Date date = s.getDate();
		int pey = s.getPay();
		state.executeUpdate("insert into student value (null,'"+ name + "','"+ sname +"','"+ date +"',"+ pey +")");
	}
	
	public int countColums() throws SQLException{
		meta = (ResultSetMetaData)result.getMetaData();
		return meta.getColumnCount();
	}
	
	public String[] columsName() throws SQLException{
		meta = (ResultSetMetaData) result.getMetaData();
		String[] names = new String[meta.getColumnCount()];
		
		for(int i = 0; i < names.length; i++){
			names[i] = meta.getColumnName(i + 1);
		}
		return names;
	}
}
