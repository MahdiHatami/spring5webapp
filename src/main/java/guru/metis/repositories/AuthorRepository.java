package guru.metis.repositories;

import guru.metis.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
    
}
