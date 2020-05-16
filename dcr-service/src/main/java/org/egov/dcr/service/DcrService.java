package org.egov.dcr.service;

import org.egov.dcr.enricher.Enricher;
import org.egov.dcr.repository.DcrRepository;
import org.egov.dcr.web.models.Dcr;
import org.egov.dcr.web.models.DcrRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DcrService {

	private Enricher enricher;
	private DcrRepository dcrRepository;
	
	@Autowired
	public DcrService(Enricher enricher, DcrRepository dcrRepository) {
		this.enricher = enricher;
		this.dcrRepository = dcrRepository;
	}
	
	public Dcr create(DcrRequest dcrRequest) {
		enricher.enrich(dcrRequest);		
		dcrRepository.create(dcrRequest);
		return dcrRequest.getDcr();
	}
	
}
