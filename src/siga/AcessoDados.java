package siga;

/**
 * Código INICIAL da atividade — contém os problemas PROPOSITAIS a refatorar.
 *
 * PROBLEMA 2 — construtor telescópico (falta Builder): a configuração de uma
 * consulta é passada por um método com muitos parâmetros opcionais (limite,
 * offset, ordenação, timeout...), ilegível e sujeito a erro de ordem dos
 * argumentos.
 *
 * PROBLEMA 3 — instância não controlada (falta Singleton): nada impede que
 * várias partes do sistema criem seu próprio AcessoDados, quando deveria
 * existir um único ponto de acesso ao banco.
 *
 * Tarefa: - Etapa 3: criar um Builder para a configuração da consulta
 * (parâmetros opcionais nomeados e encadeáveis). - Etapa 4: transformar o
 * AcessoDados em um Singleton.
 */
public class AcessoDados {

    private Conexao conexao;
    private Comando comando;

    // Utilização da interface de abstract Factory para receber a fabrica correta
    public void conectar(FabricaBanco fabrica) {
        // Salvando a instancia de conexão e comando da fabrica recebida
        this.conexao = fabrica.criarConexao();
        this.comando = fabrica.criarComando();
        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }

    // PROBLEMA 2: método telescópico — muitos parâmetros opcionais.
    public String montarConsulta(String tabela, String filtro, String ordenacao,
            int limite, int offset, int timeoutSegundos,
            boolean somenteAtivos) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(tabela);
        if (filtro != null) {
            sb.append(" WHERE ").append(filtro);
        }
        if (somenteAtivos) {
            sb.append(filtro != null ? " AND ativo = 1" : " WHERE ativo = 1");
        }
        if (ordenacao != null) {
            sb.append(" ORDER BY ").append(ordenacao);
        }
        if (limite > 0) {
            sb.append(" LIMIT ").append(limite);
        }
        if (offset > 0) {
            sb.append(" OFFSET ").append(offset);
        }
        return sb.toString();
    }
}
