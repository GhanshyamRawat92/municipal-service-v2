package org.egov.dcr.web.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.egov.dcr.service.DcrService;
import org.egov.dcr.web.models.Dcr;
import org.egov.dcr.web.models.DcrRequest;
import org.egov.dcr.web.models.DcrResponse;
import org.egov.dcr.web.models.DcrResponse.DcrResponseBuilder;
import org.egov.dcr.web.models.RequestInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dcr")
public class DcrController {
	
	
	private DcrService dcrService;

	@Autowired
	public DcrController(DcrService dcrService) {
		this.dcrService = dcrService;
	}
	@RequestMapping(value = "/_create", method = RequestMethod.POST)
	public ResponseEntity<DcrResponse> create(@RequestBody @Valid DcrRequest dcrRequest){
		
		Dcr dcr =  dcrService.create(dcrRequest);
		DcrResponse dcrResponse = DcrResponse.builder().dcrs(Collections.singleton(dcr)).build();
		return new ResponseEntity<>(dcrResponse, HttpStatus.CREATED);
	}
	
	/*@RequestMapping(value = "/_update", method = RequestMethod.POST)
	public ResponseEntity<DcrResponse> update(@RequestBody @Valid RequestInfoWrapper requestInfoWrapper){
		DcrResponse dcrResponse = new DcrResponse();
		//dcrResponse.setDcrs(Collections.singletonList(new Dcr()));
		return new ResponseEntity<>(dcrResponse, HttpStatus.CREATED);
	}*/
	
	@RequestMapping(value = "/_search", method = RequestMethod.POST)
	public ResponseEntity<DcrResponse> search(@RequestBody @Valid RequestInfoWrapper requestInfoWrapper){
		DcrResponse dcrResponse = new DcrResponse();
		//dcrResponse.setDcrs(Collections.singletonList(new Dcr()));
		return new ResponseEntity<>(dcrResponse, HttpStatus.CREATED);
	}
}
