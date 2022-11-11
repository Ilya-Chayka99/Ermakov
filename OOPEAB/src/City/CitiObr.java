package src.City;

import java.util.List;

public class CitiObr extends City{
    public CitiObr(String name) {
        super(name);
    }

    public CitiObr(String name, List<Way> way) throws Exception {
        super(name, way);
    }

    @Override
    public void add(Way way) throws Exception {
        super.add(way);
        way.getLastCity().add(new Way(this,way.getPrice()));
    }
}
