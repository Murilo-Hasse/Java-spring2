package package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import package1.domain.entity.ClientEntity;
import package1.domain.repository.ClientRepository;

import java.util.List;


@SpringBootApplication
@EntityScan(basePackageClasses = ClientEntity.class)
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
            ClientEntity clientEntity3 = clientRepository.findById(clientEntity2.getId());
            System.out.println(clientEntity3);
            clients.forEach(System.out::println);

            clientEntity1.setName(clientEntity1.getName() + "Atualizado");
            System.out.println("teste");
            clientRepository.update(clientEntity1);

            clients = clientRepository.findAll();
            clients.forEach(System.out::println);
//            clientRepository.delete(clientEntity1);
//            clientRepository.delete(clientEntity2);

        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
