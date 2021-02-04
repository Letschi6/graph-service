package leonhard.sommerer.graph.loader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;

public class RessourceLoader {

  public static Map<String, Location> loadLocations() throws JsonProcessingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Location> locations = mapper.readValue(new ClassPathResource("location.json").getFile(), new TypeReference<Map<String, Location>>() {
    });
    return locations;
  }

  public static List<Way> loadWays() throws JsonProcessingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(new ClassPathResource("ways.json").getFile(), WayJson.class).getWays();
  }

}
