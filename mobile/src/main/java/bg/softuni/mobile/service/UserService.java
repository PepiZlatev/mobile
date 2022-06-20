package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.UserLoginDTO;
import bg.softuni.mobile.model.entity.UserEntity;
import bg.softuni.mobile.repository.UserRepository;
import bg.softuni.mobile.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDTO userLoginDTO){
        //Find user by username (in that case email)
        Optional<UserEntity> userOpt = userRepository.findByEmail(userLoginDTO.getUsername());

        //If there is no such user, print message and return false
        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found!", userLoginDTO.getUsername());
            return false;
        }

        //Checks if the password is the same or not
        boolean success = userOpt.get().getPassword().equals(userLoginDTO.getPassword());

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }
    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true).setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
