package org.egov.drc.controller;

import org.egov.dcr.web.models.DcrRequest;
import org.egov.dcr.web.models.DcrResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
		ResponseEntity<DcrResponse> dcrResponse = restTemplate.postForEntity(idGenHost.concat(idGenPath), dcrRequest, DcrResponse.class);
		return dcrResponse;
	}
}
