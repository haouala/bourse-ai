package lu.bourse.engine.model;
import java.math.BigDecimal;
public record Recommendation(String symbol, String name, AssetType type, double score,
 String signal, BigDecimal referencePriceEur, BigDecimal suggestedBudgetEur,
 BigDecimal stopLossEur, String rationale, boolean syntheticData) {}
