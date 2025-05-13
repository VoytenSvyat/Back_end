package de.ait.userapi.service;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;



    @Override
    public List<UserResponseDto> getAllUser() {
       return repository.findAll()
                .stream()
                .map(UserServiceImpl::toResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = repository.findById(id);
        if (user!=null){
            return toResponseDto(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public UserResponseDto addUser(UserRequestDto dto) {
        User user = new User(null, dto.getName(), dto.getEmail(), dto.getPassword());
        User savedUser = repository.save(user);
        if (savedUser!=null){
            return toResponseDto(savedUser);
        } else {
            throw new RuntimeException("Error create new user");
        }
    }

    private static UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }
}
