package eu.wisercat.petmanagmentapi.model;

import lombok.Data;

@Data
public class PetDto {

    private String name;

    private String identificationCode;

    private String type;

    private String furColor;

    private String country;

}
