package org.egov.dcr.repository;

import java.util.ArrayList;
import java.util.List;

import org.egov.dcr.util.Producer;
import org.egov.dcr.web.models.Dcr;
import org.egov.dcr.web.models.DcrRequest;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class DcrRepository {

	@Autowired
	private Producer producer;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(DcrRequest dcrRequest) {
		// producer.push("", dcrRequest);
		log.info("DcrRepository:"+ dcrRequest);
		try {
			insert(dcrRequest.getDcr());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CustomException("DB_ERROR","Failed to persist the data");
		}
	}

	public void update(DcrRequest dcrRequest) {

	}

	public Dcr search() {
		return null;
	}

	private void insert(Dcr dcr) {
		String query = "insert into dcr_application " + "(id, tenantid, property_id,applicationno,applicationtype,"
				+ "applicantname,dxffile,servicetype) " + "values (?,?,?,?,?,?,?,?)";
		List<Object[]> rows = new ArrayList<>();
		List<Object> row = new ArrayList<>();
		row.add(dcr.getId());
		row.add(dcr.getTenantId());
		row.add("property Id");
		row.add(dcr.getApplicationNo());
		row.add(dcr.getApplicationType());
		row.add(dcr.getApplicantName());
		row.add(dcr.getDxfFile());
		row.add(dcr.getServiceType());
		rows.add(row.toArray());
		jdbcTemplate.batchUpdate(query, rows);
	}
}
