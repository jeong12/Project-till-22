package com.bitcamp.project.khj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class FirstActionPerson implements ActionListener{
	
	DAO dao=new DAO();
	private JComboBox comboBox_p;
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		 JComboBox cb = (JComboBox) e.getSource();
		 int index = cb.getSelectedIndex();
		 System.out.println(index);
		
		
	}

	
}
