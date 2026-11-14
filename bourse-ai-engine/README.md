# Bourse AI Engine — MVP v0.1

Projet Maven **Java 21 / Spring Boot 3.5.7**, prêt à ouvrir dans IntelliJ IDEA.

## Objectif
- Capital de départ : **1 000 €** ; horizon : **6 mois** ; profil : **modéré**.
- Architecture conçue pour aller jusqu'à **500 actions** avec extension aux cryptomonnaies.
- **Cette version livre 9 actifs d'exemple**, pas encore l'analyse live des 500 titres.
- Score heuristique /100, classement, signaux `WATCH_BUY` (>=80), `WATCH` (>=65), `AVOID` (<65).
- Simulation de portefeuille (maximum 5 positions) et risque théorique limité à 5 € par position selon un stop hypothétique.
- **Aucune donnée de marché réelle**, aucun ordre envoyé et aucune IA externe connectée pour l'instant.

## Prérequis
Installer **JDK 21** et **Maven 3.9+**.

## Exécution
```bash
mvn clean test
mvn spring-boot:run
```

## API
- http://localhost:8080/actuator/health
- http://localhost:8080/api/v1/market/assets
- http://localhost:8080/api/v1/recommendations
- http://localhost:8080/api/v1/portfolio/simulation

Exemple :
```bash
curl http://localhost:8080/api/v1/portfolio/simulation
```

## Intégration GitHub
Décompresser le ZIP, ouvrir le dossier `bourse-ai-engine` dans IntelliJ, puis depuis le terminal du dossier :
```bash
git init
git branch -M main
git add .
git commit -m "Initial Bourse AI Engine MVP"
git remote add origin https://github.com/haouala/bourse-ai.git
git push -u origin main
```
Si le dépôt contient déjà un commit, **ne pas forcer le push** : récupérer d'abord l'historique, ou ajouter les fichiers directement sur une branche depuis ton dépôt.

## Prochaines étapes (non implémentées)
1. Connecteurs fournisseurs de cours, news et fondamentaux avec licences/API keys.
2. Univers de 500 actions dynamique, calendrier de marchés et qualité des données.
3. Persistance PostgreSQL/Flyway, cache Redis, scheduling et alertes.
4. Backtesting avec frais/slippage, gestion des devises, drawdown et exposition crypto.
5. Agents IA, traçabilité des explications, validation humaine et paper trading.

> **Attention** : les données et prix sont inventés. Les scores ne représentent pas une probabilité de gain ni un conseil d'investissement personnalisé.
