package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import pl.sdacademy.animals.bear.time.TestClock
import pl.sdacademy.animals.time.Clock
import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        int weight = 3
        int food = 1
        def clock = new TestClock()
        clock.changeTime(200)
        Bear bear = new BlackBear(weight,clock)
        bear.eat(food)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {
        given:
        int weight = 3
        int food = 1
        def clock = new TestClock()
        clock.changeTime(200)
        Bear bear = new BlackBear(weight, clock)
        bear.eat(food)
        clock.changeTime(11)

        when:
        boolean result = bear.isAlive()

        then:
        !result
    }


    def "After eating weight should increase for weight of food "(){
        given:
        int weight  = 0
        def clock = new TestClock()
        clock.changeTime(200)
        Bear testBear = new BlackBear(weight,clock)
        int food = 10

        when:
        testBear.eat(food)

        then:
        testBear.getWeight()== weight + food
    }
    def "After drinking water weight should increas for 3/4 weight of water"(){
        given:
        int weight  = 0
        def clock = new TestClock()
        clock.changeTime(200)
        Bear testBear = new BlackBear(weight,clock)
        int drink = 10

        int weightAfter = (int) weight + (drink * 0.75)

        when:
        testBear.drink(drink)

        then:
        testBear.getWeight() == weightAfter
    }

    def "After pop() weight decrease for 5%"(){
        given:
        int weight  = 10
        Bear testBear = new BlackBear(weight)
        int weightAfter = (int)(weight * 0.95)

        when:
        testBear.pop()

        then:
        testBear.getWeight() == weightAfter
    }

    def "BlackBear should be in hebernate from 20 November to 15 March"(){
        given:
        int weight = 10
        Bear testBeat = new BlackBear(weight)

        when:
        boolean result = testBeat.isHibernating()

        then:
        result
    }

    def "PolarkBear should be in hebernate from 20 November to 15 March"(){
        given:
        int weight = 10
        Bear testBeat = new PolarBear(weight)

        when:
        boolean result = testBeat.isHibernating()

        then:
        result
    }

    def "Bear Should Be Resurected If It Has Eaten When He Was Ded"(){
        given:
        def clock = new TestClock()
        clock.changeTime(200)
        Bear testBear = new BlackBear(3,clock)

        when:
        clock.changeTime(11)
        testBear.eat(1)

        then:
        testBear.isAlive()
    }

}
