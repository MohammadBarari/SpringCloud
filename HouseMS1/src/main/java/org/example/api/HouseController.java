package org.example.api;

import lombok.AllArgsConstructor;
import org.example.Entity.House;
import org.example.Service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/house")
public class HouseController {
    private HouseService houseService;
    @GetMapping("/save")
    public House save(@ModelAttribute House house){
       return houseService.Save(house);
    }
    @GetMapping("/findByHouseID")
    public House findByHouseID(@ModelAttribute House house){
        return houseService.findByHouseID(house);
    }
    @GetMapping("/findAll")
    public List<House> findAll(){
        return houseService.findAll();
    }
}
