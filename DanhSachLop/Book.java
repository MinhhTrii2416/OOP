package DanhSachLop;

import java.util.Comparator;

public class Book {
    private String id, author, title;
    private double price;

    public String getId() {return this.id;}
    public String getAuthor() {return this.author;}
    public String getTitle() {return this.title;}
    public double getPrice() {return this.price;}
    public void setId(String id) {this.id = id;}
    public void setAuthor(String author) {this.author = author;}
    public void setTitle(String title) {this.title = title;}
    public void setPrice(double price) {this.price = price;}
    
    public Book(String id, String author, String title, double price) {
        this.id = id; this.author = author; this.title = title; this.price = price;
    }
    public Book() {}

    public static Comparator<Book> BookPrice = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2){
            if(o1.price < o2.price) return-1;
            else if(o1.price == o2.price) return 0;
            else return 1;
        }
    };
}
