package org.j2os.entity;

import lombok.*;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {


    private long documnetID;

    private long personID;

    private long houseID;

    private String creationDate;

    private long price;

}
