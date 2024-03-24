package org.example.Entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Type;

@Entity(name = "house")
@Table(name = "house")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long houseID;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String city;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String address;
    @Column(columnDefinition = "NUMBER")
    private String unitNumber;
}






















