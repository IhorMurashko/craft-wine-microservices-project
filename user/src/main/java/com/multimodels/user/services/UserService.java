package com.multimodels.user.services;

import com.multimodels.user.dto.UserDto;
import com.multimodels.user.dto.UserMapper;
import com.multimodels.user.exceptions.UserNotFoundException;
import com.multimodels.user.model.User;
import com.multimodels.user.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserDto findById(@Min(value = 1,
            message = "user id cant be less than one") Long id) {

        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException
                        ("user with id " + id + " not found")
                ));


    }


    public UserDto findByEmail(@NotBlank(message = "user email cant be blank") String email) {
        return userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException
                        ("user with email " + email + " not found")
                ));
    }


    public List<UserDto> findAll() {
        return userMapper.toDtos(userRepository.findAll());
    }

    public void deleteById(@Min(value = 1, message = "user id cant be less than one") Long id) {
        userRepository.deleteById(id);
    }

    public void deleteByEmail(@NotBlank(message = "user email cant be blank") String email) {
        userRepository.deleteByEmail(email);
    }


    public UserDto save(@Valid UserDto userDto) {

        if (userDto != null && userDto.email() != null) {
            User saved = userRepository.save(userMapper.toEntity(userDto));

            return userMapper.toDto(saved);
        } else {
            throw new IllegalArgumentException("user is not present");
        }


    }

}
