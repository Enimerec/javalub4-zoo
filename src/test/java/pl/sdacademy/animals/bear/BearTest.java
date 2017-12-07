package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {
    @Test
    void eat() {
        //given
        int food = 10;
        int weight = 0;
        Bear bearTest = new BlackBear(weight);

        int weightAfter = (int) (weight + food);

        //when
        bearTest.eat(food);

        //then
        assertEquals(bearTest.getWeight(),weight + weightAfter);
    }

    @Test
    void drink() {
        //given
        int water = 10;
        int weight = 0;
        Bear bearTest = new BlackBear(weight);
        int weightAfter = (int) (weight + (water * 0.75));

        //when
        bearTest.drink(water);

        //then
        assertEquals(bearTest.getWeight(),weightAfter);
    }

    @Test
    void pop() {
        //given
        int weight = 10;
        Bear bearTest = new BlackBear(weight);
        int weightAfter = (int) (weight * 0.95);

        //when
        bearTest.pop();

        //then

        assertEquals(bearTest.getWeight(),weightAfter);
    }

}