package pe.marcolopez.auth.domain;

import java.io.Serializable;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean active;
	private Set<Role> roles;
	
	public User(User user) {
		this.id = user.id;
		this.email = user.email;
		this.username = user.username;
		this.password = user.password;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.active = user.active;
		this.roles = user.roles;
	}

}
