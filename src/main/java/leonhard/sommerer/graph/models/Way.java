package leonhard.sommerer.graph.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Way {

  private String from;
  private String to;
  private Integer value;

}
