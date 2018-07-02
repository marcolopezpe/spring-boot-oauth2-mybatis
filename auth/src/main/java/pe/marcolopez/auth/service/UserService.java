package pe.marcolopez.auth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.marcolopez.auth.domain.User;
import pe.marcolopez.auth.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	
	public User getUser(String username) {
		return userMapper.getUserByUsername(username);
	}
	
}
