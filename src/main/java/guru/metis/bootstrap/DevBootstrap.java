package guru.metis.bootstrap;

import guru.metis.model.Author;
import guru.metis.model.Book;
import guru.metis.model.Publisher;
import guru.metis.repositories.AuthorRepository;
import guru.metis.repositories.BookRepository;
import guru.metis.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        initData();
    }

    private void initData()
    {
        Publisher publisher = new Publisher("OREILY", "NYC");
        publisherRepository.save(publisher);

        Author mahdi = new Author("Mahdi", "HV");
        Book b1 = new Book("Domain Driven Design", "1242", publisher);
        mahdi.getBooks().add(b1);
        b1.getAuthors().add(mahdi);

        authorRepository.save(mahdi);
        bookRepository.save(b1);

        Author ali = new Author("Ali ", "HV");
        Book b2 = new Book("J2EE Development without EJB", "23423", publisher);

        ali.getBooks().add(b2);
        authorRepository.save(ali);
        bookRepository.save(b2);

    }
}
