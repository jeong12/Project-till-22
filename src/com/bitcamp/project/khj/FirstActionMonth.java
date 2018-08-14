package com.bitcamp.project.khj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

public class FirstActionMonth implements ActionListener{

	FirstDAO dao=new FirstDAO();
	FirstDTO fdto=new FirstDTO();
	private JComboBox comboBox_m;
	
	public FirstActionMonth(JComboBox comboBox_m) {
		this.comboBox_m=comboBox_m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		JComboBox cb = (JComboBox) e.getSource();
		int index = cb.getSelectedIndex();
		List<String> arr=dao.Cal();
		String[]m=dao.month(arr);
		String month=m[index];
		fdto.setMonth(month);
	}
}
	
