package lu.bourse.engine.service;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import lu.bourse.engine.model.AssetType;
import lu.bourse.engine.model.MarketAsset;
@Service
public class DemoMarketDataService {
 /** No live provider connected: fixtures are illustrative, not actual market quotes. */
 public List<MarketAsset> universe() {
  return List.of(
   a("MSFT","Microsoft",AssetType.STOCK,"400",82,88,46,76,80,72,25,96),
   a("ASML","ASML",AssetType.STOCK,"650",86,84,50,73,75,78,40,89),
   a("NVDA","NVIDIA",AssetType.STOCK,"155",95,91,35,85,84,79,65,97),
   a("SAP","SAP",AssetType.STOCK,"220",75,80,55,71,72,66,34,88),
   a("V","Visa",AssetType.STOCK,"300",70,90,57,66,65,68,24,95),
   a("BNP.PA","BNP Paribas",AssetType.STOCK,"72",62,67,78,68,60,58,48,89),
   a("BTC","Bitcoin",AssetType.CRYPTO,"80000",78,55,50,82,62,73,80,99),
   a("ETH","Ethereum",AssetType.CRYPTO,"2800",75,57,52,74,58,69,82,96),
   a("SOL","Solana",AssetType.CRYPTO,"180",79,45,42,80,61,65,92,84));
 }
 private MarketAsset a(String ticker,String name,AssetType type,String price,
  double growth,double profitability,double valuation,double momentum,
  double revisions,double news,double volatility,double liquidity) {
  return new MarketAsset(ticker,name,type,new BigDecimal(price),growth,profitability,
    valuation,momentum,revisions,news,volatility,liquidity);
 }
}
