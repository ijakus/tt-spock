package person

import simpledemo.Person
import spock.lang.Specification

class HelperMethodSpec extends Specification {

  def "Can validate feature in helper method"() {
    given:
    def person = new Person("Ivica", 18)

    expect:
    isPersonIvica(person)
  }

  void isPersonIvica(def person) {
    assert person.name == "Ivica"
    assert person.age == 18
  }
}

