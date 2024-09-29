package package1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import package1.domain.DTO.ClientDTO;
import package1.domain.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired

    private ClientRepository clientRepository;

//    public ClientDTO getClientById(int id) {
//        return new ClientDTO(clientRepository.findById(id)).get;
//    }
}
