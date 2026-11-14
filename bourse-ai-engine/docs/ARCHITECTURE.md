# Architecture évolutive

`api -> service -> model` ; `config` pour les limites d'investissement.

MVP en mémoire avec fixtures : `DemoMarketDataService` -> `ScoringService` -> `RecommendationService` -> `PortfolioService`.

Pour une version de production : adaptateurs MarketDataProvider/NewsProvider, mécanisme de retries + quotas + cache ; PostgreSQL et Flyway pour données et simulations ; jobs planifiés ; moteur de portefeuille ; indicateurs de risque et audit ; backend de notification. Aucun de ces composants avancés n'est inclus dans cette version.
