package siga;

// Membro da Familia da Farica Abstrata que cuidará da implementação
// da conexão e dos comandos PostGreSQL
public class FabricaPostgreSQL implements FabricaBanco {

    @Override
    public Conexao criarConexao() {
        return new ConexaoPostgreSQL();
    }

    @Override
    public Comando criarComando() {
        return new ComandoPostgreSQL();
    }
}
