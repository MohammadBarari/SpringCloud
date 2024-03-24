package org.j2os.ClientController;

import lombok.AllArgsConstructor;
import org.j2os.Exeptions.WrongNationalCode;
import org.j2os.IClientReo.PersonClient;
import org.j2os.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReadServiceControllerPersonContrller {
	private final PersonClient personClient;

	@GetMapping("/registerPerson")
	public ResponseEntity<Person> save(@ModelAttribute Person person) throws Exception {
		List<Person>allPeople = personClient.findAllPeople();
		if ( person.getNationalCode() != null)
		{
			if(ifPersonCanBeInserted(allPeople,person)){
			personClient.save(person.getName(),person.getFamily(),person.getNationalCode());
			return ResponseEntity.ok(person);
			}
			else {
				throw new WrongNationalCode();
			}
		}
		else {
			throw new WrongNationalCode();
		}

	}
	private boolean ifPersonCanBeInserted(List<Person> personList,Person person){
		for (Person p:personList){
			if (Long.parseLong(person.getNationalCode()) == Long.parseLong(p.getNationalCode())){
				return false;
			}
		}
		return true;
	}
}
