package siga;

// Criação da fabrica abstrata FabricaBanco e definidindo o contrato
// de metodos que os membros de sua familia deverão seguir
public interface FabricaBanco {

    Conexao criarConexao();

    Comando criarComando();
}
