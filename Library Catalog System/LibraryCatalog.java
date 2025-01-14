import java.util.ArrayList;
import java.util.Scanner;

// Book class to represent individual book details
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    @Override
    public String toString() {
        return "\n\t\t Title: " + title + ", \n\t\t Author: " + author + ",\n\t \t ISBN: " + isbn;
    }
}

// Library class that manages the catalog of books
class Library {
    private ArrayList<Book> catalog;

    public Library() {
        catalog = new ArrayList<>();
    }

    // Add a new book to the catalog
    public void addBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        catalog.add(book);
        System.out.println("Book added successfully!");
    }

    // Search for books by title
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("*************************************************************");
        System.out.println("\n\t\t Search by title");
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        System.out.println("*************************************************************");
        if (!found) {
            System.out.println("No books found with the title: " + title);
        }
    }

    // Search for books by author
    public void searchByAuthor(String author) {
        boolean found = false;
        System.out.println("*************************************************************");
        System.out.println("\n\t\t Search by author");
        for (Book book : catalog) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        System.out.println("*************************************************************");
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }

    // List all books in the catalog
    public void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No books available in the catalog.");
        } else {
            System.out.println("*************************************************************");
            System.out.println("\n\t\t List all books");
            for (Book book : catalog) {
                System.out.println(book);
            }
            System.out.println("*************************************************************");
        }
    }
}

// Main class to run the Library Catalog System
public class LibraryCatalog {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Catalog System:");
            System.out.println("1. Add a new book");
            System.out.println("2. Search by title");
            System.out.println("3. Search by author");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(title, author, isbn);
                    break;

                case 2:
                    System.out.print("Enter the title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 3:
                    System.out.print("Enter the author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;

                case 4:
                    library.listBooks();
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
