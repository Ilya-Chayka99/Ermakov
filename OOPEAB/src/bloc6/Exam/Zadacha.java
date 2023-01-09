package src.bloc6.Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zadacha {
    private Status status = Status.PRINITO;
    private String nameNaz;
    private String nameIsp;
    private String zadacha;
    private Codeable codeAuto= ()-> {return "Поднял базу данных";};
    private List<Zadacha> zadachas = new ArrayList<>();

    public Zadacha(String nameNaz,  String nameIsp, String zadacha) {
      this(nameNaz,nameIsp,zadacha,null);
    }
    public Zadacha(String nameNaz,  String nameIsp, String zadacha , Zadacha... zadachas) {
        this.nameNaz = nameNaz;
        this.nameIsp = nameIsp;
        this.zadacha = zadacha;
        if(zadachas!=null)
            for(Zadacha z:zadachas){
                if(z!=null)
                    this.zadachas.add(z);
            }
    }

    public void setCodeAuto(Codeable codeAuto) {
        this.codeAuto = codeAuto;
    }

    public Status getStatus() {
        return status;
    }

    public String getNameNaz() {
        return nameNaz;
    }

    public String getNameIsp() {
        return nameIsp;
    }

    public void complited() {
            if(!nameIsp.equals("SYSTEM")) {
                System.out.println("Сотрудник: " + nameIsp + ", выполняет задачу: " + zadacha);
            }else{
                System.out.println("Система отработала задачу в автоматическом режиме!");
                System.out.println(codeAuto.coding());
            }
                if (zadachas != null && zadachas.size() > 0) {
                    int com = 0;
                    for (Zadacha s : zadachas) {
                        s.complited();
                        if (s.getStatus() == Status.COMPLIT) com++;
                    }
                    if (com == zadachas.size()) this.status = Status.COMPLIT;
                } else
                    this.status = Status.COMPLIT;

        }
}
