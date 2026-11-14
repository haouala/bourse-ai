package lu.bourse.engine.service;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import lu.bourse.engine.config.EngineProperties;
import lu.bourse.engine.model.MarketAsset;
import lu.bourse.engine.model.Recommendation;
@Service
public class RecommendationService {
 private final DemoMarketDataService market;
 private final ScoringService scoring;
 private final RiskService risk;
 private final EngineProperties settings;
 public RecommendationService(DemoMarketDataService market,ScoringService scoring,
   RiskService risk,EngineProperties settings) {
  this.market=market;this.scoring=scoring;this.risk=risk;this.settings=settings;
 }
 public List<Recommendation> ranked() {
  return market.universe().stream().limit(settings.maximumUniverse())
   .sorted(Comparator.comparingDouble(scoring::score).reversed())
   .map(this::map).toList();
 }
 private Recommendation map(MarketAsset a) {
  double score=scoring.score(a);
  BigDecimal budget=risk.budget(new BigDecimal(settings.capitalEur())
    .divide(new BigDecimal(settings.maxPositions())),
    new BigDecimal(settings.riskPerTradeEur()),a.type());
  return new Recommendation(a.symbol(),a.name(),a.type(),score,scoring.signal(score),
   a.priceEur(),budget,risk.stopLoss(a.priceEur(),a.type()),
   "Score heuristique; indicateurs fictifs; aucune garantie de rendement",true);
 }
}
