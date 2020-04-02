import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditBook {
	JTextField addname,addauthor,addisbn,addpublisher;
	JComboBox addmonth,addyear,addbookshelf,addamount;
	Book book,temp;
	EditBook(String n){
		FileInputStream Fin=null;
		ObjectInputStream Oin=null;	
		try {
			Fin=new FileInputStream("Library/"+n+".txt");
			Oin=new ObjectInputStream(Fin);
			book=(Book)Oin.readObject();
			temp=book;
			Oin.close();
			Fin.close();
			JFrame f=new JFrame("Library System");
			JPanel p=new JPanel();
			p.setLayout(null);
			JLabel name=new JLabel("Book Name    :");
			name.setBounds(25, 25, 100, 25);
			addname=new JTextField(book.getName(),20);
			addname.setBounds(125, 25, 150, 25);
			JLabel author=new JLabel("Author           :");
			author.setBounds(300, 25, 100, 25);
			addauthor=new JTextField(book.getAuthor(),20);
			addauthor.setBounds(400, 25, 150, 25);
			
			JLabel isbn=new JLabel("ISBN               :");
			isbn.setBounds(25, 75, 100, 25);
			addisbn=new JTextField(book.getISBN(),20);
			addisbn.setBounds(125, 75, 150, 25);
			JLabel publisher=new JLabel("Publisher      :");
			publisher.setBounds(300, 75, 100, 25);
			addpublisher=new JTextField(book.getPublisher(),20);
			addpublisher.setBounds(400, 75, 150, 25);
			
			JLabel print=new JLabel("Date Printed  :");
			print.setBounds(25, 125, 100, 25);
			JLabel month=new JLabel("Month  :");
			month.setBounds(125, 125, 50, 25);
			addmonth=new JComboBox();
			addmonth.setBounds(175, 125, 50, 25);
			for(int i=1;i<=12;i++) {
				addmonth.addItem(i);			
			}
			addmonth.setSelectedIndex(book.getDate().getMonth()-1);
			JLabel year=new JLabel("Year  :");
			year.setBounds(235, 125, 50, 25);
			addyear=new JComboBox();
			addyear.setBounds(285, 125, 60, 25);
			for(int i=1900;i<=2018;i++) {
				addyear.addItem(i);
			}
			addyear.setSelectedIndex(book.getDate().getYear()-1900);
			
			JLabel amount=new JLabel("Amount  :");
			amount.setBounds(365, 125, 50, 25);
			addamount=new JComboBox();
			addamount.setBounds(425, 125, 60, 25);
			for(int i=1;i<=100;i++) {
				addamount.addItem(i);
			}
			addamount.setSelectedIndex(book.getAmount()-1);
			
			JLabel bookshelf=new JLabel("Bookshelf No.  :");
			bookshelf.setBounds(25, 175, 100, 25);
			addbookshelf=new JComboBox();
			addbookshelf.setBounds(125, 175, 50, 25);
			for(int i=1;i<=50;i++) {
				addbookshelf.addItem(i);
			}
			addbookshelf.setSelectedIndex(book.getBookshelf()-1);
			
			
			JButton okbtn=new JButton("OK");
			okbtn.setBounds(375, 175, 75, 25);
			okbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						edit();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					f.setVisible(false);
				}				
			});
			JButton canclebtn=new JButton("Cancle");
			canclebtn.setBounds(475, 175, 75, 25);
			canclebtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					f.setVisible(false);
				}
			});
			p.add(name);
			p.add(addname);
			p.add(author);
			p.add(addauthor);
			p.add(isbn);
			p.add(addisbn);
			p.add(publisher);
			p.add(addpublisher);
			p.add(print);
			p.add(month);
			p.add(addmonth);
			p.add(year);
			p.add(addyear);
			p.add(bookshelf);
			p.add(addbookshelf);
			p.add(amount);
			p.add(addamount);
			p.add(okbtn);
			p.add(canclebtn);
			f.add(p);
			f.setSize(600, 275);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setVisible(true);
		} catch (FileNotFoundException e) {
			new ShowDialog("File Not Found");
		} catch (IOException e) {
			new ShowDialog("Fail");
		} catch (ClassNotFoundException e) {
			new ShowDialog("Class Not Found");
		}
	}
	public void edit() throws ClassNotFoundException {
		String n=addname.getText();
		String a=addauthor.getText();
		String i=addisbn.getText();
		String p=addpublisher.getText();
		int m=(int)addmonth.getSelectedItem();
		int y=(int)addyear.getSelectedItem();
		int b=(int)addbookshelf.getSelectedItem();
		int am=(int)addamount.getSelectedItem();
		book=new Book(n,a,i,p,m,y,b,am); 
		try {
			DeleteBook.DeleteBook(temp.getName(), temp.getAuthor(), temp.getISBN(), temp.getPublisher());
			AddBook.AddBook(book);
		} catch (IOException e) {
			new ShowDialog("Fail");
		}
	}
}
