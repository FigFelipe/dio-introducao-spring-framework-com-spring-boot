package dio.aula_spring_data_jpa;

import dio.aula_spring_data_jpa.model.User;
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
        User user = new User();

        // Definindo as caracteristicas do usuario
        user.setNome("Felipe");
        user.setUsername("FigFelipe");
        user.setPassword("dio12345");

        // Salvar as alterações
        repository.save(user);

        // Confirmando se o usuario criado foi salvo corretamente
        for(User u : repository.findAll()){
            System.out.println(u);
        }
    }
}
