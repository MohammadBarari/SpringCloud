package org.example.Service;

import lombok.AllArgsConstructor;
import org.example.Entity.Person;
import org.example.Repository.IPersonDA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private IPersonDA personDA;
    @Transactional
    public Person save(Person person){
        personDA.save(person);
        return person;
    }
    public List<Person> findAll(){
        return personDA.findAll();
    }
    public Person findBYNationalCode(Person person){
        return personDA.findByNationalCode(person.getNationalCode());
    }
    public Person findByPersonID(Person person){
        return personDA.findByPersonID(person.getPersonID());
    }
}
