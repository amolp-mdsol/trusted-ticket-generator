package com.mdsol.raa.trustedticketgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrustedTicketGeneratorApplication {

    public static void main(String[] args) {
    	SpringApplication.run(TrustedTicketGeneratorApplication.class, args);

        /**
         * Get trusted ticket
         */
       /* logger.info("getting ticker for user: {}, with site:{} and serverHost:{}", userPropObj.getUserName(),
                globalSiteName, bcm.getProperty("server.host"));
        String trustedToken = s_restApiUtils.getTrustedTicketBySkipingSsl(bcm.getProperty("tableauTrustedTickerServer"),
                userPropObj.getUserName(), globalSiteName);

        logger.info("Trusted ticket{} for user {}", trustedToken, userPropObj.getUserName());

        if (trustedToken.equalsIgnoreCase("-1")) {
            throw new BOAException("Token is not generated for user:"+userPropObj.getUserName());
        }*/

    }

}
