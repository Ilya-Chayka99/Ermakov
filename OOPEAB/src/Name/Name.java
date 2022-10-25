package src.Name;

public class Name {
    private final String name,surname,patronymic;

    public Name(String name, String patronymic, String surname) throws Exception {
        if(name==null||name=="")
            if(patronymic==null||patronymic=="")
                if(surname==null||surname=="") throw new Exception("Нужно указать минимум 1 поле не null и не пустой строкой");

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Name(String name, String surname) throws Exception {

        this(name,surname,"");
    }

    public Name(String name) throws Exception {

        this(name,"","");
    }
    public Name() throws Exception {
        this(null,null,null);
    }

    public String getPatronymic() {

        return this.patronymic;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        if(this.surname=="") return this.name;
        if (this.patronymic=="") return this.name +" "+ this.surname;
        return this.name +" "+ this.patronymic+" "+this.surname;
    }
}
