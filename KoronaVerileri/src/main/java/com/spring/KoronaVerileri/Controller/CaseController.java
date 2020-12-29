package com.spring.KoronaVerileri.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.KoronaVerileri.Model.CaseModel;
import com.spring.KoronaVerileri.Repository.ICaseRepository;
import com.spring.KoronaVerileri.Service.Sorter;

@RestController
@RequestMapping("/CaseModel")
public class CaseController {
	@Autowired
	private ICaseRepository caseRepository;
  
	// http://localhost:8080/CaseModel/all
	@GetMapping("/all" )
	public ResponseEntity<List<CaseModel>> getAllCases() throws Exception {
		List<CaseModel> cases = caseRepository.findAll();
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/all/bydate" )
	public ResponseEntity<List<CaseModel>> getAllCasesByDate() throws Exception {
		List<CaseModel> cases = caseRepository.findAll();
		Sorter.sortByDate(cases,0,cases.size()-1);
		
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/all/bycity" )
	public ResponseEntity<List<CaseModel>> getAllCasesByCity() throws Exception {
		List<CaseModel> cases = caseRepository.findAll();
		Sorter.sortByCity(cases,0,cases.size()-1);
		
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
  
	// READ //
  
	// http://localhost:8080/CaseModel/get?id=<EnterUserId>
	@GetMapping("/id" )
	public ResponseEntity getCaseById(@RequestParam("id") ObjectId id) throws Exception {
		CaseModel caseModel = caseRepository.findBy_id(id);
		return new ResponseEntity<>(caseModel, HttpStatus.OK);
	}
	
	//http://localhost:8080/CaseModel/get/<EnterUserId>
	@GetMapping("/id/{id}" )
	public ResponseEntity getCaseById2(@PathVariable ObjectId id) throws Exception {
	     CaseModel caseModel = caseRepository.findBy_id(id);
	     return new ResponseEntity<>(caseModel, HttpStatus.OK);
	}
	
	//http://localhost:8080/CaseModel/tarih/<EnterDate>
	@GetMapping("/tarih/{date}" )
	public ResponseEntity getCaseDates(@PathVariable String date) throws Exception {
		 List<CaseModel> cases = caseRepository.findAll();
		 List<CaseModel> caseNames=new ArrayList<>();
		 for (CaseModel entity : cases) {
			if(entity.getTarih().equals(date)) {
				caseNames.add(entity);
			}				
		 }
		 
	     return new ResponseEntity<>(caseNames, HttpStatus.OK);
	}
	
	@GetMapping("/tarih/{date}/bycity" )
	public ResponseEntity getCaseDatesByCity(@PathVariable String date) throws Exception {
		 List<CaseModel> cases = caseRepository.findAll();
		 List<CaseModel> caseNames=new ArrayList<>();
		 for (CaseModel entity : cases) {
			if(entity.getTarih().equals(date)) {
				caseNames.add(entity);
			}				
		 }
		 
	     return new ResponseEntity<>(caseNames, HttpStatus.OK);
	}
	
	//http://localhost:8080/CaseModel/sehir/<EnterCity>
	@GetMapping("/sehir/{city}" )
	public ResponseEntity getCaseCities(@PathVariable String city) throws Exception {
		 List<CaseModel> cases = caseRepository.findAll();
		 List<CaseModel> caseNames=new ArrayList<>();
		 for (CaseModel entity : cases) {
			if(entity.getIl().equals(city)) {
				caseNames.add(entity);
			}				
		 }
		 
	     return new ResponseEntity<>(caseNames, HttpStatus.OK);
	}
	@GetMapping("/sehir/{city}/bydate" )
	public ResponseEntity getCaseCitiesByDate(@PathVariable String city) throws Exception {
		 List<CaseModel> cases = caseRepository.findAll();
		 List<CaseModel> caseNames=new ArrayList<>();
		 for (CaseModel entity : cases) {
			if(entity.getIl().equals(city)) {
				caseNames.add(entity);
			}				
		 }
		 
		 Sorter.sortByDate(caseNames, 0, caseNames.size()-1);
		 
	     return new ResponseEntity<>(caseNames, HttpStatus.OK);
	}
	
	//TODO 1
	@GetMapping("/tarih/graph" )
	public ResponseEntity<List<CaseModel>> getGraphCumulativeDate() throws Exception {
		return null;
	}
	
	//TODO 2
	@GetMapping("/sehir/graph" )
	public ResponseEntity<List<CaseModel>> getGraphCumulativeCity() throws Exception {
		return null;
	}
	
 
	// INSERT //
	@PostMapping(path="/add")
	public void add(@RequestBody CaseModel caseModel) {
		caseRepository.insert(caseModel);
	}

	// DELETE //
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteCase(@PathVariable("id") ObjectId _id) {
		try {
			caseRepository.delete(caseRepository.findBy_id(_id));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/dispose")
	public ResponseEntity<HttpStatus> deleteAll() {
		try {
			caseRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//	
	
	
}