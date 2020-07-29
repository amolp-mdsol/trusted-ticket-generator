package com.mdsol.raa.trustedticketgenerator;

import com.mdsol.raa.trustedticketgenerator.service.TicketGeneratorService;
import com.mdsol.raa.trustedticketgenerator.utils.Config;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Amol Patil apatil@mdsol.com
 */
@Disabled
@SpringBootTest
class TicketGeneratorServiceTest {
    Config config = Config.getConfigInstance();

    @Test
    public void getTrustedTicket() throws Exception {
        TicketGeneratorService ticket = new TicketGeneratorService();
        String userName = "admin";
        String tableauServer = "https://10.224.162.172";
        String siteName = "";
        System.out.println(ticket.getTrustedTicket(tableauServer,userName,siteName));
    }

    @Test
    public void testEnvVariables(){

        System.out.println("userName: "+ config.getUserName());
    }



}