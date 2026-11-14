package lu.bourse.engine.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix="engine")
public record EngineProperties(int capitalEur, int horizonMonths, int maximumUniverse,
 int maxPositions, int riskPerTradeEur) {}
