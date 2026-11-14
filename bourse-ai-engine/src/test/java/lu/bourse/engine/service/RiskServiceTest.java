package lu.bourse.engine.service;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import lu.bourse.engine.model.AssetType;
class RiskServiceTest {
 private final RiskService service=new RiskService();
 @Test void capsBudgetByRisk(){
  assertEquals(new BigDecimal("100.00"),service.budget(new BigDecimal("200"),new BigDecimal("5"),AssetType.STOCK));
  assertEquals(new BigDecimal("50.00"),service.budget(new BigDecimal("200"),new BigDecimal("5"),AssetType.CRYPTO));
 }
}
