package org.egov.drc.controller;

import org.egov.dcr.web.models.DcrRequest;
import org.egov.dcr.web.models.DcrResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dcr")
public class DcrController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${egov.idgen.host}")
    private String idGenHost;

    @Value("${egov.idgen.path}")
    private String idGenPath;
	
	@PostMapping("/_create")
	public ResponseEntity<DcrResponse> consumeDcr(@RequestBody DcrRequest dcrRequest){
		System.out.println("consumeDcr:"+dcrRequest);
		ResponseEntity<DcrResponse> dcrResponseEntity = restTemplate.postForEntity(idGenHost.concat(idGenPath), dcrRequest, DcrResponse.class);
		DcrResponse dcrResponse = dcrResponseEntity.getBody();
		log.info("dcrResponse:"+ dcrResponse);
		return new ResponseEntity<>(dcrResponse, HttpStatus.CREATED);
	}
}
