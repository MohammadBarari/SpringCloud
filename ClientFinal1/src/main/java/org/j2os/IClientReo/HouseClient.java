package org.j2os.IClientReo;

import org.j2os.entity.House;
import org.j2os.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("house-service")
public interface HouseClient {
    @GetMapping("/house/save")
    Person save(@RequestParam("city") String city,@RequestParam("address") String address,
                @RequestParam("unitNumber") long unitNumber);
    @GetMapping("/house/findByHouseID")
    House findById(@RequestParam("houseID") long houseID);
    @GetMapping("/house/findAll")
    List<House>findAllHouses();
}
