package com.nikomu_exercise1;

// Перечисления Speciality представляющие специальности
public enum Speciality {
    DEVELOPER("Разработчик", "Developer"),
    TESTER("Тестировщик", "Tester"),
    DESIGNER("Дизайне", "Designer");

    // Статическое поле (свойство), представляющее название специальности на русском языке
    private final String specialityNameRu;
    // Статическое поле (свойство), представляющее название специальности на английском языке
    private final String specialityNameUS;

    // Конструктор с параметрами
    Speciality(String specialityNameRu, String specialityNameUS) {
        this.specialityNameRu = specialityNameRu;
        this.specialityNameUS = specialityNameUS;
    }

    // Метод для получения специальности на русском языке
    public String getSpecialityNameRu() {
        return specialityNameRu;
    }

    // Метод для получения специальности на английском языке
    public String getSpecialityNameUS() {
        return specialityNameUS;
    }

    public static Speciality getSpecialityItem(String spec) {
        Speciality tempSpeciality = null;

        for (int i = 0; i < Speciality.values().length; i++) {
            if(Speciality.values()[i].getSpecialityNameUS().contains(spec)) {
                tempSpeciality = Speciality.values()[i];
            }
        }

        return tempSpeciality;
    }


    // Переопределенный метод toString()
    @Override
    public String toString() {
        return this.specialityNameUS;
    }
}
