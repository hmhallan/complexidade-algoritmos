package pojo;

public class Aresta {

	private Nodo nodoOrigem;
	private Nodo nodoDestino;
	private int peso;

	public Aresta(Nodo nodoOrigem, Nodo nodoDestino, int peso) {
		super();
		this.nodoOrigem = nodoOrigem;
		this.nodoDestino = nodoDestino;
		this.peso = peso;

		// TODO confirmar se é necessário
		this.nodoOrigem.addDestino(nodoDestino, peso);
	}

	public Nodo getNodoOrigem() {
		return nodoOrigem;
	}

	public void setNodoOrigem(Nodo nodoOrigem) {
		this.nodoOrigem = nodoOrigem;
	}

	public Nodo getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Origem: " + nodoOrigem.toString());
		sb.append(", Destino: " + nodoDestino.toString());
		sb.append(". Peso: " + peso);
		return sb.toString();
	}
}