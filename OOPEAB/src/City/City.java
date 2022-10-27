package src.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private List<Way> ways =new ArrayList<>();

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
            if(s.getLastCity()==way.getLastCity())  s=way;
            return;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name) && ways.equals(city.ways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ways);
    }

    @Override
    public String toString() {
        return "City:" + "" + name + ", ways=" + ways;
    }
}
