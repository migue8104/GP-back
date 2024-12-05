package co.com.park.gp.controller.response.parqueadero;

import java.util.ArrayList;

import co.com.park.gp.dto.parqueadero.PaisDTO;

public class PaisResponse extends Response<PaisDTO>{
	
	public  PaisResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
