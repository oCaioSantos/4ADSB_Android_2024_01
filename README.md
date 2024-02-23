# 4ADSB_Android_2024_01
Arquivos referentes as aulas da disciplina de programação mobile (Kotlin/Android) da turma 4ADSB 2024/01 

## Composable Box
No Jetpack Compose, o `Box` é um componente que permite organizar outros componentes de maneira simples em uma caixa retangular. É como uma caixa que contém outros elementos, e você pode definir como esses elementos devem ser posicionados dentro dessa caixa. O Box ajuda na criação de layouts flexíveis e na disposição de diferentes elementos de interface do usuário de forma organizada e visualmente agradável.

## Renderização condicional
Para esconder / mostrar a nossa `Box` nós utilizamos o poder da própria linguagem Kotlin misturada em nosso composable que gera a UI. 

Essa é uma das grandes vantagens do Jetpack Compose - o poder de utilizar, para compor nossa lógica dos elementos de UI, tudo que o Kotlin nos oferece, como condicionais, laços de repetição, listas, classes, entre outros. Observe o exemplo abaixo:

```
if (isBoxOpen) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                Color.Green,
                RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = mensagem,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
        )
    }
}
```