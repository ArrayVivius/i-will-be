
package com.polyglokids.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.polyglokids.com.DTOs.auth.AuthRes;
import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.CreateUserUseCase;
import com.polyglokids.com.usecases.SignInUseCase;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final CreateUserUseCase createUserUseCase;

  private final SignInUseCase signInUseCase;

  @Autowired
  public AuthController(CreateUserUseCase createUserUseCase, SignInUseCase signInUseCase) {
    this.createUserUseCase = createUserUseCase;
    this.signInUseCase = signInUseCase;
  }

  @PostMapping("/signUp")
  public UserModel createUser(@RequestBody UserDTO bod) {
    UserModel user = createUserUseCase.save(bod);
    return user;
  }

  @GetMapping("/signIn")
  public AuthRes getUser(@RequestParam String correo, @RequestParam String contraseña) {
    System.out.println("hello");
    AuthRes user = signInUseCase.singIn(correo, contraseña);
    System.out.println("sdasdasd" + user);
    return user;
  }
}
