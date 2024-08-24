package package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import package1.domain.entity.ClientEntity;
import package1.domain.repository.ClientRepository;

import java.util.List;


@SpringBootApplication

public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
        return args -> {
            ClientEntity clientEntity1 = new ClientEntity();
            clientEntity1.setName("asd");
            clientRepository.save(clientEntity1);

            ClientEntity clientEntity2 = new ClientEntity();
            clientEntity2.setName("asdsa");
            clientRepository.save(clientEntity2);

            List<ClientEntity> clients = clientRepository.findAll();
            clients.forEach(System.out::println);

        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
