package practiceWork.movieApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import practiceWork.movieApp.Domain.Genre;
import practiceWork.movieApp.Domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryTest {
	
	@Autowired
	private GenreRepository genrerepository;

	@Test
	public void FindGenre() {
		List<Genre> genre = genrerepository.findByNameOfGenre("Action");
		assertThat(genre).hasSize(1);
        assertThat(genre.get(0).getNameOfGenre()).isEqualTo("Action");
	}
	
	@Test
	public void AddGenre() {
		Genre genre = new Genre ("TestGen");
		genrerepository.save(genre);
    	assertThat(genre.getNameOfGenre()).isNotNull();
	}
	
	@Test
	public void DeleteGenre() {
		genrerepository.deleteAll();
    	assertThat(genrerepository.count()).isEqualTo(0);
	}
	
}
