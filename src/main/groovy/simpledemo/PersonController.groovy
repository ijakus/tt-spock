package simpledemo

class PersonController {

  PersonService personService

  Person createPerson(String name, Integer age, String city) {
    Person person = personService.createPerson(name, age, city)

    personService.savePerson(person)

    personService.extraMethod()
 }
}
