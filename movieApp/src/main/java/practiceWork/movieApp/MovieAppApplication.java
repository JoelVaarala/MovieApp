package practiceWork.movieApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import practiceWork.movieApp.Domain.Movie;
import practiceWork.movieApp.Domain.MovieRepository;
import practiceWork.movieApp.Domain.Genre;
import practiceWork.movieApp.Domain.GenreRepository;
import practiceWork.movieApp.Domain.Director;
import practiceWork.movieApp.Domain.DirectorRepository;
import practiceWork.movieApp.Domain.User;
import practiceWork.movieApp.Domain.UserRepository;

@SpringBootApplication
public class MovieAppApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MovieAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepository, GenreRepository genreRepository, DirectorRepository directorRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of movies");
			
			Genre genre1 = new Genre("Action");
			genreRepository.save(genre1);
			
			Director director1 = new Director("Spielberg");
			directorRepository.save(director1);
			
			movieRepository.save(new Movie("Player2", director1, genre1, 2020, 3));
			
			log.info("fetch all genres");
			for (Genre genre : genreRepository.findAll()) {
				log.info(genre.toString());
			}
			
			log.info("fetch all directors");
			for (Director director : directorRepository.findAll()) {
				log.info(director.toString());
			}
			
			log.info("fetch all movies");
			for (Movie movie : movieRepository.findAll()) {
				log.info(movie.toString());
			}
			
		};
	}
}
