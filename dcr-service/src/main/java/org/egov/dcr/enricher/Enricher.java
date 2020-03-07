package org.egov.dcr.enricher;

import org.egov.dcr.config.DcrConfiguration;
import org.egov.dcr.repository.IdGenRepository;
import org.egov.dcr.web.models.DcrRequest;
import org.egov.tl.web.models.Idgen.IdGenerationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Enricher {
	
	private IdGenRepository idGenRepository;
	
	private DcrConfiguration dcrConfiguration;
	
	@Autowired
	public Enricher(IdGenRepository idGenRepository, DcrConfiguration dcrConfiguration) {
		this.idGenRepository = idGenRepository;
		this.dcrConfiguration = dcrConfiguration;
	}
	
	public void enrich(DcrRequest dcrRequest) {
		//setDcrId(dcrRequest);
	}
	
	private void setDcrId(DcrRequest dcrRequest) {
		IdGenerationResponse idGenerationResponse = idGenRepository.getId(dcrRequest.getRequestInfo(), dcrRequest.getDcr().getTenantId(), 
				dcrConfiguration.getApplicationNumberIdgenName(), dcrConfiguration.getApplicationNumberIdgenFormat(), 1);
		dcrRequest.getDcr().setId(idGenerationResponse.getIdResponses().get(0).getId());
	}
	


}
