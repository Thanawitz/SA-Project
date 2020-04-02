import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookList {
	BookList(ArrayList<String> booklist,int n){
		JFrame f=new JFrame("Library System");
		JPanel p=new JPanel();
		p.setLayout(null);
		JLabel l=new JLabel("Book List   :");
		l.setBounds(25, 25, 100, 25);
		JComboBox list=new JComboBox();
		list.setBounds(110, 25, 275, 25);
		for(int i=0;i<n;i++) {
			list.addItem(booklist.get(i));
		}		
		JButton infobtn=new JButton("Info");
		infobtn.setBounds(400, 25, 75, 25);
		infobtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(BookInfo((String)list.getSelectedItem())) {
					f.setVisible(false);
				}
				else {
					System.out.print("ERROR");
				}
			}		
		});
		JButton canclebtn=new JButton("Cancle");
		canclebtn.setBounds(480, 25, 75, 25);
		canclebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.setVisible(false);
			}		
		});
		p.add(l);
		p.add(list);
		p.add(infobtn);
		p.add(canclebtn);
		f.add(p);
		f.setSize(600, 100);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	public boolean BookInfo(String s){
		FileInputStream Fin=null;
		ObjectInputStream Oin=null;
		try {
			Fin=new FileInputStream("Library/"+s+".txt");
			Oin=new ObjectInputStream(Fin);
			Book bookin=(Book)Oin.readObject();
			new BookInfo(bookin);
			return true;
		} catch (FileNotFoundException e) {
			System.out.print("ERROR1");
			return false;
		} catch (IOException e) {
			System.out.print("ERROR2");
			return false;
		} catch (ClassNotFoundException e) {
			System.out.print("ERROR3");
			return false;
		} finally {
			if (Fin != null) {try {
				Fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}} 
			if (Oin != null) {try {
				Oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
	}

}
