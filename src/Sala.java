

public class Sala {
	public int bloco;
	public int sala;
	public int capacidade;
	public boolean acessivel;
	
	public Sala() {
		
	}
	public Sala(int bloco, int sala, int capacidade, boolean acessivel) {
		this.sala = sala;
		this.bloco = bloco;
		this.capacidade = capacidade;
		this.acessivel = acessivel;
	}
	
	public String getDescricao() {
		String a; 
		if(acessivel == true) {
			a =  "acessível";
		}else {
			a = "não acessível";
		}
		return "Bloco " + this.bloco + ", Sala " + this.sala + " (" + this.capacidade + " lugares, " + a + ")";
	}
}
