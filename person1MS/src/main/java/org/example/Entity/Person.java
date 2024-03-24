package org.example.Entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Type;

@Entity(name = "person2")
@Table(name = "person2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personID;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;
    @Column(columnDefinition = "VARCHAR2(10)")
    private String nationalCode;
}
