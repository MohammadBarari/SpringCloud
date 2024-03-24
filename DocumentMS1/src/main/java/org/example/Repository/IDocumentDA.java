package org.example.Repository;

import org.example.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentDA extends JpaRepository<Document,Long> {
     Document findByDocumnetID(long documentID);
     Document findByHouseID(long houseID);
     Document findByPersonID(long personID);
}
