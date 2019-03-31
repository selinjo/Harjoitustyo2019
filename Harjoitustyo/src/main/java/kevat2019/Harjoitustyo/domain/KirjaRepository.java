package kevat2019.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KirjaRepository extends CrudRepository<Kirja, Long> {
	
	List<Kirja> findByNimi(String nimi);
	
}
