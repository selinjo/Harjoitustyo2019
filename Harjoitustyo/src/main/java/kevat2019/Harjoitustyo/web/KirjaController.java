package kevat2019.Harjoitustyo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kevat2019.Harjoitustyo.domain.Kirja;
import kevat2019.Harjoitustyo.domain.KirjaLomake;
import kevat2019.Harjoitustyo.domain.KirjaRepository;

@Controller
public class KirjaController {
	@Autowired
	private KirjaRepository repository;
	
	// Listataan sarjakuvat tietokannasta
	@RequestMapping(value="/kirjat")
	public String kirjatLista(Model model) {
		model.addAttribute("kirjat", repository.findAll());
		return "kirjat";
	}
	
	//Listataan sarjakuvat RESTful
	@RequestMapping(value="/kirjatrest", method = RequestMethod.GET)
	public @ResponseBody List<Kirja> kayttajaListRest(){
		return(List<Kirja>)repository.findAll();
	}
	
	// Lisätään sarjakuva
	@RequestMapping(value="/lisaakirja")
	public String lisaaKirja(Model model) {
		model.addAttribute("kirjalomake", new KirjaLomake());
		return "lisaakirja";
	}
	
	// Tallennetaan sarjakuva kirjalomakkeen kautta missä validoinnit
	@RequestMapping(value="/tallennakirja", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("kirjalomake") KirjaLomake kirjaLomake, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			Kirja uusiKirja = new Kirja();
			uusiKirja.setNimi(kirjaLomake.getNimi());
			uusiKirja.setAlbumi(kirjaLomake.getAlbumi());
			uusiKirja.setIsbn(kirjaLomake.getIsbn());
			uusiKirja.setSivumaara(kirjaLomake.getSivumaara());
			uusiKirja.setKunto(kirjaLomake.getKunto());
			uusiKirja.setVuosi(kirjaLomake.getVuosi());
			uusiKirja.setPainos(kirjaLomake.getPainos());
			repository.save(uusiKirja);
		}else {
			return "lisaakirja";
		}
		return "redirect:kirjat";
	}
	
	// Poistetaan sarjakuva tietokannasta
	@RequestMapping(value="/poistakirja/{id}", method=RequestMethod.GET)
		public String poistaKirja(@PathVariable("id") Long kirja_id, Model model) {
		repository.deleteById(kirja_id);
		return "redirect:../kirjat";
	}
}

/*	@RequestMapping(value="/save", method = RequestMethod.POST)
public String save(Kirja kirja) {
repository.save(kirja);
return "redirect:kirjat";
}*/