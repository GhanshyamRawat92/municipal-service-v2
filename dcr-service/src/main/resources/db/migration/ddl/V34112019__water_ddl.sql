DROP TABLE IF EXISTS dcr_application;
CREATE TABLE dcr_application
(
  id character varying(64) NOT NULL,
  tenantid character varying(250) NOT NULL,
  property_id character varying(64) NOT NULL,
  applicationno character varying(64),
  applicationType character varying(256),
  applicantName character varying(64) NOT NULL,
  dxfFile character varying(256) NOT NULL,
  serviceType character varying(64),
  CONSTRAINT connection_pkey PRIMARY KEY (id)
);




