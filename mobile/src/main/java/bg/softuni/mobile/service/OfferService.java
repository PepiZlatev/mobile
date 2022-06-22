package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.AddOfferDTO;
import bg.softuni.mobile.model.entity.ModelEntity;
import bg.softuni.mobile.model.entity.OfferEntity;
import bg.softuni.mobile.model.entity.UserEntity;
import bg.softuni.mobile.model.mapper.OfferMapper;
import bg.softuni.mobile.repository.ModelRepository;
import bg.softuni.mobile.repository.OfferRepository;
import bg.softuni.mobile.repository.UserRepository;
import bg.softuni.mobile.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private OfferMapper offerMapper;
    private UserRepository userRepository;
    private CurrentUser currentUser;
    private ModelRepository modelRepository;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper,
                        UserRepository userRepository, CurrentUser currentUser, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    public void addOffer(AddOfferDTO addOfferDTO){
        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity seller = userRepository.findByEmail(currentUser.getEmail()).orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }
}
