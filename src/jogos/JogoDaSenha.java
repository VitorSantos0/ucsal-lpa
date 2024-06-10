package jogos;

import java.util.Scanner;

public class JogoDaSenha {

	public static void main(String[] args) {
		
		String jogo = "jogo da senha";
		int largura = jogo.length() + 80, margem = 40;
		int corretos = 0, deslocados = 0, chances = 1;
		int tentativas[] = new int[4];
		boolean execucao = true;

		imprimirInstrucoes(largura, margem, jogo);

		while (execucao) {
			
			Scanner ler = new Scanner(System.in);
			
			for (int i = 0; i < 4; i++) {
				escrever(0, "[?] informe o digito " + (i + 1) + " do codigo secreto:", false);
				tentativas[i] = ler.nextInt();
			}
			
			corretos = 2;
			deslocados = 1;
			
			imprimirTentativas(chances, tentativas, corretos, deslocados);
			
			if (corretos == 4 || chances == 10) {
				execucao = false;
				ler.close();
			}

			chances++;
			
		}
		
		escreverSimbolo(largura, "#", true);
		quebrarLinha(1);

		if (corretos == 4) {
			escrever(0, "parabens! voce acertou a senha ", false);
		} else {
			escrever(0, "nao foi dessa vez a senha correta eh ", false);
		}
		
		// print password
		
		quebrarLinha(2);

	}

	public static void imprimirInstrucoes(int largura, int margem, String jogo) {

		escreverSimbolo(largura, "#", true);
		quebrarLinha(1);
		escrever(margem, jogo, true);
		quebrarLinha(1);
		escreverSimbolo(largura, "#", true);
		quebrarLinha(1);
		escrever(margem + 1, "[instrucoes]", true);
		quebrarLinha(1);
		escrever(0, "1. o objectivo do jogo eh adivinhar o codigo secreto", true);
		escrever(0, "2. esse codigo eh gerado de forma aleatoria contendo 4 digitos", true);
		escrever(0, "3. os digitos gerados serao somenta na escala de 1 a 6", true);
		escrever(0, "4. sera soliticado um digito de cada vez", true);
		escrever(0, "5. voce tera 10 tentativas para acertar o codigo", true);
		escrever(0, "6. sera exibido a quantidade de digitos corretos e deslocados a cada tentativa", true);
		quebrarLinha(2);

	}
	
	public static void imprimirTentativas(int chances, int tentativas[], int corretos, int deslocados) {
		quebrarLinha(1);
		escrever(0, "[=] tentativa numero " + chances + ": ", false);
		imprimirVetor(tentativas);
		quebrarLinha(1);
		escrever(0, "[=] digitos corretos: " + corretos, true);
		escrever(0, "[=] digitos deslocados: " + deslocados, true);
		quebrarLinha(1);
	}

	public static void imprimirVetor(int vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}

	public static void escrever(int margem, String texto, boolean quebra) {
		for (int i = 0; i < margem; i++) {
			System.out.print(" ");
		}
		System.out.print(texto.toUpperCase());
		if (quebra) {
			quebrarLinha(1);
		}
	}

	public static void escreverSimbolo(int largura, String simbolo, boolean quebra) {
		for (int i = 0; i < largura; i++) {
			escrever(0, simbolo.substring(0, 1), false);
		}
		if (quebra) {
			quebrarLinha(1);
		}
	}

	public static void quebrarLinha(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			System.out.println();
		}
	}

}
