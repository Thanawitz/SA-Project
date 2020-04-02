import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	Login(){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JLabel ID=new JLabel("    ID    :  ");
		ID.setBounds(25, 25, 100, 25);
		JLabel PW=new JLabel("Password  :  ");
		PW.setBounds(25, 55, 100, 25);
		JTextField addID=new JTextField(20);
		addID.setBounds(100, 25, 150, 25);
		JPasswordField addPW=new JPasswordField(20);
		addPW.setBounds(100, 55, 150, 25);
		JButton loginbtn=new JButton(" LOGIN ");
		loginbtn.setBounds(100, 85, 100, 30);
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(login(addID.getText(),addPW.getText())) {
					f.setVisible(false);
				}
				else {
					new ShowDialog("ID or Password was wrong");
				}
			}
			
		});		
		p.add(ID);
		p.add(addID);
		p.add(PW);
		p.add(addPW);
		p.add(loginbtn);
		f.add(p);
		f.setSize(300, 175);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	public boolean login (String id,String pw) {
		File inputFile = new File("AdminData/"+id+".txt");
		BufferedReader reader=null;
		try {			
			
				reader = new BufferedReader(new FileReader(inputFile));			
				String password= reader.readLine();
				reader.close();
				if(pw.equals(password)) {
					new AdminMenu();
					return true;
				}else {
					return false;
				}
			
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
}
