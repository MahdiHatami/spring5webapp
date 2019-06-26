package guru.metis.repositories;

import guru.metis.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
