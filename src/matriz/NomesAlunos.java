package matriz;

import java.util.Scanner;

public class NomesAlunos {

	public static void main(String[] args) {
		
		String[] alunos = new String[2];
		double[][] notas = new double[alunos.length][2];
		
		Scanner ler = new Scanner(System.in);
		
		
		for(int i=0; i<alunos.length; i++) {
			System.out.println("Informe o aluno "+(i+1)+": ");
			alunos[i] = ler.nextLine();
			for(int j=0; j<notas[0].length; j++) {
				System.out.println("Informe a nota "+(j+1)+" do aluno "+(i+1)+": ");
				notas[i][j] = ler.nextDouble(); // possible error type value
				ler.nextLine();
			}
		}
		
		ler.close();

		mostraAlunosNotas(alunos, notas);
		
	}
	
	public static void mostraAlunosNotas(String[] alunos, double[][] notas) {
		for(int i=0; i<notas.length; i++) {
			System.out.println("Aluno: "+alunos[i]);
			System.out.print("Notas: ");
			for(int j=0; j<notas[0].length; j++) {
				System.out.print(notas[i][j] + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
}
