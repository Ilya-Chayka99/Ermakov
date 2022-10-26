package src.House;

public class House {
    private final int floor;

    public House(int floor) throws Exception {
        if(floor<=0) throw new Exception("Клличество этажей не может быть отрицательным или равнятся 0");
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Дом с "+floor+" этаж"+ ((floor%10==1&&floor!=11)?"ом":"ами");
    }
}
