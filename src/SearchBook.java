import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBook {
	SearchBook(){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JLabel search=new JLabel("Search By   :");
		search.setBounds(25, 25, 100, 25);
		JComboBox type=new JComboBox();
		type.setBounds(110, 25, 100, 25);
		type.addItem("Title");
		type.addItem("Author");
		type.addItem("Publisher");
		type.addItem("All");
		JTextField addsearch=new JTextField(20);
		addsearch.setBounds(230, 25, 150, 25);
		
		
		JButton okbtn=new JButton("OK");
		okbtn.setBounds(400, 25, 75, 25);
		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Search((String)type.getSelectedItem(),(String)addsearch.getText())) {
					f.setVisible(false);
				}
				else {
					new ShowDialog("Not Found");
				}
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
		
		
		p.add(search);
		p.add(type);
		p.add(addsearch);
		p.add(okbtn);
		p.add(canclebtn);
		f.add(p);
		f.setSize(600, 100);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	public boolean Search(String type,String name) {
		File inputFile;
		BufferedReader reader=null;
		String currentLine;
		ArrayList<String> booklist = new ArrayList<String>();
		int n=0;
		if(type.equals("Title")) {
			inputFile = new File(type+"/BooksList.txt");
			try {
				reader = new BufferedReader(new FileReader(inputFile));
				while((currentLine = reader.readLine()) != null) {
						if(currentLine.toLowerCase().contains(name.toLowerCase())) {
							booklist.add(currentLine);
							n++;
						}
					}
				reader.close();
				if(n!=0) {
					new BookList(booklist,n);
					return true;
				}
				else {
					return false;
				}
			} catch (FileNotFoundException e) {
				new ShowDialog("File Not Found");
				return false;
			} catch (IOException e) {
				new ShowDialog("Fail");
				return false;
			}
		}
		else if(type.equals("All")) {
			inputFile = new File("Title/BooksList.txt");
			try {
				reader = new BufferedReader(new FileReader(inputFile));
				while((currentLine = reader.readLine()) != null) {
						booklist.add(currentLine);
						n++;
					}
				reader.close();
				new BookList(booklist,n);
				return true;
			} catch (FileNotFoundException e) {
				new ShowDialog("File Not Found");
				return false;
			} catch (IOException e) {
				new ShowDialog("Fail");
				return false;
			}
		}
		else {
			inputFile = new File(type+"/"+name+".txt");
			try {
				reader = new BufferedReader(new FileReader(inputFile));
				while((currentLine = reader.readLine()) != null) {
						booklist.add(currentLine.trim());
						n++;
				}
				reader.close();
				new BookList(booklist,n);
				return true;
			} catch (FileNotFoundException e) {
				new ShowDialog("File Not Found");
				return false;
			} catch (IOException e) {
				new ShowDialog("Fail");
				return false;
			}
		}		
	}
}
