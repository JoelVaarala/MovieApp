package practiceWork.movieApp.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull(message = "Remember title")
	@Size(min = 2, max = 50, message = "Title has to be between 2-50 characters")
	private String title;

	@Min(value = 1800, message = "Too early production")
	@Max(value = 2020, message = "No future movies accepted")
	@NotNull(message = "Empty field")
	private int year;

	@Min(value = 0, message = "Cant go negative")
	@Max(value = 5, message = "Remember the scale (0-5)")
	@NotNull(message = "Empty field")
	private int points;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "genreId") /* here genre id */
	private Genre genre;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "dirId")
	private Director director;

	public Movie() {
		super();
		this.title = null;
		this.year = 0;
		this.points = 0;
	}

	public Movie(String title, Director director, Genre genre, int year, int points) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.year = year;
		this.points = points;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@Override
	public String toString() {
		if (this.genre != null && this.director != null)
			return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", points=" + points + ", genre="
					+ this.getGenre() + ", director=" + this.getDirector() + "]";
		else
			return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", points=" + points + "]";
	}

}
