import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Arquivos {
	private int quantNos;
	private int matDistancia[][];
	private int matConexao[][];
	
	Arquivos(){

	}

	public int quantNos(){
		return quantNos;
	}
	
	public int[][] distancias(){
		return matDistancia;
	}
	
	public int[][] conexao(){
		return matConexao;
	}
	
	
	//le arquivo
	public void readArq(String arq){
		File arquivo = new File(arq);
		FileReader arqLeitura;
		BufferedReader leitor;
		String linha;
		String[] val;
		try {
			arqLeitura = new FileReader(arquivo);
			leitor = new BufferedReader(arqLeitura);
			
			try {
				//leio primeira linha
				linha = leitor.readLine();
				quantNos = Integer.parseInt(linha);
				//crio as matrizez
				matConexao = new int[quantNos][quantNos];
				matDistancia = new int[quantNos][quantNos];
				
				//pulo uma linha na leitura
				linha = leitor.readLine();
				
				//leio a matriz de distancias
				for(int i=0;i<quantNos;i++){
					linha = leitor.readLine();
					val = linha.split(" ");	//quebro os dados
					for(int j=0;j<quantNos;j++){
						matDistancia[i][j] = Integer.parseInt(val[j]);
					}
				}
				
				//pulo uma linha na leitura
				linha = leitor.readLine();
				
				//leio a matriz de Conexao
				for(int i=0;i<quantNos;i++){
					linha = leitor.readLine();
					val = linha.split(" ");	//quebro os dados
					for(int j=0;j<quantNos;j++){
						matConexao[i][j] = Integer.parseInt(val[j]);
					}
				}
				
			} catch (IOException e) {
				System.out.println("Falha ao ler o aquivo");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Falha ao ler o aquivo");
			System.exit(0);
		}
	}
}
