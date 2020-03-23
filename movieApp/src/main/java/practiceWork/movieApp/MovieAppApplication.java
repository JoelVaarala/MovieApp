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
			
			Genre genre2 = new Genre("Romance");
			genreRepository.save(genre2);
			
			Genre genre3 = new Genre("Documentary");
			genreRepository.save(genre3);
			
			Genre genre4 = new Genre("Horror");
			genreRepository.save(genre4);
			
			Genre genre5 = new Genre("Comedy");
			genreRepository.save(genre5);
			
			Director director1 = new Director("Spielberg");
			directorRepository.save(director1);
			
			Director director2 = new Director("Tarantino");
			directorRepository.save(director2);
			
			Director director3 = new Director("Eastwood");
			directorRepository.save(director3);
			
			Director director4 = new Director("Nolan");
			directorRepository.save(director4);
			
			Director director5 = new Director("Romero");
			directorRepository.save(director5);
			
			Director director6 = new Director("n/a");
			directorRepository.save(director6);
			
			// few test movies
			movieRepository.save(new Movie("Player2", director1, genre1, 2020, 3));
			movieRepository.save(new Movie("Story2", director3, genre3, 2021, 4));
			movieRepository.save(new Movie("Life2", director5, genre4, 2022, 5));
			
			// Create users: admin/admin (ohjelmointi)  user/user (palvelimet)
			User user1 = new User("user", "$2a$10$2R.Y8lRpO4j7/56Veje6aessT4JY5FkgRDFUjAYlh0CSvQHSsY5ca", "email@1","USER");
			User user2 = new User("admin", "$2a$10$RNBr12SutlTJZXdRC7VBw.0T6cjtZO1pGK6LnGn4zKYWdcrWO19NK", "email@2", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
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
