package com.oguztasgin.MovieAppJava5.service;

import com.oguztasgin.MovieAppJava5.dto.request.UserLoginRequestDto;
import com.oguztasgin.MovieAppJava5.dto.request.UserRegisterRequestDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserFindAllResponseDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserLoginResponseDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserRegisterResponseDto;
import com.oguztasgin.MovieAppJava5.mapper.IUserMapper;
import com.oguztasgin.MovieAppJava5.repository.IUserRepository;
import com.oguztasgin.MovieAppJava5.repository.entity.User;
import com.oguztasgin.MovieAppJava5.repository.entity.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(String name, String surname, String email, String phone, String password, String userType) {
        UserType userType1=null;
        User user;
        try {
            userType1=UserType.valueOf(userType);
            user= User.builder()
                    .name(name)
                    .surName(surname)
                    .email(email)
                    .phone(phone)
                    .userType(userType1)
                    .password(password)
                    .build();
        }catch (Exception e){
            System.out.println("Boyle bir Kullanıcı turu bulunmamaktadır");
            user= User.builder()
                    .name(name)
                    .surName(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .build();
        }


        return  userRepository.save(user);

    }



    public List<UserFindAllResponseDto> findAll() {

        return userRepository.findAll().stream().map(x->{
            return UserFindAllResponseDto.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .surName(x.getSurName())
                    .userType(x.getUserType())
                    .phone(x.getPhone())
                    .email(x.getEmail())
                    .favMovies(x.getFavMovies())
                    .genres(x.getFavGenres())
                    .movieCommentsContent(x.getComments().stream()
                            .map(y->y.getContent()).collect(Collectors.toList()))
                    .commentMap(x.getComments().stream()
                            .collect(Collectors.toMap(z->z.getMovie().getName(),t->t.getContent())))
                    .build();
        }).collect(Collectors.toList());
    }

    public void saveAll(List<User> users) {

        userRepository.saveAll(users);


    }

    public  List<User> findAllByOrderByName(){

        return userRepository.findAllByOrderByName();
    }

    public List<User> findAllByNameLike(String name){

        return userRepository.findAllByNameLike(name);
    }

    public List<User> findAllByEmailContainingIgnoreCase(String value){
        return  userRepository.findAllByEmailContainingIgnoreCase(value);
    }

    public List<User> findAllByEmailEndingWith(String value){

        return userRepository.findAllByEmailEndingWith(value);
    }

    public Boolean existsByEmailAndPassword(String email,String password){

        return userRepository.existsByEmailAndPassword(email,password);
    }

    public User findOptionalByEmailAndPassword(String email, String password) throws Exception {

        Optional<User> user=userRepository.findOptionalByEmailAndPassword(email,password);

        if (user.isPresent()){
            return user.get();
        }else{
            throw new Exception("Kullanici Bulunamadi");
        }

    }

    public   List<User> passwordLongerThan(int length){

        return userRepository.passwordLongerThan(length);
    }

    public     List<User> passwordControl( int length){

        return  userRepository.passwordControl(length);
    }

    public Optional<User> findById(Long id) {

        Optional<User> user= userRepository.findById(id);

        System.out.println(user.get().getName());
        return user;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto dto) {
        User user= User.builder()
                .name(dto.getName())
                .surName(dto.getSurName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        userRepository.save(user);

        return UserRegisterResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surName(user.getSurName())
                .userType(user.getUserType())
                .email(user.getEmail())
                .build();
    }

    public UserRegisterResponseDto register2(UserRegisterRequestDto dto) {
        User user= IUserMapper.INSTANCE.toUser(dto);
        userRepository.save(user);
        return IUserMapper.INSTANCE.toUserRegisterResponseDto(user);
    }

    public UserLoginResponseDto login(UserLoginRequestDto dto) {

        Optional<User> user=userRepository
                .findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());

        if(user.isPresent()){
            return IUserMapper.INSTANCE.toUserLoginResponseDto(user.get());
        }
        else{
            throw new RuntimeException("Kullanici adi ve sifre hatali");
        }
    }
}