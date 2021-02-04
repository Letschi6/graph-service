package leonhard.sommerer.graph.models;

import lombok.Data;

@Data
public class LocationDistance {

  private Location startLocation;
  private Location endLocation;
  private double distance;

}
