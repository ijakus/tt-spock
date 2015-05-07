package simpledemo

import spock.lang.Specification

class ExceptionSampleSpec extends Specification {

  def "Feature showing diff options and Set comparison"() {
    given:
    def set1 = ["aa", "bb", "cc"] as Set
    def set2 = ["aa", "bb", "cc"] as Set

    when:
    set1 << "dd"

    then:
    set1 == set2
  }

  def "Exception is thrown when inserting in uninitialized list"() {
    given:
    List list = null

    when:
    list << "sample"

    then:
    NullPointerException e = thrown()
    e.message.contains("leftShift()")
  }
}

