package com.example.erp_app.dto;

import com.example.erp_app.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    private UserDtoMapper(){};

    public static UserDto mapToUserDto (User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNum(user.getPhoneNum())
                .pesel(user.getPesel())
                .dOB(user.getDOB())
//                .role(user.getRole())
                .specialization(user.getSpecialization().getName())
                .build();
    }

    public static List<UserDto> mapToUserDtos(List<User> users){
        return users.stream()
                .map( UserDtoMapper::mapToUserDto)
                .collect(Collectors.toList());
    }
}
