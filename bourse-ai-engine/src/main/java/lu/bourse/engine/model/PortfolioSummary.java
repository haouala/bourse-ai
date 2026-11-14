package lu.bourse.engine.model;
import java.math.BigDecimal;
import java.util.List;
public record PortfolioSummary(BigDecimal startingCapitalEur, int horizonMonths,
 BigDecimal cashReserveEur, BigDecimal allocatedEur, List<Recommendation> positions,
 String warning) {}
