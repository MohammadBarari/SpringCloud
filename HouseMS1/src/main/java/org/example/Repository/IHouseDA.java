package org.example.Repository;

import org.example.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseDA extends JpaRepository<House,Long> {
    House findByHouseID(long houseID);
}
