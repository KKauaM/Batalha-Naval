package batalhaNaval;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Painel {
	public static void main(String[] args) {

		// classes
		Random aleatorio = new Random();
		Scanner lerS = new Scanner(System.in);
		Scanner lerN = new Scanner(System.in);
		
		// variáveis
		int num = 0, letra = 9;
		String let = "nada";

		// elementos
		char[][] tabuleiro = new char[8][9];
		char[][] jogadas = new char[8][9];
		int quantBomb = 8, quantBarc = 15;
		int quantJog = 24;

		// *** inicio ***
		for (int l = 0; l <= 7; l++) {
			for (int c = 0; c <= 8; c++) {
				tabuleiro[l][c] = '~';
				jogadas[l][c] = '~';
			}
		}
		
		while(quantBomb>0 || quantBarc>0) {
			int l = aleatorio.nextInt(8), c = aleatorio.nextInt(9), ale = aleatorio.nextInt(2);
			
			if(ale==1 && quantBomb>0 && tabuleiro[l][c]=='~') {
				tabuleiro[l][c] ='*';
				quantBomb--;	
			}
			if(ale==0 && quantBarc>0 && tabuleiro[l][c]=='~') {
				tabuleiro[l][c] ='#';
				quantBarc--;
			}
		} quantBarc = 15;
		
		
		// *** jogo ***
		System.out.println("\n\n === BATALHA NAVAL ===\n   -----------------");
		System.out.println(" ~ = Vazio\n * = Bomba(gameOver (10))\n # = Barco(ponto)\n @ = Mar(Local já jogado)\n   -----------------\n");
		
		for (quantJog = 24; quantJog >= 0 && quantBarc!=0; quantJog--) {
			
			// *** jogada ***
			impMenu(jogadas, "", "");
			
			System.out.println("Digite uma letra e um num(separados por enter) \n(barcos restantes: "+ quantBarc +" | num Jogadas: "+ (quantJog+1) +"): ");
			let = lerS.nextLine(); num = lerN.nextInt()-1;
			
			
			// *** análise da resposta ***
			switch (let.toUpperCase()) {
			case "A":
				letra = 0; break;
			case "B":
				letra = 1; break;
			case "C":
				letra = 2; break;
			case "D":
				letra = 3; break;
			case "E":
				letra = 4; break;
			case "F":
				letra = 5; break;
			case "G":
				letra = 6; break;
			case "H":
				letra = 7; break;
			case "I":
				letra = 8; break;
			default:
				quantJog++; continue;
			}
			
			if(num<0 || num>7) {
				quantJog++; continue;
			}
			
			if(tabuleiro[num][letra] == '~') {
				System.out.println("Apenas na água 💦");
				jogadas[num][letra] = '@';
				
			} else if(tabuleiro[num][letra] == '#') {
				System.out.println("Achou um Barco 🛶"); quantBarc--;
				jogadas[num][letra] = '#';
				
			} else {
				System.out.println("Bomba 💣");
				impMenu(tabuleiro, "\n", "\n\n= Parabéns vc Perdeu! :) ="); break;
			}
		}
		
		// *** final ***
		if(quantJog<=0 && quantBarc!=0) {
			impMenu(tabuleiro, "\n\n Acabaram suas jogadas!", "\n\n= Parabéns vc Perdeu! :) =");
			
		} else if(quantBarc==0) {
			impMenu(tabuleiro, "\n", "\n\n= Parabéns vc Venceu! :( =");
		}
		
		lerS.close();
		lerN.close();
	}
	
	public static void impMenu(char[][] imp, String ini, String fim) {
		System.out.println(ini);
		System.out.println("   A B C D E F G H I\n   -----------------");
		for (int l = 0; l <= 7; l++) {
			for (int c = 0; c <= 8; c++) {
				System.out.print(c == 0 ? (l + 1) + " |" + imp[l][c] + "|" : imp[l][c] + "|");
			}
			System.out.println();
		}
		System.out.println("   -----------------"+ fim);
	}

}

/*
 * Integrar no jogo no futuro
 * 
 * barcos maiores;
 * interface gráfica;
*/
