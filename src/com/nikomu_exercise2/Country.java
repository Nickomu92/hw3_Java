package com.nikomu_exercise2;

public enum Country {
    ABKHAZIA("Абхазия", "Abkhazia", "AB", "ABH", 895),
    AUSTRALIA("Австралия", "Australia", "AU", "AUS", 036),
    AUSTRIA("Австрия", "Austria", "AT", "AUT", 040),
    AZERBAIJAN("Азербайджан", "Azerbaijan", "AZ", "AZE", 031),
    BELARUS("Беларусь", "Belarus", "BY", "BLR", 112),
    GERMANY("Германия", "Germany", "DE", "DEU", 276),
    POLAND("Польша", "Poland", "PL", "POL", 616),
    RUSSIA("Россия", "Russia", "RU", "RUS", 643),
    UKRAINE("Украина", "Ukraine", "UA", "UKR", 804),
    UNITED_KINGDOM("Соединенное Королевство", "United Kingdom", "GB", "GBR", 826),
    UNITED_STATES("Соединенные Штаты", "United States", "US", "USA", 840);

    private String countryNameRu;
    private String countryNameUS;
    private String alpha2Code;
    private String alpha3Code;
    private int IsoCode;

    Country(String countryNameRu, String countryNameUS, String alpha2Code, String alpha3Code, int isoCode) {
        this.countryNameRu = countryNameRu;
        this.countryNameUS = countryNameUS;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        IsoCode = isoCode;
    }

    public String getCountryNameRu() {
        return countryNameRu;
    }

    public String getCountryNameUS() {
        return countryNameUS;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public int getIsoCode() {
        return IsoCode;
    }

}
