package lu.bourse.engine.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import lu.bourse.engine.model.AssetType;
@Service
public class RiskService {
 /** Risk amount = position budget * assumed stop-distance. No execution is performed. */
 public BigDecimal budget(BigDecimal available, BigDecimal riskPerTrade,AssetType type) {
  BigDecimal stopPct=type==AssetType.CRYPTO?new BigDecimal("0.10"):new BigDecimal("0.05");
  BigDecimal byRisk=riskPerTrade.divide(stopPct,2,RoundingMode.DOWN);
  return available.min(byRisk).max(BigDecimal.ZERO).setScale(2,RoundingMode.DOWN);
 }
 public BigDecimal stopLoss(BigDecimal price,AssetType type) {
  BigDecimal multiplier=type==AssetType.CRYPTO?new BigDecimal("0.90"):new BigDecimal("0.95");
  return price.multiply(multiplier).setScale(2,RoundingMode.HALF_UP);
 }
}
