package main; 
//Package: ajudará na ordenação e na estruturação do agrupamento de classes.
// ; : será utilizado para finalizar e separar as instruções de cada linha do codigo.

import java.util.*; 
// import: oferece a classe de tal pacote, a possibilidade de acesso as demais classes que estejam em pacotes diferentes.

public class JogoDados {
// { } : as chaves é um indicador até aonde uma classe ou um metodo vai se estender.
//public class: metodo que vai permitir ser acessado pop qualquer outra classe.
// JogoDados: será a nossa variavel nomeada referente ao objetivo do programa.
	
	private Random randomNum = new Random(); 
// private:modificador que impede o acesso ou o uso externo da sua propria classe.
// randomNum: será o responsavel em gerar numeros aleatorios.
// new: nos dará uma nova instancia para a classe no caso a Random.
// (): na execução ele irá separar as variaveis como podemos ver acima na variavel "Random".
	
	private enum Status {Contiue, WON, LOST}; 
//enum: nos concede a utilização de armazenar valores constates.
// Status {Contiue, WON, LOST}:  nessa variavel ela estara ligada na chave ap lado, e dentro dela estarão os metodos continua, ganho e perdido.
 	private final static int SNAKE_EYES = 2; 
 // final:assim que o codigo for executado ele será uma forma de garantir que o valor não seja modificada.
 // static: garantir que todas as instancias da classe visualizem a mesma coisa, quando olharem para a variavel declarada.
 // int: será um dado primitivo que armazenará numeros inteiros.	
 	
 	private final static int TREY = 3;
	private final static int SEVEN = 7;
	private final static int YO_LEVEN = 11;
	private final static int BOX_CARS = 12;
 // Nota: as variveis SNAKE_EYES,TREY,SEVEN,YO_LEVEN e BOX_CARS sera as nossas variaveis com seus respectivos valores constantes.
	public void play() {
// void: metodo que não trará valor nenhum no retorno.
		int myPoint = 0;
		Status gameStatus;
		int sumDice = rollDice();
		
		switch (sumDice) {
		//switch case: será uma esrutura simples e intuitiva de multiplas condições. 
			case SEVEN:
			case YO_LEVEN:
				gameStatus=Status.WON;
			case SNAKE_EYES:
			case BOX_CARS:
				gameStatus = Status.LOST;
			case TREY:
			default:
			// default: será uma condicional em execução caso as condições acima não se encaixa com a variavel utilizada.
				gameStatus = Status.Contiue;
				myPoint = sumDice;
				System.out.printf("Point is %d\n", myPoint);
				break;
			// System.out: permitira a exibição de strings no console ou na execução.
			//printf: na saída de tela ele ira imprimir a string formatada.
			// %d: serve para imprimir numeros inteiros na execução.
			// /n : ele faz com que a saída de tela se mova para uma nova linha ao inves de seguir em frente na execução.
			//break: será uma função que ira impedir um loop na execução.
		}
		while (gameStatus==Status.Contiue) {
		//while: laço de repetição onde a sua repetição será indeterminada.
			sumDice = rollDice();
			
			if (sumDice == myPoint)
		// if/else: laços de repetição onde na execução caso a variavel for verdadeira o if será executado ,caso fosse falsa else entra na execução.
				gameStatus = Status.WON;
			else
				if (sumDice==SEVEN)
					gameStatus = Status.LOST;
		}
		if (gameStatus == Status.WON) 
			System.out.println("Player wins!");
		//println(): quando o programa for executado ele ira gerar o texto que está dentro dos parenteses.
		else
			System.out.println("Player loses!");
	}
	public int rollDice() {
		int die1 = 1 + randomNum.nextInt(6);
		int die2 = 1 + randomNum.nextInt(6);
		int sum = die1 + die2;
		System.out.printf("Players rolled %d = %d\n", die1, die2, sum);
		return sum;
	//return: ele vai retornar a tal variavel dentro do metodo no console.
	
	}
}
