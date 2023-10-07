package com.sistemaescolar.app.controlador;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class ConfigSecurity{
	@Autowired
	private DataSource dataSource;
	@Autowired
	private PasswordEncoder passwordeconder;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		http.authorizeHttpRequests(
				(Requests)-> Requests.requestMatchers("/css/**","/js/**","/img/**","/")
				.permitAll()
				.anyRequest()
				.authenticated())
		        .formLogin((form)->form.loginPage("/login").permitAll())
		        .logout((logout)->logout.permitAll());
                return http.build();
		
	}
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder)throws Exception{
		final String usuario="select usuario,password enable from usuarios where usuario = ?";
		final String roles ="SELECT u.usuario,p.perfil "
				+ "from authorities a inner join usuarios u on (a.idusuario=u.id) "
				+ "inner join perfiles p on (p.id=a.idperfil) where usuario=?";
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordeconder)
		.usersByUsernameQuery(usuario)
		.authoritiesByUsernameQuery(roles);
		
	}
	
	

	

}
