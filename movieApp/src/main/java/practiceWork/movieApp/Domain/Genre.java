package practiceWork.movieApp.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int genreId;
	private String nameOfGenre;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Movie> movies;
	
	public Genre() {
		super();
	}

	public Genre(String nameOfGenre) {
		super();
		this.nameOfGenre = nameOfGenre;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getNameOfGenre() {
		return nameOfGenre;
	}

	public void setNameOfGenre(String nameOfGenre) {
		this.nameOfGenre = nameOfGenre;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", nameOfGenre=" + nameOfGenre + "]";
	}

}
