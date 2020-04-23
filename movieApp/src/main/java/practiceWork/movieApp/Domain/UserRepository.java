package practiceWork.movieApp.Domain;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username); // Must have!
}