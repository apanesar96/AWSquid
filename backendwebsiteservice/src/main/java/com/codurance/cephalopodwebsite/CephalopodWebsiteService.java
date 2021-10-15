package com.codurance.cephalopodwebsite;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static java.util.Arrays.asList;

@RestController
public class CephalopodWebsiteService {

    private final Environment environment;

    public CephalopodWebsiteService(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/getSquid")
    @ResponseBody
    public String getSquidFromResources() {
        //TODO dynamic environment here
        if(asList(environment.getActiveProfiles()).contains("production")) return "http://localhost:3002/normalSquid";

        return "http://localhost:3002/seasonalSquid";
    }
}