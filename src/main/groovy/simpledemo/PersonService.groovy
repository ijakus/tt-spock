package simpledemo

interface PersonService {

  Person createPerson(String name, Integer age, String city)

  void savePerson(Person person)

  void extraMethod()
}
