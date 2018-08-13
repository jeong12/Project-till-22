package com.bitcamp.project.khj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

public class FirstActionTime implements ActionListener{

	DAO dao=new DAO();
	FirstDTO fdto=new FirstDTO();
	private JComboBox comboBox_t;
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		JComboBox cb = (JComboBox) e.getSource();
		int index = cb.getSelectedIndex();
		String[]t=dao.time();
		String time=t[index];
		fdto.setTime(time);
	}
}
	
