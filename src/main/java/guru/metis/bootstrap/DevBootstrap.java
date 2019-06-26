package guru.metis.bootstrap;

import guru.metis.model.Author;
import guru.metis.model.Book;
import guru.metis.repositories.AuthorRepository;
import guru.metis.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        initData();
    }

    private void initData()
    {
        Author mahdi = new Author("Mahdi", "HV");
        Book b1 = new Book("Domain Driven Design", "1242", "Harper Collins");
        mahdi.getBooks().add(b1);
        b1.getAuthors().add(mahdi);
        authorRepository.save(mahdi);
        bookRepository.save(b1);

        Author ali = new Author("Ali ", "HV");
        Book b2 = new Book("J2EE Development without EJB", "23423", "NEIL");
        ali.getBooks().add(b2);
        authorRepository.save(ali);
        bookRepository.save(b2);

    }
}
