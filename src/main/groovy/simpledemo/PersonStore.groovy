package simpledemo

class PersonStore {

  final List<Person> personList = []

  void insert(Person person) {
    personList << person
  }

  List<Person> list() {
    personList
  }

  List<Person> findByCity(String city) {
    personList.findAll { it.city == city }
  }

  List<Person> findByCityFaulty(String city) {
    personList
  }
}
