package co.com.park.gp.business.assembler.dto.impl.login;

import java.util.ArrayList;
import java.util.List;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.login.LoginDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.login.LoginDTO;

public class LoginAssemblerDTO implements AssemblerDTO<LoginDomain, LoginDTO> {

	private static final AssemblerDTO<LoginDomain, LoginDTO> instance = new LoginAssemblerDTO();

	private LoginAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<LoginDomain, LoginDTO> getInstance() {
		return instance;
	}

	@Override
	public LoginDomain toDomain(LoginDTO data) {
		var loginDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, LoginDTO.build());
		return LoginDomain.build(loginDtoTmp.getId(), loginDtoTmp.getUsuario(), loginDtoTmp.getPassword());
	}

	@Override
	public List<LoginDomain> toDomainCollection(List<LoginDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection,
				new ArrayList<LoginDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public LoginDTO toDto(LoginDomain domain) {
		var loginDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, LoginDomain.build());
		return LoginDTO.build().setId(loginDomainTmp.getId()).setUsuario(loginDomainTmp.getUsuario())
				.setPassword(loginDomainTmp.getPassword());
	}

	@Override
	public List<LoginDTO> toDTOCollection(List<LoginDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<LoginDomain>());
		return domainCollectionTmp.stream().map(this::toDto).toList();
	}

}
