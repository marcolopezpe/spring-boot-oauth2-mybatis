package pe.marcolopez.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import pe.marcolopez.auth.domain.User;

@Mapper
public interface UserMapper {

	User getUserByUsername(String username);
	
}
