package practiceWork.movieApp.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practiceWork.movieApp.Domain.Movie;
import practiceWork.movieApp.Domain.MovieRepository;
import practiceWork.movieApp.Domain.GenreRepository;
import practiceWork.movieApp.Domain.DirectorRepository;

@RestController
@RequestMapping(value = "/movies-rest", produces = { MediaType.APPLICATION_JSON_VALUE})
public class MovieRestController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	public MovieRepository getRepository() {
		return movieRepository;
	}
	
	public void setRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping(value = "/movies")
	public List<Movie> getAllMovies(){
		return (List<Movie>) movieRepository.findAll();
	}
	
	@PostMapping("/movies")
	Movie createOrSaveMovie(@RequestBody Movie newMovie) {
		return movieRepository.save(newMovie);
	}
	
	@GetMapping("/movies/{id}")
	Movie getMovieById(@PathVariable int id) {
		return movieRepository.findById(id).get();
	}
	
	@PutMapping("/movies/{id}")
	Movie updateMovie(@RequestBody Movie newMovie, @PathVariable int id) {
		return movieRepository.findById(id).map(movie -> {
			movie.setTitle(newMovie.getTitle());
			movie.setYear(newMovie.getYear());
			movie.setPoints(newMovie.getPoints());
			return movieRepository.save(movie);
		}).orElseGet(() -> {
			newMovie.setId(id);
			return movieRepository.save(newMovie);
		});
	}
	
	@DeleteMapping("/movies/{id}")
	void deleteMovie(@PathVariable int id) {
		movieRepository.deleteById(id);
	}

}


