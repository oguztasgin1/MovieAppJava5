package com.oguztasgin.MovieAppJava5.mapper;

import com.oguztasgin.MovieAppJava5.dto.request.UserRegisterRequestDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserLoginResponseDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserRegisterResponseDto;
import com.oguztasgin.MovieAppJava5.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);


    User  toUser(final UserRegisterRequestDto dto);

    UserRegisterResponseDto toUserRegisterResponseDto(final User user);

    UserLoginResponseDto toUserLoginResponseDto(final User user);
}
