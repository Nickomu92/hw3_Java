package com.nikomu_exercise2;

public enum Department {
    IT("IT отдел", "IT department"),
    HR("HR отдел", "HR department"),
    ACCOUNTING("Бухгалтерский отдел", "Accounting department"),
    MANAGING("Отдел управления", "Managing department");

    private String departmentNameRu;
    private String departmentNameUS;

    Department(String departmentNameRu, String departmentNameUS) {
        this.departmentNameRu = departmentNameRu;
        this.departmentNameUS = departmentNameUS;
    }

    public String getDepartmentNameRu() {
        return departmentNameRu;
    }

    public String getDepartmentNameUS() {
        return departmentNameUS;
    }

    @Override
    public String toString() {
        return "Department {" +
                "departmentNameRu = '" + departmentNameRu + '\'' +
                '}';
    }
}
