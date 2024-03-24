package org.example.api;

import lombok.AllArgsConstructor;
import org.example.Entity.Document;
import org.example.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/document")
public class Controller {
    @Autowired
    private DocumentService documentService;
    @GetMapping("/save")
    public Document save(@ModelAttribute Document document){
        return documentService.save(document);
    }
    @GetMapping("/findByPersonID")
    public Document findByPersonID(@ModelAttribute Document document){
        return documentService.findByDocumentID(document);
    }
    @GetMapping("/findByHouseID")
    public Document findByHouseID(@ModelAttribute Document document){
        return documentService.findByHouseID(document);
    }
    @GetMapping("/findByDocumentID")
    public Document findByDocumnetID(@ModelAttribute Document document){
        return documentService.findByDocumentID(document);
    }
    @GetMapping("/findAll")
    public List<Document>all(){
        return documentService.findAll();
    }


}
