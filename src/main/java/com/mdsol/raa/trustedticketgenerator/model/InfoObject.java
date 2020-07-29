package com.mdsol.raa.trustedticketgenerator.model;
/**
 * @author Amol Patil apatil@mdsol.com
 */
public class InfoObject {
    private String userName;
    private String site;
    private String serverUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public String toString() {
        return "InfoObject{" +
                "userName='" + userName + '\'' +
                ", site='" + site + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                '}';
    }
}
