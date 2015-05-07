package simpledemo

import spock.lang.Specification

class HelloSpockSpec extends Specification {

  def "Hello spock sample feature"() {
    expect:
    "Hello Spock!".length() == 12
  }
}

