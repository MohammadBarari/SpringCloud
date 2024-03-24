package org.j2os.IClientReo;

import org.j2os.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("person-service")
public interface PersonClient {

    @GetMapping("/person/save")
    Person save(@RequestParam("name") String name,@RequestParam("family") String family,
                @RequestParam("nationalCode") String nationalCode);
    @GetMapping("person/findAll")
    List<Person>findAllPeople();
    @GetMapping("/person/findByPersonID")
    Person findById(@RequestParam("personID") long personID);

    @GetMapping("/person/findByNationalCode")
    Person findByNationalCode(@RequestParam("nationalCode") String nationalCode);
}
