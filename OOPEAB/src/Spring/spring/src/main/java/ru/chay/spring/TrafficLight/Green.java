package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.chay.spring.Cahe;
import ru.chay.spring.Default;
import ru.chay.spring.ToStringg;

//@ToStringg
@Qualifier("green")
@Component
//@Default("defaultConf")
@Cahe
public class Green implements Color{

    private Color yellowB;
//    @Default("123")
    public String z="1";
    public int count=0;

    @Autowired
    public void setYellowB(Color yellowB) {
        this.yellowB = yellowB;
    }
    public String zzzz(){
//        count++;
//        if(count%3==0) z="3";
        return z+z;
    }
    @Override
    public Color next() {
        return yellowB;
    }
    @Override
    public String toString() {
        return zzzz();
    }
}
