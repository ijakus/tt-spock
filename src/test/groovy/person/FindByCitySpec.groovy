package person

import simpledemo.Person
import simpledemo.PersonStore
import spock.lang.Specification
import spock.lang.Subject

class FindByCitySpec extends Specification {

  @Subject
  def people = new PersonStore()

  def setup() {
    people.insert new Person("Person 1", 10, "Zagreb")
    people.insert new Person("Person 2", 10, "Rijeka")
    people.insert new Person("Person 3", 10, "Split")
    people.insert new Person("Person 4", 10, "Zagreb")
    people.insert new Person("Person 5", 10, "Split")
  }

  def "Can find person by city (v1)"() {
    when:
    def results = people.findByCity("Split")

    then:
    results.size() == 2
    results[0].city == "Split"
    results[1].city == "Split"
  }

  def "Can find person by city (v2)"() {
    when:
    def results = people.findByCityFaulty("Split")

    then:
    results.city.every {
      it == "Split"
    }
  }
}
