package org.j2os.ClientController;

import lombok.AllArgsConstructor;
import org.j2os.Exeptions.NoUserFound;
import org.j2os.Exeptions.UserOrHouseNotFound;
import org.j2os.IClientReo.DocumentClient;
import org.j2os.IClientReo.HouseClient;
import org.j2os.IClientReo.PersonClient;
import org.j2os.entity.Document;
import org.j2os.entity.House;
import org.j2os.entity.Person;
import org.j2os.entity.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReadServiceControllerDocumentContrller {


@Autowired
	private final DocumentClient documentClient;
@Autowired
	private final HouseClient houseClient;
@Autowired
	private final PersonClient personClient;
	@GetMapping("/registerDocument")
	public ResponseEntity<Document> save(@RequestParam("personID")long personID,
										 @RequestParam("houseID")long houseID,
										 @RequestParam("creationDate")String creationDate,
										 @RequestParam("price")long price) throws Exception {
		Document document = new Document();
		document.setPersonID(personID);
		document.setHouseID(houseID);
		document.setCreationDate(creationDate);
		document.setPrice(price);
		if (validate(document)){
		documentClient.save(document.getPersonID(),
				document.getHouseID(),
				document.getCreationDate(),
				 calculateTheTax(document.getPrice()));
			return ResponseEntity.ok(document);
		}
		else {
			throw new UserOrHouseNotFound();
		}
	}
	@GetMapping("/findPersonInfoByNationalCode")
	public ResponseEntity<PersonInfo>findPerson(@RequestParam("nationalCode") String nationalCode)throws NoUserFound{
		try {
			Person person = personClient.findByNationalCode(nationalCode);
			PersonInfo personInfo = new PersonInfo();
			List<House> houses = new ArrayList<>();
			List<Document> documents = documentClient.findAllDocuments();
			for (Document d : documents) {
				if (d.getPersonID() == person.getPersonID()) {
					houses.add(houseClient.findById(d.getHouseID()));
				}
			}
			personInfo.setHouseList(houses);
			personInfo.setName(person.getName());
			personInfo.setFamily(person.getFamily());
			personInfo.setNationalCode(nationalCode);
			return ResponseEntity.ok(personInfo);
		}
			catch (Exception e){
					e.getMessage();
			}
		return null;
	}
	private long calculateTheTax(long price){
		return ((95 *price)/100);
	}
	private boolean validate(Document document){
		List<Person>personList = personClient.findAllPeople();
		List<House>houses = houseClient.findAllHouses();
		Person person = personClient.findById(document.getPersonID());
		House house = houseClient.findById(document.getHouseID());
		if (person != null && house != null){
			List<Document>documents = documentClient.findAllDocuments();
			for (Document d:documents){
				if (document.getHouseID() == d.getHouseID() ){
					return false;
				}
			}
			return true;
		}
		else return false;
	}
}
