package org.j2os.ClientController;

import lombok.AllArgsConstructor;
import org.j2os.Exeptions.WrongNationalCode;
import org.j2os.IClientReo.HouseClient;
import org.j2os.IClientReo.PersonClient;
import org.j2os.entity.House;
import org.j2os.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReadServiceControllerHouseContrller {



	private final HouseClient houseClient;


	@GetMapping("/registerHouse")
	public ResponseEntity<House> save(@ModelAttribute House house) throws WrongNationalCode {
		houseClient.save(house.getCity(),house.getAddress(),house.getUnitNumber());
		return 	ResponseEntity.ok(house);
	}
	@GetMapping("/findHosue")
	public ResponseEntity<House>find(@RequestParam("id") long id)
	{
		return ResponseEntity.ok(houseClient.findById(id));
	}

}
