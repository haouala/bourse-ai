package lu.bourse.engine.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lu.bourse.engine.model.PortfolioSummary;
import lu.bourse.engine.service.PortfolioService;
@RestController @RequestMapping("/api/v1/portfolio")
public class PortfolioController {
 private final PortfolioService service;
 public PortfolioController(PortfolioService service){this.service=service;}
 @GetMapping("/simulation") public PortfolioSummary simulate(){return service.simulate();}
}
