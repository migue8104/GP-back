package co.com.park.gp.controller.response.parqueadero;

import java.util.ArrayList;

import co.com.park.gp.dto.parqueadero.DepartamentoDTO;

public class DepartamentoResponse extends Response<DepartamentoDTO>{

	public DepartamentoResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
	
	

}
