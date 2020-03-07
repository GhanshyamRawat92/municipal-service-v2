package org.egov.dcr.repository;

import org.egov.dcr.util.Producer;
import org.egov.dcr.web.models.Dcr;
import org.egov.dcr.web.models.DcrRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DcrRepository {
	
	@Autowired
	private Producer producer;
	
	public void create(DcrRequest dcrRequest) {
		producer.push("", dcrRequest);
	}
	
	public void update(DcrRequest dcrRequest) {
		
	}
	
	public Dcr search() {
		return null;
	}

}
