package com.wen.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.swing.Timer;

@WebServlet(loadOnStartup = 1)
public class second extends HttpServlet {
	public void init(ServletConfig config) throws ServletException{
	 super.init(config);
	 //ActionListener属于Swing知识
	 Timer t =new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(new Date());
		}
	});
		t.start();
 }
}
