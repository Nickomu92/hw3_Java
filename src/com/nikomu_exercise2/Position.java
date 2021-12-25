package com.nikomu_exercise2;

public enum Position {
    DIRECTOR("Директор", "Director"),
    ACCOUNTANT("Бухгалтер", "Accountant"),
    HR("HR", "HR"),
    MARKETER("Маркетолог", "Marketer"),
    DEVELOPER("Программист", "Developer"),
    QA("QA", "QA"),
    TESTER("Тестировщик", "Tester");

    private String positionNameRu;
    private String positionNameUS;

    Position(String positionNameRu, String positionNameUS) {
        this.positionNameRu = positionNameRu;
        this.positionNameUS = positionNameUS;
    }

    public String getPositionNameRu() {
        return positionNameRu;
    }

    public String getPositionNameUS() {
        return positionNameUS;
    }

    @Override
    public String toString() {
        return "Positions {" +
                "positionNameRu = '" + positionNameRu + '\'' +
                '}';
    }
}
