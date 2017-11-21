package pojo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nodo {
	
	private String nome;
    
	//lista que contem o caminho mais curto do nodo inicial até o presente nodo
	private List<Nodo> caminhoMaisCurto;
	
	//mapa para associar os nodos adjacentes e o peso (em inteiro) da aresta
    private Map<Nodo, Integer> nodosAdjacentes;
    
    private Integer distancia;
 
    /**
     * Cria um nodo com os valores padrão de atributos
     * @param nome o nome do Nodo
     */
    public Nodo(String nome) {
        this.nome = nome;
        this.caminhoMaisCurto = new LinkedList<>();
        this.nodosAdjacentes = new HashMap<>();
        
        //a distancia sempre será iniciada com o valor maximo de integer (para simular o infinito)
        this.distancia = Integer.MAX_VALUE;
    }
    
    /**
     * Adiciona um nodo ajacente a este nodo
     * @param destino nodo adjacente
     * @param distancia tamanho da aresta
     */
    public void addDestino(Nodo destino, int distancia) {
    	this.nodosAdjacentes.put(destino, distancia);
    }
    
    
    public String escreveCaminho(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("Nodo ");
    	sb.append( this.nome );
    	sb.append(": ");
    	if (!this.caminhoMaisCurto.isEmpty()){
	    	for ( Nodo m: this.caminhoMaisCurto ){
	    		sb.append(m.getNome());
	    		sb.append(" -> ");
	    	}
    	}
    	//adiciona o nodo atual
    	sb.append(this.nome);
    	
    	sb.append(" (distância total: ");
    	sb.append(this.distancia);
    	sb.append(")");
    	return sb.toString();
    }
    
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
    	sb.append( this.nome );
    	sb.append("(");
    	if (this.distancia < Integer.MAX_VALUE){
    		sb.append(this.distancia);
    	}
    	else{
    		sb.append("infinito");
    	}
    	sb.append(")");
    	return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Nodo> getCaminhoMaisCurto() {
		return caminhoMaisCurto;
	}

	public void setCaminhoMaisCurto(List<Nodo> caminhoMaisCurto) {
		this.caminhoMaisCurto = caminhoMaisCurto;
	}

	public Map<Nodo, Integer> getNodosAdjacentes() {
		return nodosAdjacentes;
	}

	public void setNodosAdjacentes(Map<Nodo, Integer> nodosAdjacentes) {
		this.nodosAdjacentes = nodosAdjacentes;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
    
    

}
