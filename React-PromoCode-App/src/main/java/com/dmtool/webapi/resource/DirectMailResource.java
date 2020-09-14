package com.dmtool.webapi.resource;

import com.dmtool.webapi.model.DirectMail;
import com.dmtool.webapi.repository.DirectMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class DirectMailResource {

    @Autowired
    DirectMailRepository directMailRepository;

    @PostMapping("/directMail")
    public List<DirectMail> retrievePromoData(@RequestBody DirectMail directMail) {
        return directMailRepository.findByPromoCodeOrEmail(directMail.getPromoCode(), directMail.getEmail());
    }

    @PostMapping("/email")
    public List<DirectMail> retrieveEmail(@RequestBody DirectMail directMail) {
        return directMailRepository.findByEmail(directMail.getEmail());
    }

    @GetMapping("/direct/all")
    public List<DirectMail> directMail(){
        return directMailRepository.findAll();
    }
}
