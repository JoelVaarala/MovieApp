package practiceWork.movieApp.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Integer> {

	List<Director> findByDirName(String dirName);
}
