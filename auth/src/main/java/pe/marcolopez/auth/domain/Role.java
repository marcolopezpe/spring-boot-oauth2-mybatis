package pe.marcolopez.auth.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;

}
