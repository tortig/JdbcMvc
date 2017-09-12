import java.sql.SQLException;

import javax.swing.JFrame;

import model.StudentList;
import view.AddStudent;

public class Main {

	public static void main(String[] args){
		StudentList sts = new StudentList();
		try {
			sts.fillStudentList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sts.info();
		AddStudent obj = new AddStudent();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
