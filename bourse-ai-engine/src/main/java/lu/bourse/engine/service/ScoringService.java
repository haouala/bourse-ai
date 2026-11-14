package lu.bourse.engine.service;
import lu.bourse.engine.model.AssetType;
import lu.bourse.engine.model.MarketAsset;
import org.springframework.stereotype.Service;
@Service
public class ScoringService {
 /** Heuristic score in [0,100]; it is not a probability of profit. */
 public double score(MarketAsset a) {
  double s;
  if (a.type()==AssetType.CRYPTO) {
   s = .20*a.growth()+.20*a.momentum()+.15*a.newsSentiment()
     +.10*a.analystRevisions()+.20*a.liquidity()+.15*(100-a.volatility());
  } else {
   s = .20*a.growth()+.20*a.profitability()+.15*a.valuation()
     +.20*a.momentum()+.15*a.analystRevisions()+.10*a.newsSentiment();
  }
  return Math.round(Math.max(0,Math.min(100,s))*10.0)/10.0;
 }
 public String signal(double score) { return score>=80 ? "WATCH_BUY" : score>=65 ? "WATCH" : "AVOID"; }
}
