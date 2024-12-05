package co.com.park.gp.dto.login;

import java.util.UUID;

import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;

public class LoginDTO {
	
	private UUID id;
	private String usuario;
	private String password;
	
	public LoginDTO(UUID id, String usuario, String password) {
		setId(id);
		setUsuario(usuario);
		setPassword(password);
	}
	
	public LoginDTO() {
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	public static final LoginDTO build() {
		return new LoginDTO();
	}
	






	public UUID getId() {
		return id;
	}
	public LoginDTO setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public String getUsuario() {
		return usuario;
	}
	public LoginDTO setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
		return this;
	}
	public String getPassword() {
		return password;
	}
	public LoginDTO setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
		return this;
	}
	
	

}
