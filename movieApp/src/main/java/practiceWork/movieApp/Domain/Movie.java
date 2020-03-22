package practiceWork.movieApp.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private int year;
	private int points;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreId")/* here genre id */
	private Genre genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "dirId")
	private Director director;
	
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
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", points=" + points + ", genre=" + 
				this.getGenre() + ", director=" + this.getDirector() + "]";
		else 
			return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", points=" + points + "]";
	}
	
	

}
