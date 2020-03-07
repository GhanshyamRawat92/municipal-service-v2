package org.egov.dcr.web.models;

import java.util.HashSet;
import java.util.Set;

import org.egov.common.contract.response.ResponseInfo;

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
public class DcrResponse {
	
	
	private ResponseInfo responseInfo;
	
	private Set<Dcr> dcrs =  new HashSet<>();

}
