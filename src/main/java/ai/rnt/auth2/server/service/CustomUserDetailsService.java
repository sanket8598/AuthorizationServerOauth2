package ai.rnt.auth2.server.service;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ai.rnt.auth2.server.entity.EmployeeMaster;
import ai.rnt.auth2.server.entity.RoleMaster;
import ai.rnt.auth2.server.repository.EmployeeMasterRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeMasterRepository userRepository;

    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeeMaster user = userRepository.findByUserId(email);
		if (user == null) {
			throw new UsernameNotFoundException("No User Found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), true, true,
				true, true, user.getEmployeeRole().stream().map(RoleMaster::getRoleName)
						.map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	}
}
