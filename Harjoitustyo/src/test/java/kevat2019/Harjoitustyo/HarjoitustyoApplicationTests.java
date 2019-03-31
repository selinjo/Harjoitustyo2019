package kevat2019.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import kevat2019.Harjoitustyo.domain.Kirja;
import kevat2019.Harjoitustyo.domain.KirjaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HarjoitustyoApplicationTests {

	@Autowired
	private KirjaRepository kirjarep;
	
	@Test
	public void lisaaUusiKirja() {
		Kirja kirja=new Kirja("TestiNimi","TestiAlbumi","TestiISBN",42,3,1991,2);
		kirjarep.save(kirja);
		assertThat(kirja.getKirja_id()).isNotNull();
		assertThat(kirja.getNimi()).startsWith("Testi").endsWith("Nimi").isEqualToIgnoringCase("testinimi");
	}

}

