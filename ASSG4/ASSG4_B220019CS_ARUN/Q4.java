import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Author author1 = new Author("Stephen King", "American");
        Author author2 = new Author("Christopher Tolkein", "British");

        Book book1 = new Book("Pet Semetary", "1234567890123", author1);
        Book book2 = new Book("Salem's Lot", "1234567890124", author1);
        Book book3 = new Book("The Hobbit", "9876543210987", author2);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();
    }
}

class Author {
    private String name;
    private String nationality;

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void displayAuthorInfo() {
        System.out.println("Author Name: " + this.getName());
        System.out.println("Nationality: " + this.getNationality());
        System.out.println();
    }
}

class Book {
    private String title;
    private String isbn;
    private Author author;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("ISBN: " + this.getIsbn());
        System.out.println("Author Info:");
        author.displayAuthorInfo();
        System.out.println();
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            book.displayBookInfo();
        }
    }
}
