package co.com.park.gp.controller.response.parqueadero;

import java.util.ArrayList;

import co.com.park.gp.dto.parqueadero.CiudadDTO;

public class CiudadResponse extends Response<CiudadDTO> {
	
	public CiudadResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
