package leonhard.sommerer.graph.configuration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;

import leonhard.sommerer.graph.loader.RessourceLoader;
import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;

@Configuration
public class BaseConfiguration {

  @Bean
  public List<Way> ways() throws JsonProcessingException, IOException {
    return RessourceLoader.loadWays();
  }

  @Bean
  public Map<String, Location> locations() throws JsonProcessingException, IOException {
    return RessourceLoader.loadLocations();
  }

}
