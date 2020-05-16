package zawadka.adam.covid19.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zawadka.adam.covid19.model.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Long> {
}
