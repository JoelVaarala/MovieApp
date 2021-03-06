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
	public CommandLineRunner movieDemo(MovieRepository movieRepository, GenreRepository genreRepository,
			DirectorRepository directorRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of movies");

			Genre genre1 = new Genre("Action");
			genreRepository.save(genre1);

			Genre genre2 = new Genre("Romance");
			genreRepository.save(genre2);

			Genre genre3 = new Genre("Drama");
			genreRepository.save(genre3);

			Genre genre4 = new Genre("Horror");
			genreRepository.save(genre4);

			Genre genre5 = new Genre("Comedy");
			genreRepository.save(genre5);

			Genre genre6 = new Genre("n/a");
			genreRepository.save(genre6);

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
			movieRepository.save(new Movie("Ready Player One", director1, genre1, 2018, 3));
			movieRepository.save(new Movie("Django unchained", director2, genre3, 2012, 4));
			movieRepository.save(new Movie("Night of the living dead", director5, genre4, 1992, 5));
			movieRepository.save(new Movie("Sudden Impact", director3, genre1, 1987, 2));

			// Create users: user2=admin Password:ohjelmointi , user1=user Password:
			// palvelimet (tai oma käyttäjä)
			User user1 = new User("user", "$2a$10$2R.Y8lRpO4j7/56Veje6aessT4JY5FkgRDFUjAYlh0CSvQHSsY5ca", "email@1",
					"USER");
			User user2 = new User("admin", "$2a$10$RNBr12SutlTJZXdRC7VBw.0T6cjtZO1pGK6LnGn4zKYWdcrWO19NK", "email@2",
					"ADMIN");
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
