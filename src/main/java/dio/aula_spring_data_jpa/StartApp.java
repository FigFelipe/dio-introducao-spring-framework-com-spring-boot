package dio.aula_spring_data_jpa;

import dio.aula_spring_data_jpa.model.Usuario;
import dio.aula_spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    // Injeção de Dependencias (@Autowired)
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        // Consultando objeto através do Query Override
        //List<Usuario> usuarios = repository.filtrarPorNome("Felipe");

        // Consultando objeto através do 'findByNameContaining'
        List<Usuario> usuarios = repository.findByNameContaining("Teste");

        if(!usuarios.isEmpty()){
            for(Usuario u : usuarios){
                System.out.println(u);
            }
        }

        // Consultando objeto através do 'findByUsername'
        System.out.println(repository.findByUsername("test"));

    }

    private void insertUser(){

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
