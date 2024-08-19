package ai.rnt.auth2.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.rnt.auth2.server.entity.OAuthClient;

@RestController
@RequestMapping("/api")
public class RegisterClientController {
	
	@Autowired
    private JdbcRegisteredClientRepository registeredClientRepository;
	
	@PostMapping("/register/client")
	public String registerClient(@RequestBody OAuthClient client) {
		RegisteredClient registeredClient = client.toRegisteredClient();
		registeredClientRepository.save(registeredClient);
		return "Client Registered Successfully!!";
	}

}
