package dio.aula_spring_data_jpa.repository;

import dio.aula_spring_data_jpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<Usuario, Integer> {

    // Query Method
    List<Usuario> findByNameContaining(String name);

    // Query Method
    Usuario findByUsername(String name);

    // Query Override
    @Query("SELECT u FROM Usuario u WHERE u.name LIKE %:name%")
    List<Usuario> filtrarPorNome(@Param("name") String name);
}
