package src.City;

import java.util.List;
import java.util.Objects;

public class CitiObr extends City{
    public CitiObr(String name) {
        super(name);
    }

    public CitiObr(String name, List<Way> way) throws Exception {
        super(name, way);
    }

    @Override
    public void addWay(Way way) throws Exception {
        super.addWay(way);
        for (Way w:way.getLastCity().ways) {
            if(this.equal(w.getLastCity()))
            {
                w.setPrice(way.getPrice());
                return;
            }
        }
        way.getLastCity().addWay(new Way(this,way.getPrice()));
    }



}
