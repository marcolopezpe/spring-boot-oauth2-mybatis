package pe.marcolopez.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.RequiredArgsConstructor;
import pe.marcolopez.auth.domain.CustomUserDetails;
import pe.marcolopez.auth.mapper.UserMapper;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String clientId = request.getParameter("client_id");
		log.info("### client_id <- {}", clientId);
		
		return Optional.ofNullable(userMapper.getUserByUsername(username))
						.map(CustomUserDetails::new)
						.orElseThrow(() -> new UsernameNotFoundException(username));
	}
	
}
