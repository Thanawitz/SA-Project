import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminMenu {
	AdminMenu(){
		JFrame f=new JFrame("Admin Menu");
		JPanel p=new JPanel();
		p.setLayout(null);
		
		JButton addbtn=new JButton(" Add Book ");
		addbtn.setBounds(70, 50, 150, 50);
		addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddBook();
			}			
		});
		JButton deletebtn=new JButton(" Delete Book ");
		deletebtn.setBounds(70, 125, 150, 50);
		deletebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new DeleteBook();
			}			
		});
		JButton editbtn=new JButton(" Edit Book ");
		editbtn.setBounds(70, 200, 150, 50);
		editbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new EditBookList();
			}			
		});
		JButton searchbtn=new JButton(" Search Book ");
		searchbtn.setBounds(70, 275, 150, 50);
		searchbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SearchBook();
			}			
		});
		
		
		p.add(addbtn);
		p.add(deletebtn);
		p.add(editbtn);
		p.add(searchbtn);
		f.add(p);
		f.setSize(300, 420);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}
