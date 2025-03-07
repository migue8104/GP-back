package co.com.park.gp.data.dao.entity.concrete.postgresql.parqueadero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.park.gp.crosscutting.exceptions.custom.DataGPException;
import co.com.park.gp.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.com.park.gp.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.data.dao.entity.parqueadero.SedeDAO;
import co.com.park.gp.entity.parqueadero.CiudadEntity;
import co.com.park.gp.entity.parqueadero.DepartamentoEntity;
import co.com.park.gp.entity.parqueadero.PaisEntity;
import co.com.park.gp.entity.parqueadero.ParqueaderoEntity;
import co.com.park.gp.entity.parqueadero.SedeEntity;
import co.com.park.gp.entity.parqueadero.TipoSedeEntity;

public class SedePostgresqlDAO extends SqlConnection implements SedeDAO {

	public SedePostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(SedeEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();

		sentenciaSql.append("INSERT INTO Sede (id, nombresede, celdascarro, celdamoto, caldascamion, ");
		sentenciaSql.append("correoelectronico, direccion, ciudad_id, departamento_id, pais_id, ");
		sentenciaSql.append("parqueadero_id, tiposede_id) ");
		sentenciaSql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setInt(3, data.getCeldasCarro());
			sentenciaSqlPreparada.setInt(4, data.getCeldasMoto());
			sentenciaSqlPreparada.setInt(5, data.getCeldascamion());
			sentenciaSqlPreparada.setString(6, data.getCorreoElectronico());
			sentenciaSqlPreparada.setString(7, data.getDireccion());
			sentenciaSqlPreparada.setObject(8, data.getCiudad().getId());
			sentenciaSqlPreparada.setObject(9, data.getDepartamento().getId());
			sentenciaSqlPreparada.setObject(10, data.getPais().getId());
			sentenciaSqlPreparada.setObject(11, data.getParqueadero().getId());
			sentenciaSqlPreparada.setObject(12, data.getTipoSede().getId());

			sentenciaSqlPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00045);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00045);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public List<SedeEntity> consultar(SedeEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("select s.id, s.nombresede, s.direccion, s.correoelectronico, s.celdascarro,");
		sentenciaSql.append(" s.celdamoto, s.caldascamion, c.id as idCiudad,");
		sentenciaSql.append(" c.nombre as nombreciudad, d.id as idDepartamento,");
		sentenciaSql.append(" d.nombre as nombredepartamento, p.id as idPais,");
		sentenciaSql.append(" p.nombre as nombrepais, par.id as idParqueadero, ");
		sentenciaSql.append(" par.nombre as nombreparqueadero, t.id as idTipoSede, t.nombre as tiposede");
		sentenciaSql.append(" from sede s");
		sentenciaSql.append(" inner join ciudad c on c.id = s.ciudad_id");
		sentenciaSql.append(" inner join departamento d on d.id = c.departamento_id");
		sentenciaSql.append(" inner join pais p on p.id = d.pais_id");
		sentenciaSql.append(" inner join parqueadero par on par.id = s.parqueadero_id");
		sentenciaSql.append(" inner join tiposede t on t.id = s.tiposede_id");
		sentenciaSql.append(" WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND s.id = ?");
			parametros.add(data.getId());
		}

		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND s.nombresede= ?");
			parametros.add(data.getNombre());
		}

		if (!TextHelper.isNullOrEmpty(data.getCorreoElectronico())) {
			sentenciaSql.append(" AND s.correoelectronico = ?");
			parametros.add(data.getCorreoElectronico());
		}

		if (!TextHelper.isNullOrEmpty(data.getDireccion())) {
			sentenciaSql.append(" AND s.direccion = ?");
			parametros.add(data.getDireccion());
		}

		if (!ObjectHelper.getObjectHelper().isNull(data.getParqueadero())
				&& !ObjectHelper.getObjectHelper().isNull(data.getParqueadero().getId())
				&& !data.getParqueadero().getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND par.id = ?");
			parametros.add(data.getParqueadero().getId());
		}

		final List<SedeEntity> sedes = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					SedeEntity sede = new SedeEntity();
					sede.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
					sede.setNombre(resultado.getString("nombresede"));
					sede.setDireccion(resultado.getString("direccion"));
					sede.setCorreoElectronico(resultado.getString("correoelectronico"));
					sede.setCeldasCarro(resultado.getInt("celdascarro"));
					sede.setCeldasMoto(resultado.getInt("celdamoto"));
					sede.setCeldascamion(resultado.getInt("caldascamion"));

					CiudadEntity ciudad = CiudadEntity.build();
					ciudad.setId(UUIDHelper.convertToUUID(resultado.getString("idCiudad")));
					sede.setCiudad(ciudad);

					DepartamentoEntity departamento = DepartamentoEntity.build();
					departamento.setId(UUIDHelper.convertToUUID(resultado.getString("idDepartamento")));
					sede.setDepartamento(departamento);

					PaisEntity pais = PaisEntity.build();
					pais.setId(UUIDHelper.convertToUUID(resultado.getString("idPais")));
					sede.setPais(pais);

					TipoSedeEntity tipoSede = TipoSedeEntity.build();
					tipoSede.setId(UUIDHelper.convertToUUID(resultado.getString("idTipoSede")));
					sede.setTipoSede(tipoSede);

					ParqueaderoEntity parqueadero = ParqueaderoEntity.build();
					parqueadero.setId(UUIDHelper.convertToUUID(resultado.getString("idParqueadero")));
					sede.setParqueadero(parqueadero);

					sedes.add(sede);
				}
			}

		} catch (SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return sedes;
	}

}
