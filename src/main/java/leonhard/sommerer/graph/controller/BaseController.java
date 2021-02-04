package leonhard.sommerer.graph.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import leonhard.sommerer.graph.models.Location;
import leonhard.sommerer.graph.models.Way;
import leonhard.sommerer.graph.services.LoadedValueService;

@RestController
@RequestMapping(path = "base")
public class BaseController {

  @Autowired
  private LoadedValueService valueService;

  @GetMapping("/test")
  public ResponseEntity<String> testMapping() {
    return ResponseEntity.ok("Service reached");
  }

  @GetMapping("/ways")
  public ResponseEntity<List<Way>> getWays() throws JsonProcessingException, IOException {
    return ResponseEntity.ok(valueService.getWays());
  }

  @GetMapping("/locations")
  public ResponseEntity<Map<String, Location>> getLocation() throws JsonProcessingException, IOException {
    return ResponseEntity.ok(valueService.getLocations());
  }

}
