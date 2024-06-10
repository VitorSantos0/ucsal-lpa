package jogos;

import java.util.Random;
import java.util.Scanner;

public class JogoDaSenha {

	public static void main(String[] args) {
		
		int senha[] = new int[4];
	   	 int tentativa[] = new int[4];
	   	 int contTentativa=0, contCorretos=0, entrada=0;
	   	 boolean entradaValida=false;
	   	 
	   	 String jogo = "jogo da senha";
	   	 int largura = jogo.length() + 80, margem = 40;

	   	 imprimirInstrucoes(largura, margem, jogo);
	   	 
	   	 Scanner sc = new Scanner(System.in);
	   	 
	   	 criarSenha(senha);
	   	 
	   	 while(contCorretos<4 && contTentativa<=10) {
	   		 
	   		 for(int i=0;i<tentativa.length;i++) {
	   			 escrever(0, "[?] informe o digito " + (i + 1) + " do codigo secreto:", false);
	   			 entrada = sc.nextInt();
	   			 entradaValida = entrada > 0 && entrada < 7;
	   			 if(entradaValida) {
	   				 tentativa[i] = entrada;
	   			 }else {
	   				 quebrarLinha(1);
	   				 escrever(0, "[!] atencao, o digito deve ser na escala de 1 a 6.", true);
	   				 quebrarLinha(1);
	   				 break;
	   			 }
	   		 }
	   	 
	   		 if(entradaValida) {
	   			 contCorretos = contabilizarDigitos(senha, tentativa, contTentativa);
	   			 contTentativa++;
	   		 }
	   	 
	   	 }
	   	 
	   	 sc.close();
	   	 
	   	 escreverSimbolo(largura, "#", true);
	   	 quebrarLinha(1);
	   	 
	   	 if(contCorretos<4) {
	   		 escrever(0, "O computador venceu!", false);
	   	 } else {
	   		 escrever(0, "Voce venceu!", false);
	   	 }
	   	 
	   	 quebrarLinha(2);
	   	 escrever(0, "senha correta: ", false);
	   	 mostrarSenha(senha);
	   	 
	    }
	    
	    public static void criarSenha(int senha[]) {
	   	 Random random = new Random();
	   	 
	   	 for(int i=0; i < senha.length;i++) {
	   		 senha[i]= random.nextInt(1,6);
	   	 }
	    }
	    
	    public static void mostrarSenha(int senha[]) {
	   	 
	   	 for(int i=0;i<senha.length;i++) {
	   		 System.out.print(senha[i]+" ");
	   	 }
	   	 System.out.println();
	    }
	    
	    public static int contabilizarDigitos(int senha[], int tentativa[], int chances) {
	   	 
	   	 int valores[] = new int[4];
	   	 int possiveisDeslocados[] = new int[4];
	   	 
	   	 int corretos=0, deslocados=0, errados=0;
	   	 
	   	 for(int i=0; i<senha.length;i++) {
	   		 if(senha[i] == tentativa[i]) {
	   			 valores[corretos] = tentativa[i];
	   			 corretos++;
	   		 }else {
	   			 possiveisDeslocados[errados] = tentativa[i];
	   			 errados++;
	   		 }
	   	 }
	   	 
	   	 if(errados > 0) {   		 
	   		 for(int i=0; i<errados; i++) {
	   			 for(int j=0; j < senha.length; j++) {
	   				 if(possiveisDeslocados[i] == senha[j]) {
	   					 deslocados++;
	   					 break;
	   				 }
	   			 }
	   		 }
	   	 }
	   	 
	   	 if(deslocados > 0) {
	   		 for(int i=0; i<errados;i++) {
	   			 for(int j=0; j < corretos; j++) {
	   				 if(possiveisDeslocados[i] == valores[j]) {
	   					 deslocados--;
	   				 }
	   			 }
	   		 }
	   	 }
	   	 
	   	 imprimirTentativas(chances+1, tentativa, corretos, deslocados);
	   	 
	   	 return corretos;
	   	 
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
	   	 escrever(0, "[=] tentativa " + chances + ": ", false);
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
