package com.sample;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleMock {
    private String mocking = "Hello" ;
   static Logger logger = LoggerFactory.getLogger("SampleMock");
    public String getMocking() {
        logger.info("Entering mock function");
        logger.info(this.mocking);
        System.out.println(mocking);
        logger.info("Exiting mock function");
        return this.mocking;
    }
    public String mock2(){
        logger.info("Entering mock2 function");
        logger.info(getMocking());
        logger.info("Exiting mock2 function");
        return getMocking();
    }
    static ArtifactService artifactService ;

    public static String  getArtifactConfiguration(String id,String artifactName, String artifactClass, String tenantOrg){
        logger.error("JsonNode getArtifactConfiguration ===> {},{},{},{}",id,artifactName,artifactClass,tenantOrg);
        ArtifactInfo artifactInfo = artifactService.getArtifactInfo(id, artifactName, artifactClass, tenantOrg);
        logger.error("artifactInfo.getConfig ===>", artifactInfo);
        return artifactInfo.getConfig();
    }
    public static String getInquiries(String id, String artifactName, String artifactClass, String tenantOrg, String inquiryType) {
        logger.error("JsonNode getInquiries ====> {},{},{},{},{}",id,artifactName,artifactClass,tenantOrg,inquiryType);
        return getArtifactConfiguration(id, artifactName, artifactClass, tenantOrg);
    }
}
