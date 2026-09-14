1. **Analisar** o código inicial e identificar a possibilidade de misturar fornecedores e o método de consulta telescópico.

Na classe AcessoDados dentro do método conectar, podemos notar a utilização de um bloco condicional if/else para verificar o tipo de fornecedor e nisso retornar sua devida instância de comando e conexão. A utilização do bloco condicional faz violação do principio Aberto/Fechado, visto que cada novo fornecedor que for adicionado no sistema, será preciso modificar o método conectar. Também podemos notar possivel chance de engano na utilização dos comados da familia (Usar comando postgress na conexão MySQL)

Para esse primeiro problema, o ideal seria a criação de um Abstract Factory que irá conter a familia de fornecedores e assim permitir a devida utilização em conjunto das instancias de comando e conexão

Para o método montarConsulta da mesma classe, podemos notar uma assinatura telescópica, ou seja, que possui vários parametros, podendo ou não ser opcionais e fazendo com que vários valores fiquem de cunho duvidoso (0, null, true e false) caso forem passados e nisso também podendo ocasionar na inserção de valores errados caso erre a ordem da passagem dos argumentos.

Podemos resolver este problema com a utilização do Builder, permitindo separar a construção de um objeto complexo
