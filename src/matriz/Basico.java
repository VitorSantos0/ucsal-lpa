package matriz;

public class Basico {

	public static void main(String[] args) {
		
		
		int[][] matriz = new int[3][3];
		
		preencheMatriz(matriz);
		
		mostraMatriz(matriz);

	}
	
	public static void preencheMatriz(int[][] matriz) {
		int contador = 1;
		for(int i=0; i<matriz[0].length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				matriz[j][i] = contador;
				contador++;
			}
		}
	}
	
	public static void mostraMatriz(int[][] matriz) {
		for(int i=0; i<matriz[0].length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
