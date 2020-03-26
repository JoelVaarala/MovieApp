package practiceWork.movieApp.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username); // Must have!
}