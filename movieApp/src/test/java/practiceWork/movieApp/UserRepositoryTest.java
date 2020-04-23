package practiceWork.movieApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import practiceWork.movieApp.Domain.User;
import practiceWork.movieApp.Domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userrepository;

	@Test
	public void findByIdCheckIfNull() {
		User user = userrepository.findById(1).get();
		assertNotNull(user);
	}

	@Test
	public void createNewUser() {
		User user = new User("UserT", "UserT", "User@t.com", "USER");
		userrepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteUsers() {
		userrepository.deleteAll();
		assertThat(userrepository.count()).isEqualTo(0);
	}

}
