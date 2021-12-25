package com.nikomu_exercise2;

public enum Gender {

    UNKNOWN("неизвестный", "unknown"),
    MASCULINITY("мужской", "masculinity"),
    FEMININITY("женский", "femininity");

    private String genderValueRu;
    private String genderValueUS;

    Gender(String genderValueRu, String genderValueUS) {
        this.genderValueRu = genderValueRu;
        this.genderValueUS = genderValueUS;
    }

    public String getGenderValueRu() {
        return genderValueRu;
    }

    public String getGenderValueUS() {
        return genderValueUS;
    }
}
