package practiceWork.movieApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import practiceWork.movieApp.Web.UserController;

@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private UserController uController;
	
	@Test
	public void mvcSmokeTest() {
		assertThat(uController).isNotNull();
	}

}
