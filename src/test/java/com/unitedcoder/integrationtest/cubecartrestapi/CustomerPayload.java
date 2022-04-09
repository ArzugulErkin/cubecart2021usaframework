package com.unitedcoder.integrationtest.cubecartrestapi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPayload {
    @JsonProperty("email")
    private String email;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("status")
    private int status;
    @JsonProperty("language")
    private String language;
    @JsonProperty("ipAddress")
    private String ipAddress;

    public CustomerPayload(String email, String title, String firstName, String lastName, String country, String phone, int status, String language, String ipAddress) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.phone = phone;
        this.status = status;
        this.language = language;
        this.ipAddress = ipAddress;
    }
}
