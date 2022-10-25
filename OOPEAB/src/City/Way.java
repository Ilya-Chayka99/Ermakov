package src.City;

public class Way {
    private City lastCity;
    private int price;

    public Way(City lastCity, int price) {
        this.lastCity = lastCity;
        this.price = price;
    }

    public City getLastCity() {
        return lastCity;
    }

    @Override
    public String toString() {
        return lastCity.getName() + ": "+price;
    }
}
