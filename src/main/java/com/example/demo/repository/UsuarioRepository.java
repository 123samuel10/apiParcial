package com.example.demo.repository;

//JpaRepository es una interfaz de Spring Data que proporciona métodos
// para operaciones comunes de bases de datos, como guardar, eliminar y buscar entidades.
// Al extender JpaRepository, la interfaz UsuarioRepository hereda esos métodos sin necesidad de implementarlos manualmente.

import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//En resumen, UsuarioRepository es un repositorio de Spring Data JPA que
// facilita el acceso a los datos de la entidad Usuario, simplificando
// las operaciones de CRUD (crear, leer, actualizar y eliminar) en la base de datos.
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}