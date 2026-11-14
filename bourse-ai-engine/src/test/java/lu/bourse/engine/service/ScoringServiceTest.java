package lu.bourse.engine.service;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lu.bourse.engine.model.AssetType;
import lu.bourse.engine.model.MarketAsset;
import java.math.BigDecimal;
class ScoringServiceTest {
 private final ScoringService service=new ScoringService();
 @Test void scoreRemainsWithinBounds(){
  MarketAsset a=new MarketAsset("T","Test",AssetType.STOCK,BigDecimal.TEN,
   100,100,100,100,100,100,0,100);
  assertEquals(100.0,service.score(a));
  assertEquals("WATCH_BUY",service.signal(service.score(a)));
 }
 @Test void signalsAreThresholded(){
  assertEquals("WATCH_BUY",service.signal(80));
  assertEquals("WATCH",service.signal(65));
  assertEquals("AVOID",service.signal(64.9));
 }
}
