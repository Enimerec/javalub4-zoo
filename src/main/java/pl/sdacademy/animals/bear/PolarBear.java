package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class PolarBear extends Bear {
    public PolarBear(int weight) {
        super(weight);
    }

    @Override
    public boolean isHibernating() {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/YYYY");
            String year = String.valueOf(DateTime.now().getYear());
            String HibernatingBeginingString  = "05/05/"+year;
            String HibernatingEndString = "10/10/"+year;

            DateTime HibernatingBegining = formatter.parseDateTime(HibernatingBeginingString);
            DateTime HibernatingEnd = formatter.parseDateTime(HibernatingEndString);
            if(DateTime.now().isBefore(HibernatingBegining) &&
                    DateTime.now().isAfter(HibernatingEnd)){
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
}

