package org.egov.dcr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class DcrConfiguration {

	//Idgen Config
    @Value("${egov.idgen.host}")
    private String idGenHost;

    @Value("${egov.idgen.path}")
    private String idGenPath;

    @Value("${egov.idgen.dcr.applicationNum.name}")
    private String applicationNumberIdgenName;

    @Value("${egov.idgen.dcr.applicationNum.format}")
    private String applicationNumberIdgenFormat;
}
