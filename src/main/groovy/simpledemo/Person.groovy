package simpledemo

class Person {
  String name
  Integer age
  String city

  Person(String name = "", Integer age = 0, String city = "") {
    this.name = name
    this.age = age
    this.city = city
  }

  Boolean isAdult() {
    age >= 18
  }
}
