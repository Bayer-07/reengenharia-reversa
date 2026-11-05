# Financial Calculator

Refatoração (engenharia reversa com IA) de um cálculo financeiro monolítico.

## Regras de negócio

| Tipo de cliente   | Regra |
|-------------------|-------|
| `CONVENTION` (1)  | 12% de desconto sobre o total; se `statusPartial`, soma R$ 15,50 |
| `PARTICULAR` (2)  | 5% de desconto se o total for **maior** que 500 |
| Outro             | Sem alteração |

## Estrutura

```
src/main/java/com/engreversa/financial/
├── Client.java               # dados do cliente
├── ClientType.java           # tipos de cliente e valor adicional
├── FinancialCalculator.java  # regras de cálculo
└── Main.java                 # execução de exemplo
src/test/java/com/engreversa/financial/
└── FinancialCalculatorTest.java
```

## Como executar (Java 17)

```bash
./gradlew test   # roda os testes JUnit
./gradlew run    # roda o Main
```
