import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagement library = new LibraryManagement();

        while (true) {
            System.out.println("Select the operation:");
            System.out.println("1: Add a new book");
            System.out.println("2: Remove a book by ID");
            System.out.println("3: List all books");
            System.out.println("4: Find a book by title");
            System.out.println("5: Exit");
            
            int operation = sc.nextInt();
            sc.nextLine();
            
            switch (operation) {
                case 1:
                    System.out.println("Enter the Book id, title, author");
                    int id = sc.nextInt();
                    sc.nextLine();  // consume the newline
                    String title = sc.nextLine();
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.println("Enter the id:");
                    int removeId = sc.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    library.listAllBooks();
                    break;
                case 4:
                    System.out.println("Enter the title:");
                    String findTitle = sc.nextLine();
                    library.findBook(findTitle);
                    break;
                case 5:
                    sc.close();
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }
    }
}

class LibraryManagement {
    private List<Book> bookshelf = new ArrayList<>();

    public void addBook(Book book) {
        bookshelf.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int id) {
        Iterator<Book> iterator = bookshelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found with ID: " + id);
    }

    public void listAllBooks() {
        if (bookshelf.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("List of all books:");
        for (Book book : bookshelf) {
            System.out.println(book);
        }
    }

    public void findBook(String title) {
        for (Book book : bookshelf) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }
}

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}
