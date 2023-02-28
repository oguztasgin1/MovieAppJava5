package com.oguztasgin.MovieAppJava5.controller;

import com.oguztasgin.MovieAppJava5.dto.request.UserLoginRequestDto;
import com.oguztasgin.MovieAppJava5.dto.request.UserRegisterRequestDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserFindAllResponseDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserLoginResponseDto;
import com.oguztasgin.MovieAppJava5.dto.response.UserRegisterResponseDto;
import com.oguztasgin.MovieAppJava5.repository.entity.User;
import com.oguztasgin.MovieAppJava5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping("/register")
    public  ResponseEntity<UserRegisterResponseDto> register(UserRegisterRequestDto dto){
        return  ResponseEntity.ok(userService.register(dto));
    }

    @GetMapping("/register2")
    public  ResponseEntity<UserRegisterResponseDto> register2(UserRegisterRequestDto dto){
        return  ResponseEntity.ok(userService.register2(dto));
    }

    @GetMapping("/findbyid")
    public ResponseEntity<User> findById(Long id){

        return ResponseEntity.ok(userService.findById(id).get());
    }


    @GetMapping("/create")
    public User createUser(String name,String surname,String email,String phone,String password,String userType){
        return   userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findall")
    public List<UserFindAllResponseDto> findAll(){

        return userService.findAll();
    }

    @GetMapping("/orderbyname")
    public ResponseEntity< List<User>> findAllByOrderByName(){

        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/findbynamewithlike")
    public ResponseEntity< List<User>> findAllByNameLike(String name){

        return ResponseEntity.ok(userService.findAllByNameLike("%"+name+"%"));
    }
    @GetMapping("/containsemail")
    public ResponseEntity< List<User>> findAllByEmailContainingIgnoreCase(String value){
        return  ResponseEntity.ok(userService.findAllByEmailContainingIgnoreCase(value));
    }
    @GetMapping("/findbyemailendingwith")
    public ResponseEntity< List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }
    @GetMapping("/login")
    public ResponseEntity<Boolean> existsByEmailAndPassword(String email,String password){

        return ResponseEntity.ok(userService.existsByEmailAndPassword(email,password));
    }

    @GetMapping("/login2")

    public ResponseEntity<?> login(String email,String password){
        //? Ne donecegimi bilmiyorum demek.

        try {
            return ResponseEntity.ok(userService.findOptionalByEmailAndPassword(email,password));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/login3")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto dto){
        return ResponseEntity.ok(userService.login(dto));
    }

    @GetMapping("/passwordcontrol")
    public  ResponseEntity< List<User>> passwordLongerThan(int length){
        return ResponseEntity.ok(userService.passwordLongerThan(length));
    }
    @GetMapping("/passwordcontrol2")
    public  ResponseEntity< List<User>> passwordControl(int length){
        return ResponseEntity.ok(userService.passwordControl(length));
    }
}