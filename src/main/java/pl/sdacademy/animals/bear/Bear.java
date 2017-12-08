package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.Clock;
import pl.sdacademy.animals.time.JodaClock;


public abstract class Bear implements Animal {

    private int weight;
    private DateTime lastMealTime;
    protected Clock clock;

    public Bear(int weight, Clock clock) {
        this(weight);
        this.clock = clock;
    }

    public Bear(int weight) {
        this.weight = weight;
        this.clock = new JodaClock();
        this.lastMealTime = clock.getCurrentTime();
    }


    @Override
    public boolean isAlive() {
        return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));
    }

    public abstract boolean isHibernating();

    public void eat(int food) {
        weight = weight + food;
        lastMealTime = clock.getCurrentTime();
    }

    public void drink(double water) {
        weight = (int) (weight + (water * 0.75));
    }

    public void pop(){
        weight = (int) (weight * 0.95);
    }


    @Override
    public int getWeight() {
        return weight;
    }

}
