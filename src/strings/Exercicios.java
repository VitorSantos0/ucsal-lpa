package strings;

public class Exercicios {

	public static void main(String[] args) {
		// forma detalhada de testar nossa função 
		String resposta;
		resposta = retirarLetrasDaPalavra("paralelepipedo", "ara");
		System.out.println(resposta);
		
		// forma mais objetiva de testar nossa função
		System.out.println(retirarLetrasDaPalavra("locagica", "ca"));
	}
	
	public static String retirarLetrasDaPalavra(String palavra, String letras) {
		// indices que irá armazenar as posições
		int inicioSubstring, finalSubstring; 
		// pegando a posição inicial das letras que quero retirar da minha palavra
		inicioSubstring = palavra.indexOf(letras); 
		// pegando a posição final a partir da soma da posição inicial com o tamanho das letras
		finalSubstring = inicioSubstring + letras.length();
		// variáveis que conterá as partes da palavra
		String primeiraParte, segundaParte;
		// repartindo a palavra a partir do seu indice inicial 0 ate o primeiro corte
		primeiraParte = palavra.substring(0, inicioSubstring);
		// rapartindo a palavra a partir da posição final da letra desejada até o tamanho final da palavra
		segundaParte = palavra.substring(finalSubstring, palavra.length());
		// juntando as partes da minha palavra sem as letras
		return primeiraParte+segundaParte;
	}
	
}