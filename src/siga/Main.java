package siga;

/**
 * Ponto de entrada do SIGA (código INICIAL da atividade da Aula 6).
 *
 * (3) qualquer parte do sistema pode instanciar seu próprio AcessoDados. Sua
 * tarefa é aplicar Abstract Factory, Builder e Singleton.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais (código inicial) ===\n");

        // Utilizando uma unica instância para suplir o singleton
        AcessoDados acesso = AcessoDados.getInstancia();
        // Passando as fábricas em vez de utilizar a string fixa
        acesso.conectar(new FabricaMySQL());
        System.out.println();
        acesso.conectar(new FabricaPostgreSQL());

        System.out.println();
        // Utilizando o builder para construir a string de consulta
        String consulta = acesso.montarConsultaBuilder("aluno").comFiltro("curso = 'DSM'").comOrdenacao("nome").comLimite(50).comOffset(0).comSomenteAtivos().montarConsulta();
        System.out.println("Consulta montada: " + consulta);

        System.out.println("\nObserve: nada garante que conexão e comando sejam do mesmo");
        System.out.println("fornecedor (Abstract Factory resolve); o método de consulta tem");
        System.out.println("parâmetros demais (Builder resolve); e não há controle de");
        System.out.println("instância única do acesso ao banco (Singleton resolve).");
    }
}
