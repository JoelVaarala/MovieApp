package practiceWork.movieApp.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practiceWork.movieApp.Domain.Movie;
import practiceWork.movieApp.Domain.MovieRepository;
import practiceWork.movieApp.Domain.GenreRepository;
import practiceWork.movieApp.Domain.DirectorRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private DirectorRepository directorRepository;

	// login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// movie listing
	@RequestMapping(value = "/movielist", method = RequestMethod.GET)
	public String getMovies(Model model) {
	List<Movie> movies = (List<Movie>) movieRepository.findAll();
	model.addAttribute("movies", movies);
	return "MovieList";
	
	}
	
	// empty movie form
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	@RequestMapping(value = "/newmovie", method = RequestMethod.GET)
	public String getNewMovieForm(Model model) {
	model.addAttribute("movie", new Movie());
	model.addAttribute("genre", genreRepository.findAll());
	model.addAttribute("director", directorRepository.findAll());
	return "MovieForm";
	}
	
	// form data receiver
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute Movie movie) {
		movieRepository.save(movie);
		return "redirect:/movielist";
	}
	
	// movie edit
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}")
	public String editMovie(@PathVariable("id") int movieId, Model model) {
		model.addAttribute("movie", movieRepository.findById(movieId));
		model.addAttribute("genre", genreRepository.findAll());
		model.addAttribute("director", directorRepository.findAll());
		return "MovieEdit";
	}
	
	// movie delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletemovie/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") int movieId) {
		movieRepository.deleteById(movieId);
		return "redirect:../movielist";
	}
}


