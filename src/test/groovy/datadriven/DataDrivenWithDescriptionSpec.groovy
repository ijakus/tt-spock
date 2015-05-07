package datadriven

import simpledemo.Person
import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenWithDescriptionSpec extends Specification {

  @Unroll("#person.name (#person.age) is #helper.toLowerCase()")
  def "Can check if person is adult or minor"() {
    expect:
    person.isAdult() == adult

    where:
    person                  || adult
    new Person('Ivica', 18) || true
    new Person('Marko', 23) || true

    helper = adult ? 'Adult' : 'Minor'
  }
}

