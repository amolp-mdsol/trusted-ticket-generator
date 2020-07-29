package com.mdsol.raa.trustedticketgenerator.utils;

public class Config {
    private static Config config;
    private String userName;
    private String tableServer;
    private String siteName;

    private Config(){
        setVariables();
    }

    public String getUserName() {
        return userName;
    }

    public String getTableServer() {
        return tableServer;
    }

    public String getSiteName() {
        return siteName;
    }

    private void setVariables(){
        this.userName = System.getenv("userName");
        this.tableServer = System.getenv("tableServer");
        this.siteName = System.getenv("siteName");
    }

    public static Config getConfigInstance(){
        if (config == null){
            config = new Config();
        }
        return config;
    }

}
