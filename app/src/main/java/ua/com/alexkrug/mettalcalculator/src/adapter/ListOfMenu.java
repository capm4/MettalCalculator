package ua.com.alexkrug.mettalcalculator.src.adapter;


public class ListOfMenu {
    String [] mainListEn = {"Unequal Angels","Equilateral angele", "Rebar","Wire rod","Bead","Channel","Cold rolled steel","Hot rolled steel", "Square profile tube ", "Rectangular profile tube", "Round tube", "Square bars","Steel circle","Steel strip","Hexahedron" };
    String [] mainListRu = {"Неравнополочные Уголки","Равнополочные Уголки","Арматура", "Проволка","Двутавр","Швеллер","Холоднокатаный лист","Гарячекатаный лист","Труба профильна","Труба профильна прямокутна","Труба круглая","Квадрат","Круг","Полоса","Шестигранник"};
    String[] calculator_listRu ={"Уголки", "Круги", "Двутавр", "Швеллер","Листы", "Труба","Труба круглая", "Квадрат", "Полоса","Шестигранник"};
    String[] calculator_listEn = {"Angels","Steel circle", "Bead", "Channels", "Rolled steel", "Profile tube", "Round tube", "Square bars","Steel strip","Hexahedron"};

    public String[] getMainListEn() {
        return mainListEn;
    }

    public String[] getMainListRu() {
        return mainListRu;
    }

    public String[] getCalculator_listRu() {
        return calculator_listRu;
    }

    public String[] getCalculator_listEn() {
        return calculator_listEn;
    }
}
