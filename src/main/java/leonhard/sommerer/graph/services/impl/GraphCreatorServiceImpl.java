package leonhard.sommerer.graph.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;
import leonhard.sommerer.graph.services.GraphCreatorService;

@Service
public class GraphCreatorServiceImpl implements GraphCreatorService {

  @Override
  public ValueGraph<Location, Integer> translateJsonInformationsIntoGraph(Map<String, Location> locations, List<Way> ways) {
    MutableValueGraph<Location, Integer> graph = ValueGraphBuilder.undirected().build();
    for (Way way : ways) {
      graph.putEdgeValue(locations.get(way.getFrom()), locations.get(way.getTo()), way.getValue());
    }
    return graph;
  }

}
