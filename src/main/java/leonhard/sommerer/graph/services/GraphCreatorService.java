package leonhard.sommerer.graph.services;

import java.util.List;
import java.util.Map;

import com.google.common.graph.ValueGraph;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;

public interface GraphCreatorService {

  public ValueGraph<Location, Integer> translateJsonInformationsIntoGraph(Map<String, Location> locations, List<Way> ways);

}
