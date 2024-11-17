package Controlador;
//O Controller é a classe responsável por expor cada URI que estará disponível na API.
// O código inicial está listado abaixo:

import Repositorio.ContactRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/contacts"}) // indicando q
public class Controller {

    private ContactRepository repository;

    Controller (ContactRepository contactRepository ){
        this.repository = contactRepository;
    }
    // metodo do CRUD aqu i
}
