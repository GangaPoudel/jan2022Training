package com.virtusa.currency.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.currency.models.Currency;
import com.virtusa.currency.services.CurrencyService;


@RestController
@RequestMapping("/currencies")
public class CurrencyController {
	@Autowired
	private CurrencyService cService;
///post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCurrency(@RequestBody Currency currency){
		Currency currencyObj=this.cService.addCurrency(currency);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Currency> getAllCurrencies(){
		return this.cService.getAllCurrency();
	}
	
	//get with id
	
	@GetMapping(value="/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> getCurrencyById(@PathVariable("currencyId") long currencyId){
		Currency currencyObj=this.cService.getCurrencyById(currencyId);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
	
	
	//put
	
	@PutMapping(value="/{currencyId}/{country}",params = "version=1.0")
	public ResponseEntity<?> updateCurrency(@PathVariable("currencyId") long currencyId,@PathVariable("country") String country){
		Currency currencyObj=this.cService.updateCurrency(currencyId, country);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{currencyId}",params = "version=1.0")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencyId") long currencyId){
	
		if(this.cService.deleteCurrencyById(currencyId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currency with "+ currencyId +" Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
	//get currency by fields
	@GetMapping(value="/fields/{currencyId}",params= "version=1.0")
	public ResponseEntity<?> getCurrencyByFields(@PathVariable("currencyId") Long currencyId, @RequestParam("feilds") String feilds){
		Map<Object, Object> model = new HashMap<>();
		Currency currency = this.cService.getCurrencyById(currencyId);
		if(currency != null) {
			ObjectMapper mapper = Squiggly.init(new ObjectMapper(), feilds);
			return ResponseEntity.ok(SquigglyUtils.stringify(mapper, currency));
		} else {
			return ResponseEntity.ok(model.put("message", "currency not found"));
		}
	}
	
}
	//somenotes to parse image- Type- MultipartFile file
	//String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
	//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
//	String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
//	log.info("uploadDirectory:: " + uploadDirectory);
//	String fileName = file.getOriginalFilename();
//	String filePath = Paths.get(uploadDirectory, fileName).toString();
//	log.info("FileName: " + file.getOriginalFilename());
//	if (fileName == null || fileName.contains("..")) {
//		model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
//		return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
//	}

//	try {
//		File dir = new File(uploadDirectory);
//		if (!dir.exists()) {
//			log.info("Folder Created");
//			dir.mkdirs();
//		}
//		// Save the file locally
//		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//		stream.write(file.getBytes());
//		stream.close();
//	} catch (Exception e) {
//		log.info("in catch");
//		e.printStackTrace();
//	}
//	byte[] imageData = file.getBytes();

//	imageGallery.setImage(imageData);

//	log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
//	return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
//} catch (Exception e) {
//	e.printStackTrace();
//	log.info("Exception: " + e);
//	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	

