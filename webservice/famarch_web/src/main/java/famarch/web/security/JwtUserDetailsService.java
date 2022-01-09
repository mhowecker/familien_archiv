package famarch.web.security;

import java.util.ArrayList;

import famarch.web.dbdata.Benutzer;
import famarch.web.repository.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private BenutzerRepository benutzerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Benutzer benutzer = benutzerRepository.findBenutzerByName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return new org.springframework.security.core.userdetails.User(benutzer.getName(), benutzer.getPasswort(),new ArrayList<>());
	}
}
