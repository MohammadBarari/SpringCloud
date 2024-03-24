package org.example.Repository;

import org.example.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IPersonDA extends JpaRepository<Person,Long>{
    Person findByNationalCode(String National);
    Person findByPersonID(long personID);
}
