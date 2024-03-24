package org.example.api;

import lombok.AllArgsConstructor;
import org.example.Entity.Person;
import org.example.Service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class Controller {
    private PersonService personService;
    @GetMapping("/save")
    public Person save(@ModelAttribute Person person){
        return personService.save(person);
    }
    @GetMapping("/findByNationalCode")
    public Person findByNationalCode(@ModelAttribute Person person){
        return personService.findBYNationalCode(person);
    }
    @GetMapping("/findByPersonID")
    public Person findBYPersonID(@ModelAttribute Person person){
        return personService.findByPersonID(person);
    }
    @GetMapping("/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }
}
