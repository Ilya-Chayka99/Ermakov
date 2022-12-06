package src.City;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
     List<Way> ways =new ArrayList<>();

    public City(String name) {
        this.name = name;
    }


    public City(String name,List<Way> way) throws Exception {
        for(Way w:way)
        {
            this.add(w);
        }
        this.name = name;
    }

    public void addWay(City city, int price) throws Exception {
        Way way = new Way(city,price);
        this.addWay(way);
    }
    public void addWay(Way way) throws Exception {
      this.add(way);
    }
    private void add(Way way) throws Exception {
        for(Way s:ways){
            if(s.getLastCity().equal(way.getLastCity())) {
                s.setPrice(way.getPrice());
                return;
            }

        }
       ways.add(way);

    }
    public void removeWay(City city){
        for(int i =0;i< ways.size();i++){
            if(ways.get(i).getLastCity().equals(city)) {
                ways.remove(i);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }


    public boolean equal(City o) {
        if (this.name.equals(o.name)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ways);
    }

    @Override
    public String toString() {
        return "City:" + "" + name + ", ways=" + ways;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || !(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(ways, city.ways);
    }
}
