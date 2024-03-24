package org.j2os.entity;

import lombok.*;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {


    private long personID;
    private String name;
    private String family;
    private String nationalCode;
}
