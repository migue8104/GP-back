package co.com.park.gp.data.dao.factory;

import co.com.park.gp.data.dao.entity.parqueadero.CiudadDAO;
import co.com.park.gp.data.dao.entity.parqueadero.DepartamentoDAO;
import co.com.park.gp.data.dao.entity.parqueadero.PaisDAO;
import co.com.park.gp.data.dao.entity.parqueadero.ParqueaderoDAO;
import co.com.park.gp.data.dao.entity.parqueadero.SedeDAO;
import co.com.park.gp.data.dao.entity.parqueadero.TipoSedeDAO;
import co.com.park.gp.data.dao.factory.concrete.PostgresqlDAOFactory;

public interface DAOFactory {
	
	static DAOFactory getFactory() {
		return new PostgresqlDAOFactory();
	}

	void cerrarConexion();

	void iniciarTransaccion();

	void confirmarTransaccion();

	void cancelarTransaccion();
	
	PaisDAO getPaisDAO();
	
	DepartamentoDAO getDepartamentoDAO();
	
	CiudadDAO getCiudadDAO();
	
	ParqueaderoDAO getParqueaderoDAO();
	
	SedeDAO getSedeDAO();
	
	TipoSedeDAO getTipoSedeDAO();

}
