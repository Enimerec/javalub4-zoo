package pl.sdacademy.animals.bear

import org.mockito.Mock
import spock.lang.Specification
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class BearSpec extends Specification {

    def "Black Bear should be in Hebernate from 20 November to 15 March"(){
        given:
        when:
        then:
    }

    def "Bear should be alive immediatly after creation"(){
        given:
        int weight  = 3
        Bear testBear = new BlackBear(weight)

        when:
        boolean result = testBear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"(){
        given:
        int weight  = 3
        Bear testBear = new BlackBear(weight)
        testBear.eat(1)

        when:
        boolean result = testBear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has not eaten within more than 10 day"(){
        given:
        Clock  clock = Mock (Clock)
        clock >> LocalDate.now().plusDays(11)

        int weight  = 3
        Bear testBear = new BlackBear(weight,clock)
        testBear.eat(1)

        when:
        boolean result = testBear.isAlive()

        then:
        !(result)
    }

    def "After eating weight should increase for weight of food "(){
        given:
        int weight  = 0
        Bear testBear = new BlackBear(weight)
        int food = 10

        when:
        testBear.eat(food)

        then:
        testBear.getWeight()== weight + food
    }

    def "After drinking water weight should increas for 3/4 weight of water"(){
        given:
        int weight  = 0
        Bear testBear = new BlackBear(weight)
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




}
