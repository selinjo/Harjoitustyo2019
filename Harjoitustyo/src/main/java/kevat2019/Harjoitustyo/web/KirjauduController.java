package kevat2019.Harjoitustyo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KirjauduController {
	@RequestMapping("/kirjaudu")
	public String home() {	
		return "kirjaudu";
	}
}
