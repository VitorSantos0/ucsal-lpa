package jogos;

import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main(String[] args) {
		
		boolean terminar = false, vencedor = false;
		String[][] jogo = new String[3][3];
		int posicao, jogada=1;
		String simbolo;
		
		Scanner ler = new Scanner(System.in);
		
		iniciarJogo(jogo, jogada);
		
		while(!terminar) {
			
			exibirVelha(jogo);
			
			if(jogada%2==1) {
				simbolo = "X";
			}else {
				simbolo = "O";
			}
			
			System.out.println();
			System.out.println("JOGADOR "+simbolo);
			System.out.print("POSICAO DESEJADA: ");

			posicao = ler.nextInt();
			
			System.out.println();
			
			marcarSimbolo(jogo, posicao, simbolo);
			
			vencedor = verificarVencedor(jogo, simbolo);
			
			jogada++;
			
			if(jogada == 9 || vencedor) {
				System.out.println("-------------------------");
				System.out.println();
				if(vencedor) {					
					System.out.println("JOGADOR "+simbolo+" VENCEU!");
				}else {
					System.out.println("O JOGO EMPATOU!");
				}
				terminar = true;
			}
			
		}
		
		ler.close();
		
	}
	
	public static void iniciarJogo(String[][] matriz, int celula) {
		System.out.println("# JOGO DA VELHA #");
		System.out.println();
		for(int i =0; i<matriz.length; i++) {
			for(int j=0; j < matriz[0].length; j++) {
				matriz[i][j] = " "+celula+" ";
				celula++;
			}
		}
	}
	
	public static void exibirVelha(String[][] matriz) {
		for(int i =0; i<matriz.length; i++) {
			for(int j=0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]+"|");
			}
			System.out.println();
			if(i < matriz.length - 1) {
				for(int l=0; l <matriz[0].length; l++) {
					System.out.print("---+");
				}
				System.out.println();
			}
		}
	}
	
	public static void marcarSimbolo(String[][] matriz, int posicao, String simbolo) {
		for(int i =0; i<matriz.length; i++) {
			for(int j=0; j < matriz[0].length; j++) {
				if(matriz[i][j].equals(" "+posicao+" ")) {
					matriz[i][j] = " "+simbolo+" ";
				}
			}
		}
	}
	
	public static boolean verificarVencedor(String[][] matriz, String simbolo) {
		simbolo = " "+simbolo+" ";
		if(matriz[0][0].equals(simbolo)) {
			if(matriz[0][1].equals(simbolo) || matriz[1][1].equals(simbolo)) {
				if(matriz[0][2].equals(simbolo) || matriz[2][2].equals(simbolo)) {
					return true;
				}
			}
		}
		if(matriz[1][0].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[1][2].equals(simbolo)) {
			return true;
		}
		if(matriz[2][0].equals(simbolo)) {
			if(matriz[1][1].equals(simbolo) || matriz[2][1].equals(simbolo)) {
				if(matriz[0][2].equals(simbolo) || matriz[2][2].equals(simbolo)) {
					return true;
				}
			}
		}
		return false;
	}

}
