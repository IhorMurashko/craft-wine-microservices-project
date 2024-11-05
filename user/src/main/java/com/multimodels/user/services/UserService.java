package com.multimodels.user.services;

import com.multimodels.user.dto.UserDto;
import com.multimodels.user.dto.UserMapper;
import com.multimodels.user.model.User;
import com.multimodels.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        ("user with id " + id + " not found")
                ));


    }

    public UserDto findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException
                        ("user with email " + email + " not found")
                ));
    }


    public List<UserDto> findAll() {
        return userMapper.toDtos(userRepository.findAll());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }


    public UserDto save(UserDto userDto) {

        if (userDto != null && userDto.email() != null) {
            User saved = userRepository.save(userMapper.toEntity(userDto));

            return userMapper.toDto(saved);
        } else {
            throw new IllegalArgumentException("user is not present");
        }


    }

}
