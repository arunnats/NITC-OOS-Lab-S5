import java.util.*;

public class Q6 {
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Reference Book");
            System.out.println("2. Add Text Book");
            System.out.println("3. Check-Out");
            System.out.println("4. Check-In");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addReferenceBook(sc);
                    break;
                case 2:
                    addTextBook(sc);
                    break;
                case 3:
                    checkOut(sc);
                    break;
                case 4:
                    checkIn(sc);
                    break;
                case 5:
                    listBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addReferenceBook(Scanner sc) {
        System.out.println("Enter ID, Title and Author (Line by line)");
        int id = sc.nextInt();
        sc.nextLine(); 
        String title = sc.nextLine();
        String author = sc.nextLine();
        books.add(new ReferenceBook(id, title, author));
    }

    private static void addTextBook(Scanner sc) {
        System.out.println("Enter ID, Title and Author (Line by line)");
        int id = sc.nextInt();
        sc.nextLine(); 
        String title = sc.nextLine();
        String author = sc.nextLine();
        books.add(new TextBook(id, title, author));
    }

    private static void checkOut(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        for (Book book : books) {
            if (book.bookID == id) {
                if (book instanceof TextBook) {
                    System.out.print("Enter Username: ");
                    String user = sc.nextLine();
                    book.checkIn(user);
                } else {
                    book.checkOut(); 
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void checkIn(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.bookID == id && book instanceof TextBook) {
                book.checkOut(); 
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void listBooks() {
        for (Book book : books) {
            book.listBook();
        }
    }
}

interface Borrowable {
    void checkIn(String user);
    void checkOut();
}

abstract class Book implements Borrowable {
    protected int bookID;
    protected String title;
    protected String author;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    public abstract void listBook();
}

class TextBook extends Book {
    private String status;
    private String borrowedUser;

    public TextBook(int bookID, String title, String author) {
        super(bookID, title, author);
        this.status = "Available";
        this.borrowedUser = "";
    }

    @Override
    public void checkIn(String user) {
        if (status.equals("Available")) {
            status = "Borrowed";
            borrowedUser = user;
        }
    }

    @Override
    public void checkOut() {
        if (status.equals("Borrowed")) {
            status = "Available";
            borrowedUser = "";
        }
    }

    @Override
    public void listBook() {
        if (status.equals("Available")) {
            System.out.println("TextBook: " + bookID + ": " + title + ": " + author + ": " + status);
        } else {
            System.out.println("TextBook: " + bookID + ": " + title + ": " + author + ": Borrowed by " + borrowedUser);
        }
    }
}

class ReferenceBook extends Book {

    public ReferenceBook(int bookID, String title, String author) {
        super(bookID, title, author);
    }

    @Override
    public void checkIn(String user) {
        System.out.println("Invalid");
    }

    @Override
    public void checkOut() {
        System.out.println("Cannot be borrowed");
    }

    @Override
    public void listBook() {
        System.out.println("ReferenceBook: " + bookID + ": " + title + ": " + author);
    }
}

