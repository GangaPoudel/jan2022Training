package com.example.customer.services;

import com.example.customer.models.Desk;
import com.example.customer.repositories.DeskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskService {
    @Autowired
    private DeskRepo deskRepo;

    //insert
    public Desk addDesk(Desk desk){return this.deskRepo.save(desk);}

    //find by Id
    public Desk getDeskById(String deskId){
        return this.deskRepo.findById(deskId).orElse(null);
    }

    //update
    public Desk updateDesk(String deskId, Desk desk){
        Desk deskObj = this.getDeskById(deskId);
        if (deskObj!=null){

        }
        return this.deskRepo.save(desk);
    }

    //list all
    public List<Desk> getAllDesks(){return this.deskRepo.findAll();}

}
