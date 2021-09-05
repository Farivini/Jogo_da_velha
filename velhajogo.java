package jogovelha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class velhajogo {
	
	static ArrayList <Integer> pJogador = new ArrayList<Integer> ();
	static ArrayList <Integer> posiCpu = new ArrayList<Integer> ();
	
	public static void main (String[] args) {
		
		// Vamos analisar como se da o jogo , se pensarmos e como se fosse uma matriz , linhas e colunas
		// char porque temos caracteres nao comum
		char [] [] tabuleiro = {{'_', '|' ,'_' ,'|', '_'},
								
								
				                  {' ','|', ' ','|',' '},
				                  {'_','|','_','|','_'},
								
								
								  {' ','|', ' ','|',' '},
								  {' ','|', ' ','|',' '}
								};
								
								mostraTabu(tabuleiro);
								// temos que pensar como uma matriz
								// dentro desses espaços analisar como preencher
								
								
								//vou optar por while pois considero o melhor para verificação booleana
								while(true) 
								{
									
									Scanner preenche= new Scanner (System.in);
									// instanciamos para o jogador colocar sua posição
									System.out.println("Coloque do 1 ao 9 para preencer a posição , sendo 1 o primeiro quadrado vazio a esquerda   "); // corresponde as posições
									int posiJogador = preenche.nextInt();
									while(pJogador.contains(posiJogador) || posiCpu.contains(pJogador)) // verifico se ja tem naquela posiçao
									{
										System.out.println("Entre com a posição correta: ");
										posiJogador = preenche.nextInt();
										
									}
									
									mexePeca(tabuleiro, posiJogador,"Jogador");
									
									
									// vamos verificar para o jogador e para o cpu
									String ganhador = verificaPosicao();
									if (ganhador.length() > 0) 
									{
										System.out.println(ganhador);
										break;
									}
									
									
									// vamos usar random para simular o CPU e dizer da onde ate aonde ele pode escolher 1 ao  9
									// uma implementação IA ate pode ser feita mas nesse caso acredito servir 
									
									
									Random randomico = new Random(); // instancio função randomica
									int posiIa = randomico.nextInt(9) + 1;
									while(pJogador.contains(posiIa) || posiCpu.contains(posiIa)) // verifico se conte algo no espaço
									{
										System.out.println("Entre com a posição correta: ");
										posiIa = randomico.nextInt(9) + 1;
									}
									
						            mexePeca(tabuleiro, posiIa,"CPU"); // marco no tabuleiro
									
									mostraTabu(tabuleiro);
								    
									ganhador = verificaPosicao(); // verificando se o jogo pode continuar
									if(ganhador.length() > 0) 
									{
										System.out.println(ganhador);
									    break; 	
									}
									
								
								
								//como falei pensamos como matriz e como vamos preencher os espaços VAZIOS
								//REPETIMOS PARA VERIFICAR A POSI
								
								/*     COLUNA                    tabuleiro[0][0]
								LINHA	0|2|4                              L  C
									    2|2|4
									    4|2|4
									    
									    Pode se usar switch tambem
*/
								if (posiJogador == 1) 
								{
									tabuleiro[0][0] = 'X';
								}
								if (posiJogador == 2) 
								{
									tabuleiro[0][2] = 'X';
								}
								if (posiJogador == 3) 
								{
									tabuleiro[0][4] = 'X';
								}
								if (posiJogador == 4) 
								{
									tabuleiro[2][0] = 'X';
								}
								if (posiJogador == 5) 
								{
									tabuleiro[2][2] = 'X';
								}
								if (posiJogador == 6) 
								{
									tabuleiro[2][4] = 'X';
								}
								if (posiJogador == 7) 
								{
									tabuleiro[4][0] = 'X';
								}
								if (posiJogador == 8) 
								{
									tabuleiro[4][2] = 'X';
								}
								if (posiJogador == 9) 
								{
									tabuleiro[4][4] = 'X';
								}
								
								
		
								
								}
							}
			
	
	// vamos encapsular o print do tabuleiro
	public static void mostraTabu (char [][] tabuleiro) 
	{
		// colocando nosso tabuleiro visualmente para dar entendimento melhor
				// esse bloco é que faz termos essa visualização
				for (char [] row: tabuleiro) 
				{
					for(char i : row) {
						System.out.print(i);
					}
					System.out.println();
				}
		
	}
	
	
	//criamos outra para setar de qual time é nosso e qual do CPU
	public static void mexePeca (char[][] tabuleiro, int preen, String user) 
	{
		char time = ' ';
		// fazer verificação para se user escolher X o CPU escolha O ou vice versa
		if (user.equals("Jogador"))
				{
					time = 'X';
					pJogador.add(preen);
					
				}
		else if ( user.equals("CPU")) 
				{
					time = 'O';
					posiCpu.add(preen);
				}
		
		
		// PARA QUE CPU PREENCHA TEMOS QUE COLOCAR A VARIAVEL QUE FIZEMOS NO LOCAL DO X
		
		if (preen == 1) 
		{
			tabuleiro[0][0] = time;
		}
		if (preen == 2) 
		{
			tabuleiro[0][2] = time;
		}
		if (preen == 3) 
		{
			tabuleiro[0][4] = time;
		}
		if (preen == 4) 
		{
			tabuleiro[2][0] = time;
		}
		if (preen == 5) 
		{
			tabuleiro[2][2] = time;
		}
		if (preen == 6) 
		{
			tabuleiro[2][4] = time;
		}
		if (preen == 7) 
		{
			tabuleiro[4][0] = time;
		}
		if (preen == 8) 
		{
			tabuleiro[4][2] = time;
		}
		if (preen == 9) 
		{
			tabuleiro[4][4] = time;
		}
		
		
		
	}
	
	
	// precisamos verificar a posicao e quem ganhou 
	// vamos gravar isto em uma lista
	public static String verificaPosicao() {
		
		
		List primeiraLinha = Arrays.asList(1,2,3);
		List segundaLinha = Arrays.asList(4,5,6);
		List terceiraLinha = Arrays.asList(7,8,9);
		
		//colocamos as colunas tambem
		
		List primeiraColuna = Arrays.asList(1,4,7);
		List segundaColuna = Arrays.asList(2,5,8);
		List terceiraColuna = Arrays.asList(3,6,9);
		
		// verifca cruzado
		List cruzado1 = Arrays.asList(1,5,9);
		List cruzado2 = Arrays.asList(7,5,3);
		
		List<List> vencedor = new ArrayList<List>();
		//verifica linha
		vencedor.add(primeiraLinha);
		vencedor.add(segundaLinha);
		vencedor.add(terceiraLinha);
		//verifica coluna
		vencedor.add(primeiraColuna);
		vencedor.add(segundaColuna);
		vencedor.add(terceiraColuna);
		//verifca o cruzado
		vencedor.add(cruzado1);
		vencedor.add(cruzado2);
		
		for(List l : vencedor ) 
		{
			if (pJogador.containsAll(l)) {
				return "Voce venceu";
			} else if (posiCpu.containsAll(l)) {
				return "CPU TE VENCEU";
				
			}else if (pJogador.size() + posiCpu.size() == 9) {
				return "Empate";
			}
		}
		return "";
		
	}
	
	
	
}
