package co.com.park.gp.controller.response.parqueadero;

import java.util.ArrayList;

import co.com.park.gp.dto.parqueadero.ParqueaderoDTO;

public class ParqueaderoResponse extends Response<ParqueaderoDTO>{
	
	public ParqueaderoResponse(){
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
