
public class No {

	private int pesoCorrente;
	private int idNo;
	private No ant;
	
	No(int id){
		this.idNo = id;
		pesoCorrente = 0;
		ant = null;
	}
	
	public int getId(){
		return idNo;
	}
	
	public void setPesoCorrente(int peso){
		this.pesoCorrente = peso;
	}
	
	public void setAnt(No n){
		ant = n;
	}
	
	public No getAnt(){
		return ant;
	}
	
	public int getPesoCorrente(){
		return pesoCorrente;
	}
}
