package dio.aula_spring_data_jpa;

import dio.aula_spring_data_jpa.model.Usuario;
import dio.aula_spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {

    // Injeção de Dependencias (@Autowired)
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        // Criando um novo usuario
        Usuario usuario = new Usuario();

        // Definindo as caracteristicas do usuario
        usuario.setName("Felipe");
        usuario.setUsername("Fig");
        usuario.setPassword("xyzabc12345");

        // Salvar as alterações
        repository.save(usuario);

        // Confirmando se o usuario criado foi salvo corretamente
        for(Usuario u : repository.findAll()){
            System.out.println(u);
        }
    }
}
