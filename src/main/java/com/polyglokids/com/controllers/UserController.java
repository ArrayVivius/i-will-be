package com.polyglokids.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polyglokids.com.domain.entities.UserEntity;
import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.CreateUserUseCase;
import com.polyglokids.com.usecases.SignInUseCase;

@RestController
public class UserController {

  private final CreateUserUseCase createUserUseCase;

  private final SignInUseCase signInUseCase;

  @Autowired
  public UserController(CreateUserUseCase createUserUseCase, SignInUseCase signInUseCase) {
    this.createUserUseCase = createUserUseCase;
    this.signInUseCase = signInUseCase;
  }

  @PostMapping("user")
  public UserModel createUser(@RequestBody UserDTO bod) {
    UserModel user = createUserUseCase.save(bod);
    return user;
  }

  // @GetMapping("user")
  // public UserDetails getUser(@PathVariable String correo) {
  // UserDetails user = signInUseCase.singIn(correo);
  // return user; }
}
