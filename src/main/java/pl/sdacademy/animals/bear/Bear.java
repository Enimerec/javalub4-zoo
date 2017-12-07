package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Animal;

import java.time.Clock;
import java.time.LocalDate;


public abstract class Bear implements Animal {

    private int weight;
    private boolean isAlive;
    private LocalDate feedTime;
    private Clock clock = Clock.systemDefaultZone();

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
        this.feedTime = LocalDate.now();
    }

    public Bear(int weight, Clock clock) {
        this.weight = weight;
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        if(LocalDate.now(clock).isBefore(getFeedTime().plusDays(10))){
            return true;
        }
        return false;
    }

    public void eat(int amount) {
        weight = weight + amount;
        feedTime = LocalDate.now();

    }
    public void drink(double waterWeight){
        weight = (int) (weight + (waterWeight * 0.75));
    }

    public void pop(){
        weight = (int) (weight * 0.95);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    private LocalDate getFeedTime() {
        return feedTime;
    }
}
