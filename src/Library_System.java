import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Library_System {
	Library_System(){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JButton adminbtn=new JButton(" ADMIN ");
		adminbtn.setBounds(90, 20, 100, 30);
		adminbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				f.setVisible(false);
			}
			
		});		
		
		JButton guessbtn=new JButton(" GUEST ");
		guessbtn.setBounds(90, 70, 100, 30);
		guessbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SearchBook();

				f.setVisible(false);
			}
			
		});	
		
		p.add(adminbtn);

		p.add(guessbtn);
		f.add(p);
		f.setSize(300, 175);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Library_System();
	}

}
