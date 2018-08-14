package com.bitcamp.project.khj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

public class FirstActionYear implements ActionListener {
	FirstDAO dao=new FirstDAO();
	FirstDTO fdto=new FirstDTO();
	private JComboBox comboBox_y;
	
	public FirstActionYear(JComboBox comboBox_y) {
		this.comboBox_y=comboBox_y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		JComboBox cb = (JComboBox) e.getSource();
		int index = cb.getSelectedIndex();
		List<String> arr=dao.Cal();
		String[]y=dao.year(arr);
		String year=y[index];
		fdto.setYear(year);
	
}}
