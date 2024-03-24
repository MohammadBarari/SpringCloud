package org.example.Service;

import lombok.AllArgsConstructor;
import org.example.Entity.Document;
import org.example.Repository.IDocumentDA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentService {
    private IDocumentDA documentDA;
    @Transactional
    public Document save(Document document){
        documentDA.save(document);
        return document;
    }
    public Document findByHouseID(Document document){
        return documentDA.findByHouseID(document.getHouseID());
    }
    public Document findByPersonID(Document document){
        return documentDA.findByPersonID(document.getPersonID());
    }
    public Document findByDocumentID(Document document){
        return documentDA.findByDocumnetID(document.getDocumnetID());
    }
    public List<Document> findAll(){
        return documentDA.findAll();
    }


}
