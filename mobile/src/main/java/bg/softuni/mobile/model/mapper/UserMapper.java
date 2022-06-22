package bg.softuni.mobile.model.mapper;

import bg.softuni.mobile.model.dto.UserRegisterDTO;
import bg.softuni.mobile.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);
}
