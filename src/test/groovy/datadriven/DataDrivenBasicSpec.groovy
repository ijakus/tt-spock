package datadriven

import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenBasicSpec extends Specification {

  @Unroll
  def "Can find maximum of two numbers"() {
    expect:
    Math.max(a, b) == c

    where:
    a | b  || c
    1 | 1  || 1
    5 | 3  || 6
    4 | -1 || 4
  }
}
