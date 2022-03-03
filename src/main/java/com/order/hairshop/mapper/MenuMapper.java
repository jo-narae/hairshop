package com.order.hairshop.mapper;

import com.order.hairshop.domain.Menu;
import com.order.hairshop.dto.MenuUpsertDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shop.id", source = "shopId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Menu menuInsertRequestToMenu(MenuUpsertDTO menuUpsertDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shop.id", source = "shopId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Menu menuUpdateRequestToMenu(MenuUpsertDTO menuUpsertDTO, @MappingTarget Menu menu);
}
