package lu.bourse.engine.model;
import java.math.BigDecimal;
/** Metrics are synthetic demo values, normalized to 0..100. */
public record MarketAsset(String symbol, String name, AssetType type, BigDecimal priceEur,
 double growth, double profitability, double valuation, double momentum,
 double analystRevisions, double newsSentiment, double volatility, double liquidity) {}
