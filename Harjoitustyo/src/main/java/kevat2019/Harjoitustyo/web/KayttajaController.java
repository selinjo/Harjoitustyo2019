package kevat2019.Harjoitustyo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kevat2019.Harjoitustyo.domain.Kayttaja;
import kevat2019.Harjoitustyo.domain.KayttajaLomake;
import kevat2019.Harjoitustyo.domain.KayttajaRepository;

@Controller
public class KayttajaController {
	@Autowired
	private KayttajaRepository repository;
    
	// Kirjaudu -sivulle
    @RequestMapping(value="/kirjaudu")
    public String kirjaudu() {	
        return "kirjaudu";
    }
    
    // Listataan käyttäjät
	@RequestMapping(value="/kayttajat")
	public String kirjatLista(Model model) {
		model.addAttribute("kayttajat", repository.findAll());
		return "kayttajat";
	}
	
	//Listataan käyttäjät RESTful
	@RequestMapping(value="/kayttajatrest", method = RequestMethod.GET)
	public @ResponseBody List<Kayttaja> kayttajaListRest(){
		return(List<Kayttaja>)repository.findAll();
	}
	
	
    // Lisätään käyttäjä
    @RequestMapping(value = "/lisaakayttaja")
    public String lisaaKayttaja(Model model){
    	model.addAttribute("kayttajalomake", new KayttajaLomake());
        return "lisaakayttaja";
    }     
    
    // Tallennetaan käyttäjä
    @RequestMapping(value = "tallennakayttaja", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("kayttajalomake") KayttajaLomake kayttajaLomake, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
        	String pwd = kayttajaLomake.getPassword();
        	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
	    	String hashPwd = bc.encode(pwd);
	    	
	    	Kayttaja uusiKayttaja = new Kayttaja();
	    	uusiKayttaja.setUsername(kayttajaLomake.getUsername());
	    	uusiKayttaja.setEtunimi(kayttajaLomake.getEtunimi());
	    	uusiKayttaja.setSukunimi(kayttajaLomake.getSukunimi());
	    	uusiKayttaja.setPasswordHash(hashPwd);
	    	uusiKayttaja.setRooli(kayttajaLomake.getRooli());
	    	if (repository.findByUsername(kayttajaLomake.getUsername()) == null) {
	    		repository.save(uusiKayttaja);
	    	}else {
	    		bindingResult.rejectValue("username", "err.username", "Käyttäjätunnus on jo olemassa");
	    		return "lisaakayttaja";
	    	}
        }else {
    		return "lisaakayttaja";
    	}
        return "redirect:kayttajat";
    }
    
    // Poistetaan käyttäjä
	@RequestMapping(value="/poistakayttaja/{id}", method=RequestMethod.GET)
	public String poistaKayttaja(@PathVariable("id") Long kayttaja_id, Model model) {
		repository.deleteById(kayttaja_id);
		return "redirect:../kayttajat";
}
    
}
