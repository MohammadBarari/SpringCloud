package org.j2os.entity;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonInfo {
    long id;
    String name;
    String family;
    String nationalCode;
    List<House> houseList;
}
