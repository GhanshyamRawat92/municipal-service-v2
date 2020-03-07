package org.egov.dcr.service;

import org.egov.dcr.enricher.Enricher;
import org.egov.dcr.web.models.Dcr;
import org.egov.dcr.web.models.DcrRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DcrService {

	private Enricher enricher;
	
	@Autowired
	public DcrService(Enricher enricher) {
		this.enricher = enricher;
	}
	
	public Dcr create(DcrRequest dcrRequest) {
		enricher.enrich(dcrRequest);		
		return dcrRequest.getDcr();
		
	}
	
}
