package leonhard.sommerer.graph.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.graph.ValueGraph;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.services.GraphCreatorService;
import leonhard.sommerer.graph.services.LoadedValueService;

@RestController
@RequestMapping(path = "graph")
public class GraphController {

  @Autowired
  private LoadedValueService valueService;

  @Autowired
  private GraphCreatorService graphService;

  @GetMapping("/")
  public ResponseEntity<ValueGraph<Location, Integer>> getWays() throws JsonProcessingException, IOException {
    return ResponseEntity.ok(graphService.translateJsonInformationsIntoGraph(valueService.getLocations(), valueService.getWays()));
  }

  @GetMapping("/{fromId}/{toId}")
  public ResponseEntity<Boolean> isWayPossible(@PathVariable String fromId, @PathVariable String toId) throws JsonProcessingException, IOException {
    Map<String, Location> locations = valueService.getLocations();
    ValueGraph<Location, Integer> graph = graphService.translateJsonInformationsIntoGraph(locations, valueService.getWays());
    return ResponseEntity.ok(graph.hasEdgeConnecting(locations.get(fromId), locations.get(toId)));
  }

}
