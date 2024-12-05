package co.com.park.gp.business.domain.login;

import java.util.UUID;

import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;

public class LoginDomain {
	
	private UUID id;
	private String usuario;
	private String password;
	
	public LoginDomain(UUID id, String usuario, String password) {
		setId(id);
		setUsuario(usuario);
		setPassword(password);
	}
	
	public LoginDomain() {
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setPassword(TextHelper.EMPTY);
	}
	
	public static final LoginDomain build() {
		return new LoginDomain();
	}
	
	public static LoginDomain build(final UUID id, final String usuario , String password) {
		return new LoginDomain(id, usuario,password);
	}

	public static LoginDomain build(final UUID id) {
		return new LoginDomain(id, TextHelper.EMPTY, TextHelper.EMPTY);
	}
	






	public UUID getId() {
		return id;
	}
	public LoginDomain setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public String getUsuario() {
		return usuario;
	}
	public LoginDomain setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
		return this;
	}
	public String getPassword() {
		return password;
	}
	public LoginDomain setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
		return this;
	}
	

}
