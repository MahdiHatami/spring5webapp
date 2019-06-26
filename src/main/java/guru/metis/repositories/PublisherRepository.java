package guru.metis.repositories;

import guru.metis.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>
{
}
