# SIGA — Atividade de Padrões Criacionais

## Estrutura do projeto

```
siga-criacionais/
└── src/
    └── siga/
        ├── Conexao.java              (interface — produto; pronta)
        ├── Comando.java              (interface — produto; pronta)
        ├── ObjetosAcessoDados.java   (implementações MySQL e PostgreSQL; prontas)
        ├── AcessoDados.java          (contém os três problemas a refatorar)
        └── Main.java                 (demonstra os problemas em execução)
        └── FabricaBanco.java         (Abstract Factory)
        └── FabricaMySQL.java         (Fábrica do MySQL)
        └── FabricaPostgreSQL.java    (Fábrica do PostgreSQL)
```

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```
