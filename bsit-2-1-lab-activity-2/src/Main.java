void main() {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    IO.println("=== Welcome to the Library Management System ===");

    while (running) {
        IO.println("\n--- MAIN MENU ---");
        IO.println("1. Add a Book");
        IO.println("2. List All Books");
        IO.println("3. Search for a Book");
        IO.println("4. Borrow a Book");
        IO.println("5. Return a Book");
        IO.println("6. Exit");
        IO.print("Enter your choice (1-6): ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                IO.print("Enter book title: ");
                String titleInput = scanner.nextLine().trim();
                IO.print("Enter book author: ");
                String authorInput = scanner.nextLine().trim();

                Book newBook = new Book(titleInput, authorInput);
                library.addBook(newBook);
                break;

            case "2":
                library.listBooks();
                break;

            case "3":
                IO.print("Enter the title to search: ");
                String searchTitle = scanner.nextLine().trim();
                boolean found = library.searchBook(searchTitle);

                if (found) {
                    IO.println("Yes, that book exists in our catalog.");
                } else {
                    IO.println("No, that book could not be found.");
                }
                break;

            case "4":
                IO.print("Enter the title of the book to borrow: ");
                String borrowTitle = scanner.nextLine().trim();
                library.borrowBook(borrowTitle);
                break;

            case "5":
                IO.print("Enter the title of the book to return: ");
                String returnTitle = scanner.nextLine().trim();
                library.returnBook(returnTitle);
                break;

            case "6":
                IO.println("Thank you for using the library system. Goodbye!");
                running = false;
                break;

            default:
                IO.println("Invalid selection. Please choose a number between 1 and 6.");
                break;
        }
    }

    scanner.close();
}

static class Book {
    private final String title;
    private final String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }
}

static class Library {
    private final ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        IO.println("Added: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void listBooks() {
        IO.println("\n--- Library Collection ---");
        if (books.isEmpty()) {
            IO.println("The library is currently empty.");
            return;
        }
        for (Book book : books) {
            String status = book.isBorrowed() ? "Borrowed" : "Available";
            IO.println("'" + book.getTitle() + "' by " + book.getAuthor() + " [" + status + "]");
        }
    }

    public boolean searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrow();
                    IO.println("Success: You have borrowed '" + book.getTitle() + "'.");
                } else {
                    IO.println("Sorry: '" + book.getTitle() + "' is already borrowed.");
                }
                return;
            }
        }
        IO.println("Error: '" + title + "' does not exist in this library.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    IO.println("Success: '" + book.getTitle() + "' has been returned.");
                } else {
                    IO.println("Notice: '" + book.getTitle() + "' was not borrowed.");
                }
                return;
            }
        }
        IO.println("Error: '" + title + "' does not belong to this library.");
    }
}
