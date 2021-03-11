package com.abouerp.zsc.register.mapper;

import com.abouerp.zsc.register.domain.Administrator;
import com.abouerp.zsc.register.vo.AdministratorVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


/**
 * @author Abouerp
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdministratorMapper {

    AdministratorMapper INSTANCE = Mappers.getMapper(AdministratorMapper.class);

    Administrator toAdmin(AdministratorVO administratorVO);

}
