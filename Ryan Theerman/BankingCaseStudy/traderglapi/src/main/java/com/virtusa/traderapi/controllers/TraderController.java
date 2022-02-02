package com.virtusa.traderapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.traderapi.models.Trader;

import com.virtusa.traderapi.services.TraderService;

@RestController
@RequestMapping("/traders")
@RefreshScope
@Slf4j
public class TraderController {
    @Autowired
    private TraderService traderService;

    @Value(("${newmessage}"))
    private String message;

    //post
    @PostMapping(value="/{bankId}",params = "version=1.0")
    public ResponseEntity<?> addTrader(@PathVariable("bankId") long bankId,@RequestBody Trader trader){
        Trader traderObj=this.traderService.addTrader(bankId,trader);
        if(traderObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(traderObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Trader Not Created");

    }

    //get
    @GetMapping(value="/",params = "version=1.0")
    public List<Trader> getAllTraders(){
        log.info("Message: " + message);
        return this.traderService.getAllTraders();
    }


    //put
    @PutMapping(value="/{bankId}",params = "version=1.0")
    public List<Trader> updateTraderWithFKNull(@PathVariable("bankId") long bankId){

        return this.traderService.updateBank(bankId);


    }

    //get
    @GetMapping(value="/filters/{traderId}",params = "version=1.0")
    public ResponseEntity<?> getTraderByFields(@PathVariable("traderId") long traderId,
                                               @RequestParam(name = "fields", required = false) String fields){

        Map<Object,Object> model=new HashMap<>();

        Trader trader = this.traderService.getTraderById(traderId);

        if(trader!=null)
        {
            //fields refers to runtime selection
            ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);
            return ResponseEntity.ok(SquigglyUtils.stringify(mapper, trader));

        }
        else
        {
            model.put("message", "trader not existing");

            return ResponseEntity.ok(model);
        }
    }

    //put
	@PutMapping(value="/{traderId}/{email}",params = "version=1.0")
	public ResponseEntity<?> updateTrader(@PathVariable("traderId") long traderId, @PathVariable("email") String email){
		Trader traderObj=this.traderService.updateTrader(traderId, email);
		if(traderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Trader email updated to " + email);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Trader Not Created");

	}

    //delete
    @DeleteMapping(value="/{traderId}",params = "version=1.0")
    public ResponseEntity<?> deleteTraderById(@PathVariable("traderId") long traderId){

        if(this.traderService.deleteTraderById(traderId))
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Trader with "+traderId+" deleted");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Trader Not Found");

    }


}