package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.BrandDTO;
import bg.softuni.mobile.model.dto.ModelDTO;
import bg.softuni.mobile.model.entity.BrandEntity;
import bg.softuni.mobile.model.entity.ModelEntity;
import bg.softuni.mobile.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(this::mapBrand).collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity entity) {

        List<ModelDTO> models = entity.getModels().stream().map(this::mapModel).collect(Collectors.toList());

        return new BrandDTO().setModels(models).setName(entity.getName());

    }

    private ModelDTO mapModel(ModelEntity entity) {
        return new ModelDTO().setId(entity.getId()).setName(entity.getName());
    }
}
