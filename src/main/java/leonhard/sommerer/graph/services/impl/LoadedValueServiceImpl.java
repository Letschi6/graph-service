package leonhard.sommerer.graph.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;
import leonhard.sommerer.graph.services.LoadedValueService;

@Service
public class LoadedValueServiceImpl implements LoadedValueService {

  @Autowired
  ApplicationContext context;

  @Override
  public List<Way> getWays() throws JsonProcessingException, IOException {
    return (List<Way>) context.getBean("ways");
  }

  @Override
  public Map<String, Location> getLocations() throws JsonProcessingException, IOException {
    return (Map<String, Location>) context.getBean("locations");
  }

}
