package org.example.Service;

import lombok.AllArgsConstructor;
import org.example.Entity.House;
import org.example.Repository.IHouseDA;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HouseService {
    private IHouseDA houseDA;
    public House Save(House house){
        return houseDA.save(house);
    }
    public List<House> selectAll(){
        return houseDA.findAll();
    }
    public House findByHouseID(House house) {
        return houseDA.findByHouseID(house.getHouseID());
    }
    public List<House>findAll(){
        return houseDA.findAll();
    }
}
