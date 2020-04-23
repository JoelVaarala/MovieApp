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
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dirId;
	private String dirName;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "director")
	private List<Movie> movies;

	public Director() {
		super();
	}

	public Director(String dirName) {
		super();
		this.dirName = dirName;
	}

	public int getDirId() {
		return dirId;
	}

	public void setDirId(int dirId) {
		this.dirId = dirId;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	@Override
	public String toString() {
		return "Director [dirId=" + dirId + ", dirName=" + dirName + "]";
	}

}
