import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditBookList {
	EditBookList(){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JLabel l=new JLabel("Book List   :");
		l.setBounds(25, 25, 100, 25);
		JComboBox list=new JComboBox();
		list.setBounds(110, 25, 275, 25);
		File inputFile;
		BufferedReader reader=null;
		String currentLine;
		inputFile = new File("Title/BooksList.txt");
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			while((currentLine=reader.readLine()) != null) {
				list.addItem(currentLine);
				}
			reader.close();
		} catch (FileNotFoundException e) {
			new ShowDialog("File Not Found");
		} catch (IOException e) {
			new ShowDialog("Fail");
		}
		JButton editbtn=new JButton("Edit");
		editbtn.setBounds(400, 25, 75, 25);
		editbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new EditBook((String)list.getSelectedItem());
			}			
		});
		JButton canclebtn=new JButton("Cancle");
		canclebtn.setBounds(480, 25, 75, 25);
		canclebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				f.setVisible(false);
			}
			
		});
		p.add(l);
		p.add(list);
		p.add(editbtn);
		p.add(canclebtn);
		f.add(p);
		f.setSize(600, 100);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}
