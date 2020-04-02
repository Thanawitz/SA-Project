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
import javax.swing.JTextField;

public class DeleteBook {
	DeleteBook(){
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
		
		JButton okbtn=new JButton("OK");
		okbtn.setBounds(375, 125, 75, 25);
		okbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if(DeleteBook(addname.getText(),addauthor.getText(),addisbn.getText(),addpublisher.getText())) {
						f.setVisible(false);
						new ShowDialog("	Success");
					}
					
				} catch (IOException e) {
					new ShowDialog("	Fail");
				}
			}
			
		});
		JButton canclebtn=new JButton("Cancle");
		canclebtn.setBounds(475, 125, 75, 25);
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
		p.add(okbtn);
		p.add(canclebtn);
		f.add(p);
		f.setSize(600, 200);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public static boolean DeleteBook(String name,String author,String isbn,String publisher) throws IOException {
		FileInputStream Fin=null;
		ObjectInputStream Oin=null;
		FileOutputStream Fout=null;
		PrintWriter pw=null;
		Book bookin=null;
		File FileDeleted= new File("Library/"+name+".txt");
		File inputFile1 = new File("Title/BooksList.txt");
		File inputFile2 = new File("Author/"+author+".txt");
		File inputFile3 = new File("Publisher/"+publisher+".txt");
		BufferedReader reader1=null,reader2=null,reader3=null;
		try {
			Fin=new FileInputStream("Library/"+name+".txt");
			Oin=new ObjectInputStream(Fin);
			bookin=(Book)Oin.readObject();
			Oin.close();
			if(bookin.getName().equals(name)&&bookin.getAuthor().equals(author)&&bookin.getPublisher().equals(publisher)&&bookin.getISBN().equals(isbn)) {
				reader1 = new BufferedReader(new FileReader(inputFile1));
				reader2 = new BufferedReader(new FileReader(inputFile2));
				reader3 = new BufferedReader(new FileReader(inputFile3));
				String lineToRemove = name;
				String currentLine;
				int i=0,j=0,k=0;
				ArrayList<String> booklist = new ArrayList<String>();
				ArrayList<String> authorlist = new ArrayList<String>();
				ArrayList<String> publisherlist = new ArrayList<String>();
				while((currentLine = reader1.readLine()) != null) {
					if(lineToRemove.equals(currentLine)) {
						
					}else {
						booklist.add(currentLine.trim());
						i++;
					}
				}
				reader1.close();
				if(i==0) {
					inputFile1.delete();
				}else {
					Fout=new FileOutputStream("Title/BooksList.txt",false);
					pw=new PrintWriter(Fout);
					for(int a=0;a<i;a++) {
					pw.println(booklist.get(a));
					}
					pw.close();
				}
				while((currentLine = reader2.readLine()) != null) {
					if(lineToRemove.equals(currentLine)) {
						
					}else {
						authorlist.add(currentLine.trim());
						j++;
					}
				}
				reader2.close();
				if(j==0) {
					inputFile2.delete();
				}else {
					Fout=new FileOutputStream("Author/"+author+".txt",false);
					pw=new PrintWriter(Fout);
					for(int a=0;a<j;a++) {
						pw.println(authorlist.get(a));
					}
					pw.close();
				}
				while((currentLine = reader3.readLine()) != null) {
					if(lineToRemove.equals(currentLine)) {
						
					}else {
						publisherlist.add(currentLine.trim());
						k++;
					}
				}
				reader3.close();
				if(k==0) {
					inputFile3.delete();
				}else {
					Fout=new FileOutputStream("Publisher/"+publisher+".txt",false);
					pw=new PrintWriter(Fout);
					for(int a=0;a<k;a++) {
						pw.println(publisherlist.get(a));
					}
					pw.close();
				}
				FileDeleted.delete();
				return true;
		}
			else {
				new ShowDialog("Book isn't in Library");
				return false;
			}
		} catch (FileNotFoundException e) {
			new ShowDialog("File Not Found");
			return false;
		} catch (IOException e) {
			new ShowDialog("Fail");
			return false;
		} catch (ClassNotFoundException e) {
			new ShowDialog("Class Not Found");
			return false;
		}
		
	}

}
