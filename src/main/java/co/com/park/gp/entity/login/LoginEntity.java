package co.com.park.gp.entity.login;

import java.util.UUID;

import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;

public class LoginEntity {
	
	private UUID id;
	private String usuario;
	private String password;
	
	
	public LoginEntity(UUID id, String usuario, String password) {
		setId(id);
		setUsuario(usuario);
		setPassword(password);
	}
	
	public LoginEntity() {
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	public static final LoginEntity build(){
		return new LoginEntity();
	}

	

	public UUID getId() {
		return id;
	}


	public final LoginEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}


	public String getUsuario() {
		return usuario;
	}


	public final LoginEntity setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);;
		return this;
	}


	public String getPassword() {
		return password;
	}


	public final LoginEntity setPassword(String password) {
		this.password =TextHelper.applyTrim(password);
		return this;
	}
	
	
	
	
	
	

}
