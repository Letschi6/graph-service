package leonhard.sommerer.dikjstra.services;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.graph.ValueGraph;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;
import leonhard.sommerer.graph.services.GraphCreatorService;
import leonhard.sommerer.graph.services.impl.GraphCreatorServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { GraphCreatorServiceImpl.class })
public class GraphCreatorServiceTest {

  @Autowired
  GraphCreatorService graphCreatorService;

  @Test
  public void correctSetting_shouldCreateLinkfromNodeToNode() {
    Map<String, Location> locations = new HashMap<String, Location>();
    locations.put("1", new Location("1", "Wien"));
    locations.put("2", new Location("2", "Stockerau"));
    List<Way> ways = new ArrayList<Way>();
    ways.add(new Way("1", "2", 30));
    System.out.println(graphCreatorService);
    ValueGraph<Location, Integer> graph = graphCreatorService.translateJsonInformationsIntoGraph(locations, ways);
    assertTrue(graph.hasEdgeConnecting(locations.get("1"), locations.get("2")));

  }

}
