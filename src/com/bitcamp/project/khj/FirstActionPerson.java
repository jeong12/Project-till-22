package com.bitcamp.project.khj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class FirstActionPerson implements ActionListener{
	
	FirstDAO dao=new FirstDAO();
	FirstDTO fdto=new FirstDTO();
	private JComboBox comboBox_p;
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		JComboBox cb = (JComboBox) e.getSource();
		int index = cb.getSelectedIndex();
		String[]person=dao.Person();
		String personnel=person[index];
		fdto.setPerson(personnel);
		
		
	}

	
}
