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
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddBook {
	AddBook(){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JLabel name=new JLabel("Book Name    :");
		name.setBounds(25, 25, 100, 25);
		JTextField addname=new JTextField(20);
		addname.setBounds(125, 25, 150, 25);
		JLabel author=new JLabel("Author           :");
		author.setBounds(300, 25, 100, 25);
		JTextField addauthor=new JTextField(20);
		addauthor.setBounds(400, 25, 150, 25);
		
		JLabel isbn=new JLabel("ISBN               :");
		isbn.setBounds(25, 75, 100, 25);
		JTextField addisbn=new JTextField(20);
		addisbn.setBounds(125, 75, 150, 25);
		JLabel publisher=new JLabel("Publisher      :");
		publisher.setBounds(300, 75, 100, 25);
		JTextField addpublisher=new JTextField(20);
		addpublisher.setBounds(400, 75, 150, 25);
		
		JLabel udate=new JLabel("Update Latest :");
		udate.setBounds(25, 125, 100, 25);
		JLabel month=new JLabel("Month  :");
		month.setBounds(125, 125, 50, 25);
		JComboBox addmonth=new JComboBox();
		addmonth.setBounds(175, 125, 50, 25);
		for(int i=1;i<=12;i++) {
			addmonth.addItem(i);
			
		}
		JLabel year=new JLabel("Year  :");
		year.setBounds(235, 125, 50, 25);
		JComboBox addyear=new JComboBox();
		addyear.setBounds(285, 125, 60, 25);
		for(int i=1900;i<=2018;i++) {
			addyear.addItem(i);
		}
		JLabel amount=new JLabel("Amount :");
		amount.setBounds(365, 125, 50, 25);
		JComboBox addamount=new JComboBox();
		addamount.setBounds(425, 125, 60, 25);
		for(int i=1;i<=100;i++) {
			addamount.addItem(i);
		}
		
		JLabel bookshelf=new JLabel("Bookshelf No.  :");
		bookshelf.setBounds(25, 175, 100, 25);
		JComboBox addbookshelf=new JComboBox();
		addbookshelf.setBounds(125, 175, 50, 25);
		for(int i=1;i<=50;i++) {
			addbookshelf.addItem(i);
		}
		
		
		JButton okbtn=new JButton("OK");
		okbtn.setBounds(375, 175, 75, 25);
		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String n=addname.getText();
				String a=addauthor.getText();
				String isbn=addisbn.getText();
				String p=addpublisher.getText();
				int m=(int)addmonth.getSelectedItem();
				int y=(int)addyear.getSelectedItem();
				int b=(int)addbookshelf.getSelectedItem();
				int am=(int)addamount.getSelectedItem();
				if(n!=""&&a!=""&&isbn!=""&&p!="") {
					Book bookin=new Book(n,a,isbn,p,m,y,b,am);
					try {
						AddBook(bookin);
						f.setVisible(false);
					} catch (ClassNotFoundException e) {
						new ShowDialog("Class Not Found");
					}
				}
				else {
					new ShowDialog("NULL");
				}				
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
		p.add(udate);
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
	}
	public static void AddBook(Book book) throws ClassNotFoundException{
		FileOutputStream Fout=null;
		ObjectOutputStream Oout=null;
		FileInputStream Fin;
		ObjectInputStream Oin;
		PrintWriter pw=null;
		String currentLine;
		Book temp;
		int check=0;
		try {
			
			File inputFile = new File("Title/BooksList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			while((currentLine = reader.readLine()) != null) {
				if(book.getName().equals(currentLine)) {
					check++;
				}
			}
			if(check!=0) {
				Fin=new FileInputStream("Library/"+book.getName()+".txt");
				Oin=new ObjectInputStream(Fin);
				temp=book;
				book=(Book)Oin.readObject();
				Oin.close();
				Fin.close();
				if(temp.getAuthor().equals(book.getAuthor())&&temp.getISBN().equals(book.getISBN())&&temp.getPublisher().equals(book.getPublisher())) {
					book.setAmount(book.getAmount()+temp.getAmount());
					Fout=new FileOutputStream("Library/"+book.getName()+".txt",false);
					Oout=new ObjectOutputStream(Fout);
					Oout.writeObject(book);
					new ShowDialog("Success");
				}
				else {
					new ShowDialog("Name was used");
				}
			}else {
				Fout=new FileOutputStream("Library/"+book.getName()+".txt");
				Oout=new ObjectOutputStream(Fout);
				Oout.writeObject(book);
				Fout=new FileOutputStream("Author/"+book.getAuthor()+".txt",true);
				pw=new PrintWriter(Fout);
				pw.println(book.getName());
				pw.close();
				Fout=new FileOutputStream("Publisher/"+book.getPublisher()+".txt",true);
				pw=new PrintWriter(Fout);
				pw.println(book.getName());
				pw.close();
				Fout=new FileOutputStream("Title/BooksList.txt",true);
				pw=new PrintWriter(Fout);
				pw.println(book.getName());
				pw.close();
				new ShowDialog("Success");
			}
			
		} catch (FileNotFoundException e) {
			new ShowDialog("File Not Found");
		} catch (IOException e) {
			new ShowDialog("Fail");
		} finally {
			if (Fout != null) {try {
				Fout.close();
			} catch (IOException e) {
			}} 
			if (Oout != null) {try {
				Oout.close();
			} catch (IOException e) {
			}}
		}
		
	}
}
