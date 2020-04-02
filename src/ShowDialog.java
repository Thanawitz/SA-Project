import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowDialog {
	ShowDialog(String s){
		JDialog d=new JDialog();
		JPanel p=new JPanel(null);
		JLabel l=new JLabel();;
		d.setTitle(s);
		l.setText(s+".");
		if(s.length()>20) {

			l.setBounds(15, 5, 200, 25);
		}
		else if(s.length()>10) {
			l.setBounds(50, 5, 200, 25);
		}
		else if(s.length()>5){
			l.setBounds(70, 5, 200, 25);
		}
		else {

			l.setBounds(75, 5, 200, 25);
		}
		
		JButton b=new JButton("Close");
		b.setBounds(60, 30, 70,25);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				d.setVisible(false);
			}				
		});			
		p.add(l);
		p.add(b);
		d.add(p);
		d.setSize(200, 100);
		d.setLocationRelativeTo(null);
		d.setResizable(false);
		d.setVisible(true);
	}
	
}
