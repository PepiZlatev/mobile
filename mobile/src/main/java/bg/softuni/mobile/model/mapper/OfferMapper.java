package bg.softuni.mobile.model.mapper;

import bg.softuni.mobile.model.dto.AddOfferDTO;
import bg.softuni.mobile.model.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
