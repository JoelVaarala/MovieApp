package practiceWork.movieApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import practiceWork.movieApp.Domain.Director;
import practiceWork.movieApp.Domain.DirectorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DirectorRepositoryTest {

	@Autowired
	private DirectorRepository directorrepository;

	@Test
	public void FindDirector() {
		List<Director> director = directorrepository.findByDirName("Romero");
		assertThat(director).hasSize(1);
		assertThat(director.get(0).getDirName()).isEqualTo("Romero");
	}

	@Test
	public void AddCategory() {
		Director director = new Director("TestDir");
		directorrepository.save(director);
		assertThat(director.getDirName()).isNotNull();
	}

	@Test
	public void DeleteDirector() {
		directorrepository.deleteAll();
		assertThat(directorrepository.count()).isEqualTo(0);
	}

}
