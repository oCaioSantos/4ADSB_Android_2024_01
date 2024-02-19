# Aula 15/02 - Primeira parte da tela da Calculadora IMC

## Jetpack Compose
O Jetpack Compose é uma biblioteca moderna de UI do Android que permite aos desenvolvedores construir interfaces de usuário nativas de forma declarativa e concisa. Ele foi criado pela Google e é totalmente escrito em Kotlin. O Jetpack Compose é uma alternativa ao tradicional sistema de Views do Android, que usa XML para a definição de layouts.

## @Composable
No Jetpack Compose, o @Composable é a peça-chave. Você usa @Composable para transformar funções simples em funções que podem criar partes de uma tela, como botões ou textos. Você pode até juntar várias dessas funções para fazer telas mais detalhadas e interessantes.

Essas funções @Composable deixam você montar a tela, controlar o que aparece e como as coisas se movem ou mudam. O legal do Compose é que ele é esperto para mudar só o que precisa na tela, sem refazer tudo do zero. Isso ajuda a fazer aplicativos que funcionam bem e parecem modernos, mudando rapidamente conforme o usuário usa.

## Column, Text, Row e OutlinedTextField
No pacote do Jetpack Compose temos nativamente alguns elementos de UI (composables) para criar nossas interfaces - além dos que podemos criar, anotando uma função com @Composable.

Alguns elementos servem para organizar o layout do nosso App, é o caso do Column e Row que dispõe os elementos dentro dele em forma de coluna ou linha. Outros elementos geram itens para exibir informações (Text) ou servem para que o usuário interaja com o aplicativo (OutlinedTextField). 

*Obs: A diferença entre o OutlinedTextField e o TextField é visual - o primeiro cria um campo com borda, diferente do segundo.

## Modifier e propriedades dos composables
O parâmetro "modifier" (geral a todos os composables) nos permite aprimorar / modificar o estilo dos nossos elementos; Este modificador é importante para tornar nossas UIs mais fiéis ao protótipo criado para nosso App, mas não é a única forma que temos de alterar as propriedades visuais de um composable.

Alguns parâmetros de estilização, são exclusivos de seus composables. O que quero dizer é que, não faz sentido um parâmetro que modifica o tamanho do texto (fontSize) ser propriedade de uma Row, por exemplo. Este parâmetro você encontrará fora do modifier, como um parâmetro do próprio elemento, em composables que tenham alguma relação com exibição de textos (Text, por exemplo).

## remember e mutableStateOf
Vamos analisar melhor o trecho de código a seguir:

```Kotlin
    var nome by remember {
        mutableStateOf("")
    }
```


`var peso`: Declara uma variável chamada peso.

`by`: Um operador de delegação em Kotlin. Aqui, ele diz que o getter e o setter da variável peso serão controlados por outra entidade, que é o que vem depois do by.

`remember`: Uma função do Compose que pede ao sistema para lembrar o estado de uma variável durante as recomposições. Isso significa que o valor de peso não será perdido quando a UI for redesenhada, o que acontece frequentemente no Compose.

`mutableStateOf("")`: Cria um estado mutável inicializado com uma string vazia. Esse estado é "observável", o que significa que quando ele muda, ele avisa o Compose para redesenhar qualquer parte da UI que dependa desse estado.

Então, essa linha toda cria uma variável peso que o Compose vai lembrar o valor dela, mesmo que a tela seja redesenhada. E qualquer parte da UI que use peso será atualizada automaticamente quando o valor de peso mudar.

## Como assim "a tela é redesenhada" ?
O Jetpack Compose atua com um padrão de *observabilidade* nos dados que você cria ao longo do código que impactam a sua UI; Isso faz com que, a todo momento ele esteja observando se os valores que fazem parte da lógica da sua tela mudaram ou não. 

Quando uma propriedade da sua lógica muda - por exemplo uma variável que armazena o valor de um `OutlinedTextField` (volte no exemplo acima) - o compose redesenha o layout para que o layout reflita sempre o último estado que seus dados têm. Isso faz parte do ciclo de <strong>composição e recomposição</strong> que o Jetpack Compose trouxe para o desenvolvimento Android.  

