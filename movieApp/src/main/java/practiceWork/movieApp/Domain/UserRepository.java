package practiceWork.movieApp.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
	User findByUsername(String username); // Must have!
}