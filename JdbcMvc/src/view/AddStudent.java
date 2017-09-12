package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Student;
import model.StudentList;

public class AddStudent extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JTextField sname;
	private JTextField pey;
	private JComboBox<?> day;
	private JComboBox<?> mount;
	private JComboBox<?> year;
	private JButton insert;
	private String[] days = new String[31];
	private String[] mounts = {"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
	private String[] years = new String[17];
	private StudentList ob;
	private JButton view;
	
	@SuppressWarnings("unchecked")
	public AddStudent(){
		setLayout(new FlowLayout());
		name = new JTextField(10);
		sname = new JTextField(15);
		pey = new JTextField(10);
		fillArrs();
		day = new JComboBox(days);
		mount = new JComboBox(mounts);
		year = new JComboBox(years);
		insert = new JButton("Insert");
		view = new JButton("VIEW");
		
		add(name);
		add(sname);
		add(pey);
		add(day);
		add(mount);
		add(year);
		add(insert);
		add(view);
		insert.addActionListener(this);
		view.addActionListener(this);
		
		setSize(350,250);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == insert){
		ob = new StudentList();
		Student s = new Student();
		s.setName(name.getText());
		s.setSname(sname.getText());
		
		String d, m , y;
		d = (String)day.getSelectedItem();
		m = (String)mount.getSelectedItem();
		m = mount.getSelectedIndex() + 1 + "";
		y = (String)year.getSelectedItem();
		
		String str = y + "-" + m + "-" + d;
		Date finish = Date.valueOf(str);
		s.setDate(finish);
		
		s.setPay(Integer.parseInt(pey.getText()));
		
		try {
			ob.addStudent(s);               
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
		
		
		if(e.getSource() == view){
			try {
				new OutTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void fillArrs(){
		for(int i = 0; i <= 30; i++){
			days[i] = (i + 1) + "";
		}
		
		for(int i = 1985; i < 2002; i++){
			years[i-1985] = i + "";
		}
	}
}
