package siga;

/**
 * Código INICIAL da atividade — contém os problemas PROPOSITAIS a refatorar.
 *
 * PROBLEMA 3 — instância não controlada (falta Singleton): nada impede que
 * várias partes do sistema criem seu próprio AcessoDados, quando deveria
 * existir um único ponto de acesso ao banco.
 *
 * Tarefa: - Etapa 4: transformar o AcessoDados em um Singleton.
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

    // método para chamar o builder
    public MontarConsultaBuilder montarConsultaBuilder(String tabela) {
        return new MontarConsultaBuilder(tabela);
    }

    // Utilização de classe Builder para evitar método telescopico
    public static class MontarConsultaBuilder {

        // Unicas duas variaveis que vi a necessidade de salvar
        private String tabela;
        private String filtro;
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(this.tabela);

        // Construtor que pede a tabela
        public MontarConsultaBuilder(String tabela) {
            this.tabela = tabela;
        }

        // Caso tenha filtro
        public MontarConsultaBuilder comFiltro(String filtro) {
            this.filtro = filtro;
            sb.append(" WHERE ").append(this.filtro);
            return this;
        }

        // Caso seja somente ativos
        public MontarConsultaBuilder comSomenteAtivos() {
            sb.append(this.filtro != null ? " AND ativo = 1" : " WHERE ativo = 1");
            return this;
        }

        // caso queira ordenacao
        public MontarConsultaBuilder comOrdenacao(String ordenacao) {
            sb.append(" ORDER BY ").append(ordenacao);
            return this;
        }

        public MontarConsultaBuilder comLimite(int limite) {
            sb.append(" LIMIT ").append(limite);
            return this;
        }

        // Caso queira offset
        public MontarConsultaBuilder comOffset(int offset) {
            sb.append(" OFFSET ").append(offset);
            return this;
        }

        // retornar a string
        public String montarConsulta() {
            return this.sb.toString();
        }
    }
}
