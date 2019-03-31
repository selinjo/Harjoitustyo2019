package kevat2019.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kevat2019.Harjoitustyo.domain.Kayttaja;
import kevat2019.Harjoitustyo.domain.KayttajaRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final KayttajaRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(KayttajaRepository kayttajaRepository) {
		this.repository = kayttajaRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kayttaja nykkayttaja = repository.findByUsername(username);
		UserDetails kayttaja = new org.springframework.security.core.userdetails.User(username, nykkayttaja.getPasswordHash(),
				AuthorityUtils.createAuthorityList(nykkayttaja.getRooli()));
		return kayttaja;
	}
}
