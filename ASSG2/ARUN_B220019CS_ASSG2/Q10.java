import java.util.*;

public class Q10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    libraryManagement library = new libraryManagement();

  

    sc.close();
  }
}

class libraryManagement{
  private List<Book> bookshelf = new ArrayList<>();

  public libraryManagement{

  }

  public void addBook(){

  }

  public void listAllBook(){

  }

  public void findBook(){
    
  }

  public void exit(){
    
  }
}

class Book{
  private String title;
  private String author;
  private int ID;

  public Book(String title, String author, int ID){
    this.title = title;
    this.author = author;
    this.ID = ID;
  }
}