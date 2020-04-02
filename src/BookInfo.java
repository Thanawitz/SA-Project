import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookInfo {
	BookInfo(Book data){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JLabel name=new JLabel("Book Name    :");
		name.setBounds(25, 25, 100, 25);
		JLabel addname=new JLabel(data.getName());
		addname.setBounds(125, 25, 150, 25);
		JLabel author=new JLabel("Author           :");
		author.setBounds(300, 25, 100, 25);
		JLabel addauthor=new JLabel(data.getAuthor());
		addauthor.setBounds(400, 25, 150, 25);
		
		JLabel isbn=new JLabel("ISBN               :");
		isbn.setBounds(25, 75, 100, 25);
		JLabel addisbn=new JLabel(data.getISBN());
		addisbn.setBounds(125, 75, 150, 25);
		JLabel publisher=new JLabel("Publisher      :");
		publisher.setBounds(300, 75, 100, 25);
		JLabel addpublisher=new JLabel(data.getPublisher());
		addpublisher.setBounds(400, 75, 150, 25);
		
		JLabel print=new JLabel("Date Printed  :");
		print.setBounds(25, 125, 100, 25);
		JLabel month=new JLabel("Month  :");
		month.setBounds(125, 125, 50, 25);
		JLabel addmonth=new JLabel(Integer.toString(data.getDate().getMonth()));
		addmonth.setBounds(175, 125, 50, 25);
		
		JLabel year=new JLabel("Year  :");
		year.setBounds(235, 125, 50, 25);
		JLabel addyear=new JLabel(Integer.toString(data.getDate().getYear()));
		addyear.setBounds(285, 125, 60, 25);
		
		JLabel amount=new JLabel("Amount :");
		amount.setBounds(365, 125, 50, 25);
		JLabel addamount=new JLabel(Integer.toString(data.getAmount()));
		addamount.setBounds(425, 125, 60, 25);
		
		
		JLabel bookshelf=new JLabel("Bookshelf No.  :");
		bookshelf.setBounds(25, 175, 100, 25);
		JLabel addbookshelf=new JLabel(Integer.toString(data.getBookshelf()));
		addbookshelf.setBounds(125, 175, 50, 25);
		
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
		p.add(amount);
		p.add(addamount);
		p.add(bookshelf);
		p.add(addbookshelf);
		f.add(p);
		f.setSize(600, 275);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}

}
