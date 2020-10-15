package upeu.edu.pe.lp2exa1DeboraAlejandro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.lp2exa1DeboraAlejandro.Entity.Usuario;
import upeu.edu.pe.lp2exa1DeboraAlejandro.Security.JwtUil;

@RestController
public class Homecontroller {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUil jwUtil;
	
	@GetMapping("/Bienvenido")
	public String mensaje() {
		return "Bienvenidos a Microservicios Sincronos";
	}
	
	 @PostMapping("/authenticate")
	    public String generateToken(@RequestBody Usuario authRequest) throws Exception {
	        try {
	        	System.out.println(authRequest.getNomuser());
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
	            		(authRequest.getNomuser(), authRequest.getClave()));
	        } catch (Exception ex) {
	            throw new Exception("Error: "+ex);
	        }
	       return jwUtil.generateToken(authRequest.getNomuser());
	    }
}


