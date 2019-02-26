package kevat2019.Harjoitustyo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KayttajaController {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/kayttajat")
	public String kayttajatLista(Model model) {
		List<Map<String, Object>> kayttajat = jdbcTemplate.queryForList("select etunimi, sukunimi from PO_Kayttajat");
		
		model.addAttribute("kayttajat", kayttajat);
		return "kayttajat";
	}
}
