package interaction

import org.spockframework.mock.TooFewInvocationsError
import simpledemo.Person
import simpledemo.PersonController
import simpledemo.PersonService
import org.spockframework.mock.WrongInvocationOrderError
import spock.lang.FailsWith
import spock.lang.Shared
import spock.lang.Specification

class InteractionBasedSpec extends Specification {

  PersonController personController
  PersonService personService

  @Shared personName = "Marko Marić"
  @Shared personAge = 24
  @Shared personCity = "Zagreb"
  @Shared person = new Person()

  def setup() {
    personService = Mock()
    personController = new PersonController(
      personService: personService
    )
  }

  def 'Verify mock methods called'() {
    when:
    personController.createPerson(personName, personAge, personCity)

    then:
    1 * personService.createPerson(personName, personAge, personCity) >> person
    1 * personService.savePerson(person)
//    0 * _
  }

  @FailsWith(WrongInvocationOrderError)
  def 'verify mock method call order'() {
    when:
    personController.createPerson(personName, personAge, personCity)

    then:
    1 * personService.savePerson(_)

    then:
    1 * personService.createPerson(*_) >> _
  }
}
