package datadriven

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class DataDrivenDatabaseSpec extends Specification {

  @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

  def setupSpec() {
    createTable()
    insertValues()
  }


  def "Can find max value of two numbers"() {
    expect:
    Math.max(a, b) == c

    where:
    [a, b, c] << sql.rows("select a, b, c from maxdata")
  }

  def "Can combine different assignments in where block"() {
    expect:
    Math.max(a, b) == c

    where:
    [a, b, c] << sql.rows("select a, b, c from maxdata")
    d << [1, 2, 3]
    e = d + 1
    f = Math.random() * 100
  }

  private void createTable() {
    sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
  }

  private void insertValues() {
    sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
  }
}
