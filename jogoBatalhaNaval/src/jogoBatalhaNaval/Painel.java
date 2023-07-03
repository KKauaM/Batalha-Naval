package jogoBatalhaNaval;

import java.util.Scanner;

public class Painel {
	public static void main(String[] args) {

		// classes
		Scanner ler = new Scanner(System.in);
		
		// elementos
		char[][] tabuleiro = new char[8][9];
		int[] barco = new int[1];
		int bomba, tentativas;
		
		// inicio
		for(int l=0; l<=7; l++) {
			for(int c=0; c<=8; c++) {
				tabuleiro[l][c] = '~';
			}
		}
		
		// menu
		System.out.println("   1 2 3 4 5 6 7 8 9\n   -----------------");
		for(int l=0; l<=7; l++) {
			for(int c=0; c<=8; c++) {
				System.out.print(c==0 ?(c+1) +" |"+ tabuleiro[l][c] +"|" :tabuleiro[l][c] +"|");
			}
			System.out.println();
		}
		System.out.println("   -----------------");
		
		// jogo
		// System.out.println("Digite uma letra e um número(separados por espaço): ");
		// char letra, int num = ler.nextLine();
	}
}
