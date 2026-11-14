package lu.bourse.engine.service;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import lu.bourse.engine.config.EngineProperties;
import lu.bourse.engine.model.PortfolioSummary;
import lu.bourse.engine.model.Recommendation;
@Service
public class PortfolioService {
 private final RecommendationService recommendations;
 private final EngineProperties config;
 public PortfolioService(RecommendationService recommendations,EngineProperties config){
  this.recommendations=recommendations;this.config=config;
 }
 public PortfolioSummary simulate() {
  List<Recommendation> selected=recommendations.ranked().stream()
   .filter(r->r.score()>=65).limit(config.maxPositions()).toList();
  BigDecimal allocated=selected.stream().map(Recommendation::suggestedBudgetEur)
   .reduce(BigDecimal.ZERO,BigDecimal::add);
  BigDecimal capital=new BigDecimal(config.capitalEur());
  return new PortfolioSummary(capital,config.horizonMonths(),capital.subtract(allocated),
   allocated,selected,"Simulation éducative, données fictives; pas de passage d'ordres ni de prévision fiable.");
 }
}
