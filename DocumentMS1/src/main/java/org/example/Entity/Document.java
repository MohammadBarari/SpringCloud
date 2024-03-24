package org.example.Entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "document")
@Table(name = "document")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long documnetID;
    @Column(columnDefinition = "NUMBER")
    private long personID;
    @Column(columnDefinition = "NUMBER")
    private long houseID;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String creationDate;
    @Column(columnDefinition = "NUMBER")
    private long price;

    public long getPrice() {
        return price;
    }

    public Document setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getDocumnetID() {
        return documnetID;
    }

    public Document setDocumnetID(long documnetID) {
        this.documnetID = documnetID;
        return this;
    }

    public long getPersonID() {
        return personID;
    }

    public Document setPersonID(long personID) {
        this.personID = personID;
        return this;
    }

    public long getHouseID() {
        return houseID;
    }

    public Document setHouseID(long houseID) {
        this.houseID = houseID;
        return this;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Document setCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
