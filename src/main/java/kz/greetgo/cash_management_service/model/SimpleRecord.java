
package kz.greetgo.cash_management_service.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SimpleRecord {

  public String id;
  public String title;

  public SimpleRecord() {

  }

  private SimpleRecord(String id, String title) {
    this.id = id;
    this.title = title;
  }

  public static SimpleRecord of(String id, String title) {
    return new SimpleRecord(id, title);
  }

}
