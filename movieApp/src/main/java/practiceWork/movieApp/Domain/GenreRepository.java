package practiceWork.movieApp.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

	List<Genre> findByNameOfGenre(String nameOfGenre);
	
}
