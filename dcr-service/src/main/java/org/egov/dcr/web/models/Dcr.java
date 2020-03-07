package org.egov.dcr.web.models;

import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dcr {
	
	private String id;
	
	@NotNull
	private String tenantId;
	
	private String applicationNo;
	
	private String applicantName;
	
	@NotNull
	private String applicationType;
	
	@NotNull
	private String dxfFile;
	
	@NotNull
	private String serviceType;
	
	private Map<String,Object> additionalDetails;

}
