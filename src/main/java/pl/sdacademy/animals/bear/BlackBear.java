package pl.sdacademy.animals.bear;

import javafx.scene.input.DataFormat;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pl.sdacademy.animals.time.Clock;

public class BlackBear extends Bear {


    public BlackBear(int weight) {
        super(weight);
    }

    public BlackBear(int weight, Clock clock) {
        super(weight, clock);
    }


    @Override
    public boolean isHibernating(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/YYYY");
        String year = String.valueOf(clock.getCurrentTime().getYear());
        String HibernatingBeginingString  = "20/11/"+year;
        String HibernatingEndString = "15/03/"+year;

        DateTime HibernatingBegining = formatter.parseDateTime(HibernatingBeginingString);
        DateTime HibernatingEnd = formatter.parseDateTime(HibernatingEndString);
        if(clock.getCurrentTime().isBefore(HibernatingBegining) &&
                clock.getCurrentTime().isAfter(HibernatingEnd)){
            return false;
        }
        return true;
    }

    @Override
    public void eat(int food) {
        if(!(isHibernating())){
            super.eat(food);
        }
        else{
            throw new BearHibernatingException();
        }

    }

    @Override
    public void drink(double water) {
        if(!(isHibernating())){
            super.drink(water);
        }
        else{
            throw new BearHibernatingException();
        }

    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }
}