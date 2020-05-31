package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;

public class BootstrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "shivanna");
        Book book = new Book("mylife", "isbn1");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author raj = new Author("Spring", "guru");
        Book springBook = new Book("springframework", "isbn2");

        raj.getBooks().add(springBook);
        springBook.getAuthors().add(raj);

        authorRepository.save(raj);
        bookRepository.save(springBook);

        System.out.println("bootstrap started");
        System.out.println("no of books="+ bookRepository.count());

    }
}
