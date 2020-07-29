package com.mdsol.raa.trustedticketgenerator.controller;

import com.mdsol.raa.trustedticketgenerator.model.InfoObject;
import com.mdsol.raa.trustedticketgenerator.service.TicketGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author Amol Patil apatil@mdsol.com
 */
@RestController()
@RequestMapping("/trusted-token")
public class TableauTicketGenerator {

    @Autowired
    TicketGeneratorService ticketGeneratorService;

    @RequestMapping(method = RequestMethod.GET, produces =  {"application/json"})
    public String getTrustedToken(@RequestParam(name = "userName" ) String userName,
                                  @RequestParam(name = "site") String targetSite,
                                  @RequestParam(name = "serverUrl") String serverUrl) throws Exception {
        return ticketGeneratorService.getTrustedTicket(serverUrl,
                userName,targetSite);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"},
            produces = {"application/json"})
    public String getTrustedTicket(@RequestBody InfoObject infoObject) throws Exception {
        System.out.println("Request: "+ infoObject.toString());
        return ticketGeneratorService.getTrustedTicket(infoObject.getServerUrl(),
                infoObject.getUserName(),infoObject.getSite());
    }

}
