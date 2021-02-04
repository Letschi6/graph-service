package leonhard.sommerer.graph.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;

public interface LoadedValueService {

  public List<Way> getWays() throws JsonProcessingException, IOException;

  public Map<String, Location> getLocations() throws JsonProcessingException, IOException;

}
