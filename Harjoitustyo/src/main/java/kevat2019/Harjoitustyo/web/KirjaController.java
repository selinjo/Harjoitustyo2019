package kevat2019.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kevat2019.Harjoitustyo.domain.Kirja;
import kevat2019.Harjoitustyo.domain.KirjaRepository;

@Controller
public class KirjaController {
	@Autowired
	private KirjaRepository repository;
	
	@RequestMapping(value = "/kirjat")
	public String kirjatLista(Model model) {
		model.addAttribute("kirjat", repository.findAll());
		return "kirjat";
	}
	
	@RequestMapping(value = "/lisaa")
	public String lisaaKirja(Model model) {
		model.addAttribute("kirja", new Kirja());
		return "lisaakirja";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Kirja kirja) {
		repository.save(kirja);
		return "redirect:kirjat";
	}


}
