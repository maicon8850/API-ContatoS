package Controlador;
//O Controller é a classe responsável por expor cada URI que estará disponível na API.
// O código inicial está listado abaixo:

import Entidade.Contact;
import Repositorio.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/contacts"}) // indicando q
public class Controller {

    private ContactRepository repository;

    Controller (ContactRepository contactRepository ){
        this.repository = contactRepository;
    }
    // metodo do CRUD
    //Listando todos os contatos (GET /contacts)
    @GetMapping
    public List findALL(){
        return repository.findAll(); // metodo para retornar uma lissta de entidades
    }
    //Obtendo um contato especídifo pelo ID (GET /contacts/{id})
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)  //findById é da interfase JPA
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    //Criando um novo contato (POST /contacts)
    // código para criar um novo contato está listado
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return repository.save(contact);

        //{
        //   "name": "Java",
        //   "email": "java@email.com",
        //   "phone": "(111) 111-1111"
        //}
    }
    //Atualizando um contato (PUT /contacts)
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Contact contact) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    //Removendo um contato pelo ID (DELETE /contacts/{id})
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}