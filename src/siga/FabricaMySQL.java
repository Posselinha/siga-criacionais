package siga;

// Membro da Familia da Farica Abstrata que cuidará da implementação
// da conexão e dos comandos MySQL
public class FabricaMySQL implements FabricaBanco {

    @Override
    public Conexao criarConexao() {
        return new ConexaoMySQL();
    }

    @Override
    public Comando criarComando() {
        return new ComandoMySQL();
    }
}
