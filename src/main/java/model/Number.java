package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "numbers")
public class Number {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  //@Column(columnDefinition = "MEDIUMTEXT", name = "content")
  private int number;

  private Date date;

}
