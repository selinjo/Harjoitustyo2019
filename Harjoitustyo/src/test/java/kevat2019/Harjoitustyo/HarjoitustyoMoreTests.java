package kevat2019.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kevat2019.Harjoitustyo.web.KirjaController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HarjoitustyoMoreTests {

	@Autowired
	private KirjaController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
