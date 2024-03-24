package org.j2os.entity;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House {


    private long houseID;

    private String city;

    private String address;

    private long unitNumber;
}