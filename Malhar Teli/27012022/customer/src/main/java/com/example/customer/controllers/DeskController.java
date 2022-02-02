package com.example.customer.controllers;

import com.example.customer.models.Desk;
import com.example.customer.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desks")
public class DeskController {
    @Autowired
    private DeskService deskService;

    //post
    @PostMapping(value="/", params="version=1.0")
    public ResponseEntity<?> addDesk(@RequestBody Desk desk){
        Desk deskObj = this.deskService.addDesk(desk);
        if (deskObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(deskObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Desk not added");
    }

    //Get
    @GetMapping(value = "/{deskId}", params = "version=1.0")
    public ResponseEntity<?> getDeskById(@PathVariable("deskId") String deskId){
        Desk deskObj = this.deskService.getDeskById(deskId);
        if (deskObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(deskObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not find Desk");
    }

    @GetMapping(value="/", params= "version=1.0")
    public List<Desk> getAllDesks(){
        return this.deskService.getAllDesks();
    }

    @PutMapping(value = "/{deskId}/", params = "version=1.0")
    public ResponseEntity<?> updateDesk(@PathVariable("deskId") String deskId, @RequestBody Desk desk){
        Desk deskObj = this.deskService.updateDesk(deskId, desk);
        if (deskObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(deskObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Desk not found");
    }

}
