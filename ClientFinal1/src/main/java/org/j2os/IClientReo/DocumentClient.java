package org.j2os.IClientReo;

import org.j2os.entity.Document;
import org.j2os.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("document-service")
public interface DocumentClient {
    @GetMapping("/document/save")
    Document save(@RequestParam("personID") long personID,

                @RequestParam("houseID") long houseID,

                @RequestParam("creationDate") String creationDate,

                @RequestParam("price") long price);



    @GetMapping("/document/findBYDocumentID")
    Person findByID(@RequestParam("documentID") long documentID);

    @GetMapping("/document/findBYPersonID")
    Person findBYPersonID(@RequestParam("personID") long personID);

    @GetMapping("/document/findBYHouseID")
    Person findBYHouseID(@RequestParam("housID") long houseID);
    @GetMapping("document/findAll")
    List<Document>findAllDocuments();
}
