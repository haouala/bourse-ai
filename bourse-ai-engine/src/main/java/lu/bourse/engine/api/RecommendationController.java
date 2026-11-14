package lu.bourse.engine.api;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lu.bourse.engine.model.Recommendation;
import lu.bourse.engine.service.RecommendationService;
@RestController @RequestMapping("/api/v1/recommendations")
public class RecommendationController {
 private final RecommendationService service;
 public RecommendationController(RecommendationService service){this.service=service;}
 @GetMapping public List<Recommendation> list(){return service.ranked();}
}
