package com.polyglokids.com.domain.entities.types.user;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
  String nombre;
  String apellido;
  String correo;
  String contraseña;
  LocalDate fechaDeCreacion;
  List<String> cursos;
}
