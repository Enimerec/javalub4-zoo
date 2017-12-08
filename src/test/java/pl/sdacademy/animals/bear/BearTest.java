package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Test;
import pl.sdacademy.animals.bear.time.TestClock;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {
    @Test
    public void BeerShouldThrowExceptionIfEatUsedDuringHibernation(){
        //given
        Bear bear = new PolarBear(3);

        //when
        //then
        assertThrows(BearHibernatingException.class,
                ()-> bear.eat(1));
    }
    @Test
    public void PolarkBearShouldBeInHebernateFrom20NovemberTo15March(){
        //given
        Bear bear = new PolarBear(3);

        //when
        boolean result = bear.isHibernating();

        //then
        assertTrue(result);
    }

    @Test
    public void BlackBearShouldBeInHebernateFrom20NovemberTo15March(){
        //given
        Bear bear = new BlackBear(3);

        //when
        boolean result = bear.isHibernating();

        //then
        assertTrue(result);
    }
    @Test
    public void BearShouldBeAliveImmediatelyAfterCreation(){
        //given
        Bear bear = new BlackBear(3);
        //when
        //then
        assertTrue(bear.isAlive());
    }

    @Test
    public void BearShouldBeResurectedIfItHasEatenWhenHeWasDed(){
        //given
        TestClock clock = new TestClock();
        clock.changeTime(200);
        Bear bear = new BlackBear(3,clock);

        //when
        clock.changeTime(11);
        bear.eat(1);

        //then
        assertTrue(bear.isAlive());
    }

    @Test
    public void BearShouldBeAliveIfItHasEatenWithin10Days(){
        //given
        TestClock clock = new TestClock();
        clock.changeTime(200);
        Bear bear = new BlackBear(3,clock);

        //when
        bear.eat(1);

        //then
        assertTrue(bear.isAlive());
    }

    @Test
    public void BearShouldNotBeAliveIfItHasEatenWithinMoreThan10Days(){
        //given
        TestClock clock = new TestClock();
        clock.changeTime(200);
        Bear bear = new BlackBear(3,clock);

        //when
        bear.eat(1);
        clock.changeTime(11);

        //then
        assertFalse(bear.isAlive());

    }


    @Test
    void eat() {
        //given
        int food = 10;
        int weight = 0;
        TestClock clock = new TestClock();
        clock.changeTime(200);
        Bear bearTest = new BlackBear(weight,clock);
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
        TestClock clock = new TestClock();
        clock.changeTime(200);
        Bear bearTest = new BlackBear(weight,clock);
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