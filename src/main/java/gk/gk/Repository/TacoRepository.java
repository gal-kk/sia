package gk.gk.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
