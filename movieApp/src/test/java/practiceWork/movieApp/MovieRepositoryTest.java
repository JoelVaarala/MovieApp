package practiceWork.movieApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import practiceWork.movieApp.Domain.Movie;
import practiceWork.movieApp.Domain.Genre;
import practiceWork.movieApp.Domain.Director;
import practiceWork.movieApp.Domain.MovieRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Test
    public void findByTitleReturnMovie() {
        List<Movie> movies = movieRepository.findByTitle("Ready Player One"); 
        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getYear()).isEqualTo(2018);
    }
	
	@Test
    public void createNewMovie() {
    	Movie movie = new Movie("Test Movie", new Director("TestA"), new Genre("TestB"), 2020, 2);
    	movieRepository.save(movie);
    	assertThat(movie.getId()).isNotNull();
    }
	
	@Test
	public void deleteMovies() {
    	movieRepository.deleteAll();
    	assertThat(movieRepository.count()).isEqualTo(0);
	}

}
