package com.bitcamp.project.khj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class FirstActionGoto implements ActionListener {

	private JTextField textField_d;
	private JTextField textField_a;
	FirstDTO fdto=new FirstDTO();
	FirstDAO fdao=new FirstDAO();
	
	public FirstActionGoto(JTextField textField_d, JTextField textField_a) {
		this.textField_d=textField_d;
		this.textField_a=textField_a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ds=textField_d.getText();
		fdto.setDs(ds);
		String as=textField_a.getText();
		fdto.setAs(as);
		
		
	}

}
