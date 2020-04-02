import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable{
	class Date implements Serializable{
		private int month,year;
		Date(int m,int y){
			month=m;
			year=y;
		}
		public int getMonth() {return month;}
		public int getYear() {return year;}
		public void setMonth(int m) {month=m;}
		public void setYear(int y) {year=y;}
	}
	private String name,author,isbn,publisher;
	private Date PDay;
	private int bookshelf,amount;
	Book(String n,String a,String i,String p,int m,int y,int b,int am){
		name=n;
		author=a;
		isbn=i;
		publisher=p;
		PDay=new Date(m,y);
		bookshelf=b;
		amount=am;
	}
	public void setName(String n) {
		name=n;
	}
	public void setAuthor(String n) {
		author=n;
	}
	public void setISBN(String n) {
		isbn=n;
	}
	public void setPublisher(String n) {
		publisher=n;
	}
	public void setBookshelf(int n) {
		bookshelf=n;
	}
	public void setAmount(int n) {
		amount=n;
	}
	public String getName() {return name;}
	public String getAuthor() {return author;}
	public String getISBN() {return isbn;}
	public String getPublisher() {return publisher;}
	public Date getDate() {return PDay;}
	public int getBookshelf() {return bookshelf;}
	public int getAmount() {return amount;}
	
}
