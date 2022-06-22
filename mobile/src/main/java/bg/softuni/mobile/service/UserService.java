package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.UserLoginDTO;
import bg.softuni.mobile.model.dto.UserRegisterDTO;
import bg.softuni.mobile.model.entity.UserEntity;
import bg.softuni.mobile.model.mapper.UserMapper;
import bg.softuni.mobile.repository.UserRepository;
import bg.softuni.mobile.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder encoder;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser,
                       PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(encoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);
        login(newUser);
    }

    public boolean login(UserLoginDTO loginDTO) {
        //Find user by username (in that case email)
        Optional<UserEntity> userOpt = userRepository.findByEmail(loginDTO.getUsername());

        //If there is no such user, print message and return false
        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found!", loginDTO.getUsername());
            return false;
        }

        //Checks if the password is the same or not
        var rawPassword = loginDTO.getPassword();
        var encodedPassword = userOpt.get().getPassword();

        boolean success = encoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true).setName(userEntity.getFirstName() + " " + userEntity.getLastName())
                .setEmail(userEntity.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }
}
