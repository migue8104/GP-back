package co.com.park.gp.business.assembler.entity.impl.login;

import java.util.ArrayList;
import java.util.List;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.login.LoginDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.entity.login.LoginEntity;

public class LoginAssemblerEntity implements AssemblerEntity<LoginDomain, LoginEntity> {

	private static final AssemblerEntity<LoginDomain, LoginEntity> INSTANCE = new LoginAssemblerEntity();

	public LoginAssemblerEntity() {
		super();
	}

	public static AssemblerEntity<LoginDomain, LoginEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public LoginDomain toDomain(LoginEntity data) {
		var LoginEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, LoginEntity.build());
		return LoginDomain.build(LoginEntityTmp.getId(), LoginEntityTmp.getUsuario(), LoginEntityTmp.getPassword());
	}

	@Override
	public List<LoginDomain> toDomainCollection(List<LoginEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<LoginEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public LoginEntity toEntity(LoginDomain domain) {
		var LoginDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, LoginDomain.build());
		return LoginEntity.build().setId(LoginDomainTmp.getId()).setUsuario(LoginDomainTmp.getUsuario())
				.setPassword(LoginDomainTmp.getPassword());
	}

	@Override
	public List<LoginEntity> toEntityCollection(List<LoginDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<LoginDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}
