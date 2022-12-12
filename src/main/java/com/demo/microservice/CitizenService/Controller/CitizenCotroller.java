package com.demo.microservice.CitizenService.Controller;

import com.demo.microservice.CitizenService.Entity.Citizen;
import com.demo.microservice.CitizenService.Repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenCotroller {

    @Autowired
    private CitizenRepo citizenRepo;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test() {
       return  new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
        List<Citizen> citizenList = citizenRepo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(citizenList, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        Citizen citizenSaved = citizenRepo.save(citizen);
        return new ResponseEntity<>(citizenSaved, HttpStatus.OK);
    }

}
