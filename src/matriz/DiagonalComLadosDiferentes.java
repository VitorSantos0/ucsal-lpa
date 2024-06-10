package matriz;

public class DiagonalComLadosDiferentes {

	public static void main(String[] args) {
		
		int[][] matriz = new int[4][4];
		
		preencheMatriz(matriz);
		mostraMatriz(matriz);
		
	}

	public static void preencheMatriz(int[][] matriz) {
		for(int linha=0; linha<matriz.length; linha++) {
			for(int coluna=0; coluna<matriz[0].length; coluna++) {
				if(coluna == linha) {
					matriz[coluna][linha] = 0;
				}else if(coluna > linha) {
					matriz[coluna][linha] = -1;
				}else {
					matriz[coluna][linha] = 1;
				}
			}
		}
	}
	
	public static void mostraMatriz(int[][] matriz) {
		for(int linha=0; linha<matriz.length; linha++) {
			for(int coluna=0; coluna<matriz[0].length; coluna++) {
				if(matriz[linha][coluna] == 0 || matriz[linha][coluna] == 1) {
					System.out.print(" ");
				}
				System.out.print(matriz[linha][coluna] + " ");
			}
			System.out.println();
		}
	}
	
}