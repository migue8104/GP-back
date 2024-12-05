package co.com.park.gp.controller.response.parqueadero;

import java.util.ArrayList;

import co.com.park.gp.dto.parqueadero.TipoSedeDTO;

public class TipoSedeResponse extends Response<TipoSedeDTO> {
	
	public TipoSedeResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
