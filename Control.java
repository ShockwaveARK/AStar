import java.util.ArrayList;

public class Control {

	//listas
	private ArrayList<No> fronteiras;
	private ArrayList<No> visitados;
	private ArrayList<No> desconhecidos;
	
	//matrizes
	private int matrizDistancias[][];
	private int matrizConexao[][];
	
	//gerenciador de arquivos
	private Arquivos arqControl;
	
	//variaveis de controle
	private int quantNos;
	private No noInicial;
	private No noFinal;
	private No noCorrente;
	
	Control(){
		fronteiras = new ArrayList<No>();
		visitados = new ArrayList<No>();
		desconhecidos = new ArrayList<No>();
		arqControl = new Arquivos();
	}
	
	public void Initialize(String arquivo,int idNoInicial, int idNoFinal){
		//recupero os dados do aquivo
		arqControl.readArq(arquivo);
		quantNos = arqControl.quantNos();
		matrizDistancias = arqControl.distancias();
		matrizConexao = arqControl.conexao();
		
		//crio os nos e adiciono na lista de desconhecidos
		for(int i = 0; i<quantNos;i++){
			desconhecidos.add(new No(i));
		}
		
		//recupero o no inicial
		noInicial = containsNo(desconhecidos, idNoInicial);
		//recupero o no final
		noFinal = containsNo(desconhecidos, idNoFinal);
		//removo da lista de desconhecidos
		desconhecidos.remove(idNoInicial);
		//no corrente e o no inicial
		noCorrente = noInicial;
	}
	
	
	public void findPath(){
		No aux = null;
		String caminho = "";
		int distancia = 0;
		while(noFinal != noCorrente){ //enquanto o corrente nao for o final
			//insiro o no corrente em visitados
			visitados.add(noCorrente);
			fronteiras.remove(noCorrente);
			//insiro os visinhos do corrente na fronteira
			insereFronteiras(noCorrente.getId());
			//recupera o proximo no
			noCorrente = proximoNo();
			if(noCorrente == null){
				System.out.println("Nao Existe caminho.");
				System.exit(0);
			}
		}
		//cheguei ate o no final, remonto o caminho de volta
		aux = noFinal;
		distancia = noFinal.getPesoCorrente();
		while(aux != null){
			caminho = (aux.getId()+1)+" "+caminho;
			aux = aux.getAnt();
		}
		System.out.println("Caminho: "+ caminho);
		System.out.println("Distancia: "+ distancia);
	}
	
	
	//insere os nos na fronteira com o informado na lista
	private void insereFronteiras(int id){
		No aux;
		//recupero os nos e insiro na lista
		for(int i =0 ; i<quantNos;i++){
			if(matrizConexao[id][i] > 1){//ou seja, somente visinhos
				aux = containsNo(desconhecidos,i);
				int novoPeso = matrizConexao[id][i]+noCorrente.getPesoCorrente(); //[dist Prox] + [pesoCorrente]
				if(aux != null){//se ainda for desconhecido
					if(!visitados.contains(aux)){//se nao foi visitado, adc a fronteiras, removo do desconhecido e atualizo peso 
						aux.setPesoCorrente(novoPeso);
						aux.setAnt(noCorrente); //seto anterior o corrente
						fronteiras.add(aux);
						desconhecidos.remove(aux);
					}
				}
				else{//se ja e conhecido
					aux = containsNo(fronteiras,i);
					if(aux != null){//se esta na fronteira
						if(aux.getPesoCorrente() > novoPeso){ //se atual melhor que o antigo
							aux.setPesoCorrente(novoPeso);
							aux.setAnt(noCorrente);
						}
					}
				}
			}
		}
	}
	

	//recupera o proximo menor no
	private No proximoNo(){
		No prox;
		int menor;
		int aux = 0;
		if(fronteiras.isEmpty()) //se nao tiver ninguem na fronteira
			return null;
		//primeiro da lista
		prox = fronteiras.get(0);
		menor = prox.getPesoCorrente() + matrizDistancias[prox.getId()][noFinal.getId()];  //[peso corrente]+[distancia ate final] ==> para converger para o local certo 
		//percorro a fronteira
		for(No cur: fronteiras){
			aux = matrizDistancias[cur.getId()][noFinal.getId()]; //[distancia ate o final -- linha reta]
			if((cur.getPesoCorrente() + aux) < menor){//se atual melhor que menor
				menor = cur.getPesoCorrente() + aux;
				prox = cur;
			}
		}
		return prox;
	}
	
	//retorna o no que possuir o id
	private No containsNo(ArrayList<No> list, int id){
		for(No cur: list){
			if(cur.getId() == id){
				return cur;
			}
		}
		return null;
	}
	
}
