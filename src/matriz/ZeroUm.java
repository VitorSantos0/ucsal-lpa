package matriz;

public class ZeroUm {

	public static void main(String[] args) {
		
		int[][] matriz = new int[4][4];
		
		preencheMatriz(matriz);
		
		mostraMatriz(matriz);

	}

	public static void preencheMatriz(int[][] matriz) {
		int binario = 0;
		for(int i=0; i<matriz.length; i++) {
			binario = i%2;
			for(int j=0; j<matriz[0].length; j++) {
				matriz[j][i] = binario;
			}
		}
	}
	
	public static void mostraMatriz(int[][] matriz) {
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
