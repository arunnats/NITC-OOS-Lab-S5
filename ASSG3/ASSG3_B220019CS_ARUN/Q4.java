public class Q4 {
  public static void main(String[] args) {
    Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99, 1925);
    Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 7.99, 1960);
    Book book3 = new Book("1984", "George Orwell", 8.99, 1949);

    book1.print();
    book2.print();
    book3.print();
  }
}

class Book {
  private String title;
  private String author;
  private double price;
  private int yearPublished;

  public Book(String title, String author, double price, int yearPublished) {
      this.title = title;
      this.author = author;
      this.price = price;
      this.yearPublished = yearPublished;
  }

  public void print() {
      System.out.println("Title: " + title);
      System.out.println("Author: " + author);
      System.out.println("Price: $" + price);
      System.out.println("Year Published: " + yearPublished);
      System.out.println(); 
  }
}