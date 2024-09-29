package package1.domain.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import package1.domain.DTO.ClientDTO;
import package1.domain.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

//    @GetMapping
//    public List<ClientDTO> getAllClients() {
//        return clientService.g
//    }
}
