package pl.sdacademy.animals.bear

import spock.lang.Specification

class BearSpec extends Specification {

    def "After eating weight should increase for weight of food "(){

        given:
        Bear testBead = new BlackBear(0)

        when:
        testBead.eat(10)

        then:
        testBead.getWeight()==10
    }

    def "After drinking water weight should increas for 3/4 weight of water"(){
        given:
        Bear testBear = new BlackBear(0)

        when:
        testBear.drink(10.00)

        then:
        testBear.getWeight() == 7
    }

    def "After pop() weight decrease for 5%"(){
        given:
        Bear testBear = new BlackBear(10)

        when:
        testBear.pop();

        then:g
        testBear.getWeight() == 10 * 0.5
    }




}
