package co.com.park.gp.business.assembler.dto.impl.parqueadero;

import java.util.ArrayList;
import java.util.List;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.parqueadero.CiudadDomain;
import co.com.park.gp.business.domain.parqueadero.DepartamentoDomain;
import co.com.park.gp.business.domain.parqueadero.PaisDomain;
import co.com.park.gp.business.domain.parqueadero.ParqueaderoDomain;
import co.com.park.gp.business.domain.parqueadero.SedeDomain;
import co.com.park.gp.business.domain.parqueadero.TipoSedeDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.parqueadero.CiudadDTO;
import co.com.park.gp.dto.parqueadero.DepartamentoDTO;
import co.com.park.gp.dto.parqueadero.PaisDTO;
import co.com.park.gp.dto.parqueadero.ParqueaderoDTO;
import co.com.park.gp.dto.parqueadero.SedeDTO;
import co.com.park.gp.dto.parqueadero.TipoSedeDTO;

public class SedeAssemblerDTO implements AssemblerDTO<SedeDomain, SedeDTO> {

	private static final AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> parqueaderoAssembler = ParqueaderoAssemblerDTO
			.getInstance();
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> ciudadAssembler = CiudadAssemblerDTO.getInstance();
	private static final AssemblerDTO<TipoSedeDomain, TipoSedeDTO> tipoSedeAssembler = TipoSedeAssemblerDTO
			.getInstance();
	private static final AssemblerDTO<PaisDomain, PaisDTO> paisAssembler = PaisAssemblerDTO.getInstance();
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO
			.getInstance();

	private static final AssemblerDTO<SedeDomain, SedeDTO> instance = new SedeAssemblerDTO();

	private SedeAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<SedeDomain, SedeDTO> getInstance() {
		return instance;
	}

	@Override
	public SedeDomain toDomain(SedeDTO data) {
		var sedeDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, SedeDTO.build());
		var parqueaderoDomain = parqueaderoAssembler.toDomain(sedeDtoTmp.getParqueadero());
		var ciudadDomain = ciudadAssembler.toDomain(sedeDtoTmp.getCiudad());
		var tipoSedeDomain = tipoSedeAssembler.toDomain(sedeDtoTmp.getTipoSede());
		var paisDomain = paisAssembler.toDomain(sedeDtoTmp.getPais());
		var departamentoDomain = departamentoAssembler.toDomain(sedeDtoTmp.getDepartamento());
		return SedeDomain.build(sedeDtoTmp.getId(), parqueaderoDomain, sedeDtoTmp.getNombre(), ciudadDomain,
				sedeDtoTmp.getDireccion(), sedeDtoTmp.getCorreoElectronico(), sedeDtoTmp.getCeldasCarro(),
				sedeDtoTmp.getCeldasMoto(), sedeDtoTmp.getCeldascamion(), tipoSedeDomain, paisDomain,
				departamentoDomain);
	}

	@Override
	public SedeDTO toDto(SedeDomain domain) {
		var sedeDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, SedeDomain.build());
		var parqueaderoDto = parqueaderoAssembler.toDto(sedeDomainTmp.getParqueadero());
		var ciudadDto = ciudadAssembler.toDto(sedeDomainTmp.getCiudad());
		var tipoSedeDto = tipoSedeAssembler.toDto(sedeDomainTmp.getTipoSede());
		var paisDto = paisAssembler.toDto(sedeDomainTmp.getPais());
		var departamentoDto = departamentoAssembler.toDto(sedeDomainTmp.getDepartamento());
		return SedeDTO.build().setId(sedeDomainTmp.getId()).setParqueadero(parqueaderoDto)
				.setNombre(sedeDomainTmp.getNombre()).setCiudad(ciudadDto).setDireccion(sedeDomainTmp.getDireccion())
				.setCorreoElectronico(sedeDomainTmp.getCorreoElectronico())
				.setCeldasCarro(sedeDomainTmp.getCeldasCarro()).setCeldasMoto(sedeDomainTmp.getCeldasMoto())
				.setCeldascamion(sedeDomainTmp.getCeldascamion()).setTipoSede(tipoSedeDto).setPais(paisDto)
				.setDepartamento(departamentoDto);
	}

	@Override
	public List<SedeDomain> toDomainCollection(List<SedeDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection, new ArrayList<SedeDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<SedeDTO> toDTOCollection(List<SedeDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<SedeDomain>());
		return domainCollectionTmp.stream().map(this::toDto).toList();
	}

}
