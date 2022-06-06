package main; 
//Package: ajudar� na ordena��o e na estrutura��o do agrupamento de classes.
// ; : ser� utilizado para finalizar e separar as instru��es de cada linha do codigo.

import java.util.*; 
// import: oferece a classe de tal pacote, a possibilidade de acesso as demais classes que estejam em pacotes diferentes.

public class JogoDados {
// { } : as chaves � um indicador at� aonde uma classe ou um metodo vai se estender.
//public class: metodo que vai permitir ser acessado pop qualquer outra classe.
// JogoDados: ser� a nossa variavel nomeada referente ao objetivo do programa.
	
	private Random randomNum = new Random(); 
// private:modificador que impede o acesso ou o uso externo da sua propria classe.
// randomNum: ser� o responsavel em gerar numeros aleatorios.
// new: nos dar� uma nova instancia para a classe no caso a Random.
// (): na execu��o ele ir� separar as variaveis como podemos ver acima na variavel "Random".
	
	private enum Status {Contiue, WON, LOST}; 
//enum: nos concede a utiliza��o de armazenar valores constates.
// Status {Contiue, WON, LOST}:  nessa variavel ela estara ligada na chave ap lado, e dentro dela estar�o os metodos continua, ganho e perdido.
 	private final static int SNAKE_EYES = 2; 
 // final:assim que o codigo for executado ele ser� uma forma de garantir que o valor n�o seja modificada.
 // static: garantir que todas as instancias da classe visualizem a mesma coisa, quando olharem para a variavel declarada.
 // int: ser� um dado primitivo que armazenar� numeros inteiros.	
 	
 	private final static int TREY = 3;
	private final static int SEVEN = 7;
	private final static int YO_LEVEN = 11;
	private final static int BOX_CARS = 12;
 // Nota: as variveis SNAKE_EYES,TREY,SEVEN,YO_LEVEN e BOX_CARS sera as nossas variaveis com seus respectivos valores constantes.
	public void play() {
// void: metodo que n�o trar� valor nenhum no retorno.
		int myPoint = 0;
		Status gameStatus;
		int sumDice = rollDice();
		
		switch (sumDice) {
		//switch case: ser� uma esrutura simples e intuitiva de multiplas condi��es. 
			case SEVEN:
			case YO_LEVEN:
				gameStatus=Status.WON;
			case SNAKE_EYES:
			case BOX_CARS:
				gameStatus = Status.LOST;
			case TREY:
			default:
			// default: ser� uma condicional em execu��o caso as condi��es acima n�o se encaixa com a variavel utilizada.
				gameStatus = Status.Contiue;
				myPoint = sumDice;
				System.out.printf("Point is %d\n", myPoint);
				break;
			// System.out: permitira a exibi��o de strings no console ou na execu��o.
			//printf: na sa�da de tela ele ira imprimir a string formatada.
			// %d: serve para imprimir numeros inteiros na execu��o.
			// /n : ele faz com que a sa�da de tela se mova para uma nova linha ao inves de seguir em frente na execu��o.
			//break: ser� uma fun��o que ira impedir um loop na execu��o.
		}
		while (gameStatus==Status.Contiue) {
		//while: la�o de repeti��o onde a sua repeti��o ser� indeterminada.
			sumDice = rollDice();
			
			if (sumDice == myPoint)
		// if/else: la�os de repeti��o onde na execu��o caso a variavel for verdadeira o if ser� executado ,caso fosse falsa else entra na execu��o.
				gameStatus = Status.WON;
			else
				if (sumDice==SEVEN)
					gameStatus = Status.LOST;
		}
		if (gameStatus == Status.WON) 
			System.out.println("Player wins!");
		//println(): quando o programa for executado ele ira gerar o texto que est� dentro dos parenteses.
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
