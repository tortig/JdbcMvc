package view;

	import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

import model.Student;
import model.StudentList;
	
	public class OutTable extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTable table;
		private JPanel panel;
		private StudentList sts = new StudentList();
		private String str[] ;
		private Object obj[][] ;
		private List<Student> list;
		
		public OutTable () throws SQLException {
			setLayout(new FlowLayout());
			sts.fillStudentList();
			list = sts.getStudentList();
			str = sts.columsName();
			obj =  new Object[sts.getStudentList().size()][str.length];
			for(int i = 0; i < str.length; i++){
				obj[i][0] = list.get(i).getStid();
				obj[i][1] = list.get(i).getName();
				obj[i][2] = list.get(i).getSname();
				obj[i][3] = list.get(i).getDate();
				obj[i][4] = list.get(i).getPay();
			}
			table = new JTable(obj, str);
			panel = new JPanel();
			panel.add(new JScrollPane(table));
			add(panel);
			setSize(500, 250);
			setVisible(true);
			
		}

}


