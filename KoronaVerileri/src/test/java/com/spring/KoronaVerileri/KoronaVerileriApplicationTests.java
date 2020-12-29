package com.spring.KoronaVerileri;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.spring.KoronaVerileri.Controller.CaseController;
import com.spring.KoronaVerileri.Model.CaseModel;

@SpringBootTest
class KoronaVerileriApplicationTests {
	
	//RETRIEVE RECORDS
	@Test
	void testAlLRecords() {
		CaseController controller = new CaseController();
        ResponseEntity result;
		try {
			result = controller.getAllCases();
			System.out.println(result.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testSingleRecordCity() {
		CaseController controller = new CaseController();
        ResponseEntity result;
		try {
			result = controller.getCaseCities("Ankara");
			System.out.println(result.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testSingleRecordDate() {
		CaseController controller = new CaseController();
        ResponseEntity result;
		try {
			result = controller.getCaseDates("12-12-2012");
			System.out.println(result.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testAlLRecordsCity() {
		CaseController controller = new CaseController();
        ResponseEntity result;
		try {
			result = controller.getAllCasesByCity();
			System.out.println(result.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testAlLRecordsDate() {
		CaseController controller = new CaseController();
        ResponseEntity result;
		try {
			result = controller.getAllCasesByDate();
			System.out.println(result.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testRecordSeriousCases() {
		CaseController controller = new CaseController();
  
		try {
			List<CaseModel> caselist= controller.getAllCases().getBody();	        
	        List<CaseModel> seriousCases = new ArrayList<>();
	        
			for (CaseModel model : caselist) {
				if(model.getVaka()>=15) {
					seriousCases.add(model);
				}
			}
						
			System.out.println(seriousCases);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testRecordVitalCases() {
		CaseController controller = new CaseController();
  
		try {
			List<CaseModel> caselist= controller.getAllCases().getBody();	        
	        List<CaseModel> seriousCases = new ArrayList<>();
	        
			for (CaseModel model : caselist) {
				if(model.getVefat()>=model.getTaburcu()) {
					seriousCases.add(model);
				}
			}
						
			System.out.println(seriousCases);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}
	
	@Test
	void testRecordOldCases() {
		CaseController controller = new CaseController();
  
		try {
			List<CaseModel> caselist= controller.getAllCases().getBody();	        
	        List<CaseModel> oldcases = new ArrayList<>();
	        
			for (CaseModel model : caselist) {
				int year=Integer.parseInt(model.getTarih().split("-")[2]);
				if(year<2015) {
					oldcases.add(model);
				}
			}
						
			System.out.println(oldcases);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
	}

}
