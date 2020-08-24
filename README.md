Technical Assessment

Fellipe Bratti Pasini



Trecho 1: Gerar alertas de pesquisas 

Refatorado o nome das variáveis para ser mais representativo.

Refatorado o método process, pois este método estava demasiadamente extenso e confuso, dificultando a legibilidade.

Alterada lógica de construções dos alertas baseados em sequências de ifs. Foi criado 1 mapa onde a chave é a "questão" e uma factory buscará 
qual implementação equivalente atende aquele cenário. Desta forma caso novos regras fossem adicionadas o código permaneceria mais limpo e organizado.

Alterado os testes de igualdade movendo os valores que vêm da lista para a direita da condição, evitando assim erros como NullPointer.

Substituída as strings "hardcoded" por chaves do bundle (internacionalização)

Substituído os inteiros de tipo "hardcoded" por 1 enum mais representativo.

Alterado o tipo das variáveis de preço, que dificilmente seriam inteiros. Foi utilizado BigDecimal por melhor representar questões de precisão em cálculos monetários. 

Foi extraído teste de preço maior do que esperado para uma função. Além disso foi feito métodos nas entidades para transformar os atributos strings em monetário já tratando uma possível exceção de NumberFormatException.

Alterado o método do gateway de save para saveAll.

Criado 1 classe de envio de email que centraliza a lógica de construção e envio.

Criada 1 propriedade para definir o recebedor do email, substituindo a string "hardcoded".


Trecho 2: Busca de usuários

Substituído findById dentro do FOR e que ainda busca usuários inativos para 1 findAll já trazendo somente os ativos, evitando assim excessivas aberturas de conexão com o banco e mal uso da memória.



Trecho 3: Validação de Pesquisa

Faltavam cenários de testes.

Uma das validações (survey nulo) lançava exceção sendo que as demais adicionavam numa lista de erros. Foi padronizado para todas adicionerem nesta lista. Para não ocorrer NullPointer, a primeira validação pára a execução do método e já retorna a lista.

Dos cenários que existiam, o segundo (shouldReturnMessageSurveyMustHaveAnOwner) testava apenas se a lista continha 1 erro, entretanto outra validação poderia estar ocorrendo no lugar desta e o teste passaria da mesma forma.
