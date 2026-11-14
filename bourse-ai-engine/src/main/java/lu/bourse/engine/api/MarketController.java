package lu.bourse.engine.api;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lu.bourse.engine.model.MarketAsset;
import lu.bourse.engine.service.DemoMarketDataService;
@RestController @RequestMapping("/api/v1/market")
public class MarketController {
 private final DemoMarketDataService data;
 public MarketController(DemoMarketDataService data){this.data=data;}
 @GetMapping("/assets") public List<MarketAsset> assets(){return data.universe();}
}
