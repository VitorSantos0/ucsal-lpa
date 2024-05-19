package vetores;

import java.util.Scanner;

public class Urna {

	public static void main(String[] args) {
		
		Scanner ler=new Scanner(System.in);

        String [] candidatos=new String[6];
        
        int branco=0, cont1=0,cont2=0,cont3=0,cont4=0,cont5=0,nulo=0;

        int eleit=0;


        for (int i=1;i<candidatos.length;i++){
            System.out.println("Nome do candidato "+i+":");
            candidatos[i]= ler.next();
        }

        System.out.println("Qual a quantidade de eleitores ? ");
        eleit= ler.nextInt();

        int [] votos=new int[eleit];

        for (int i=0;i<eleit;i++){
            System.out.println("(0) BRANCO");
            System.out.println("(1) "+candidatos[1]);
            System.out.println("(2) "+candidatos[2]);
            System.out.println("(3) "+candidatos[3]);
            System.out.println("(4) "+candidatos[4]);
            System.out.println("(5) "+candidatos[5]);
            votos[i]= ler.nextInt();
        }
        
        ler.close();

        for (int i=0;i< votos.length;i++){
            if(votos[i]==0){
                branco++;
            }
            if(votos[i]==1){
                cont1++;
            }
            if(votos[i]==2){
                cont2++;
            }
            if(votos[i]==3){
                cont3++;
            }
            if(votos[i]==4){
                cont4++;
            }
            if(votos[i]==5){
                cont5++;
            }
            if(votos[i]>5||votos[i]<0){
                nulo++;
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("BOLETIM FINAL DA ELEIÇÃO: ");

        System.out.println("Votos BRANCOS: "+branco);
        System.out.println("Votos NULOS: "+nulo);
        System.out.println("Votos do candidato(a) "+candidatos[1]+":"+cont1);
        System.out.println("Votos do candidato(a) "+candidatos[2]+":"+cont2);
        System.out.println("Votos do candidato(a) "+candidatos[3]+":"+cont3);
        System.out.println("Votos do candidato(a) "+candidatos[4]+":"+cont4);
        System.out.println("Votos do candidato(a) "+candidatos[5]+":"+cont5);
        System.out.println("--------------------------------------");
        if(cont1>cont2 && cont1>cont3 && cont1>cont4 && cont1>cont5){
            System.out.println("CANDIDATO VENCEDOR: "+candidatos[1]+"!");
        }
        if(cont2>cont1 && cont2>cont3 && cont2>cont4 && cont2>cont5){
            System.out.println("CANDIDATO VENCEDOR: "+candidatos[2]+"!");
        }
        if(cont3>cont1 && cont3>cont2 && cont3>cont4 && cont3>cont5){
            System.out.println("CANDIDATO VENCEDOR: "+candidatos[3]+"!");
        }
        if(cont4>cont1 && cont4>cont2 && cont4>cont3 && cont4>cont5){
            System.out.println("CANDIDATO VENCEDOR: "+candidatos[4]+"!");
        }
        if(cont5>cont1 && cont5>cont2 && cont5>cont3 && cont5>cont4){
            System.out.println("CANDIDATO VENCEDOR: "+candidatos[5]+"!");
        }

	}

}
