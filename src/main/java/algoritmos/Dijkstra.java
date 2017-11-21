package algoritmos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import pojo.Grafo;
import pojo.Nodo;

public class Dijkstra {
	
	public static void calculaCaminhoMaisCurtoDeUmNodoInicial(Grafo Grafo, Nodo inicio) {
		
		//seta a distancia do inicio para zero
		inicio.setDistancia(0);
	 
	    Set<Nodo> visitados = new HashSet<>();
	    Set<Nodo> naoVisitados = new HashSet<>();
	 
	    naoVisitados.add(inicio);
	 
	    //enquanto houver nodos para visitar
	    while (naoVisitados.size() != 0) {
	    	
	    	//busca na lista de nao visitados o nodo de menor distancia
	        Nodo nodoAtual = buscaNodoDeMenorDistancia(naoVisitados);
	        naoVisitados.remove(nodoAtual);
	        
	        //para cada nodo adjacente ao nodo atual
	        for (Entry <Nodo, Integer> adjacente: nodoAtual.getNodosAdjacentes().entrySet()) {
	            
	        	Nodo nodoAdjacente = adjacente.getKey();
	            Integer pesoAresta = adjacente.getValue();
	            
	            //se o nodo adjacente ainda nao foi visitado
	            if (!visitados.contains(nodoAdjacente)) {
	            	calculaDistanciaMinima(nodoAdjacente, pesoAresta, nodoAtual);
	            	naoVisitados.add(nodoAdjacente);
	            }
	        }
	        visitados.add(nodoAtual);
	    }
	}
	
	/**
	 * Pega o nodo de menor distancia dentre os nodos nao visitados
	 * @param naoVisitados
	 * @return
	 */
	private static Nodo buscaNodoDeMenorDistancia(Set<Nodo> naoVisitados) {
	    
		Nodo maisProximo = null;
	    int menorDistancia = Integer.MAX_VALUE;
	    
	    for (Nodo nodo: naoVisitados) {
	        if (nodo.getDistancia() < menorDistancia) {
	        	menorDistancia = nodo.getDistancia();
	        	maisProximo = nodo;
	        }
	    }
	    return maisProximo;
	}
	
	/**
	 * Metodo que calcula a distancia minima da origem aos nodos adjacentes do nodo atual <br>
	 * Este metodo verifica a distancia já armazenada no nodo adjacente com a distancia <br>
	 * do nodo atual + aresta
	 * 
	 * @param nodoAdjacente nodo adjacente ao nodo atual
	 * @param pesoAresta peso da aresta ao nodo adjacente
	 * @param nodoAtual nodo atual
	 */
	private static void calculaDistanciaMinima(Nodo nodoAdjacente, Integer pesoAresta, Nodo nodoAtual) {
	    
		Integer distanciaDoInicio = nodoAtual.getDistancia();
	    
		//se a distancia do inicio ao nodo atual + aresta é menor do que a distancia já calculada no nodo adjacente
	    if ( distanciaDoInicio + pesoAresta < nodoAdjacente.getDistancia() ) {
	    	
	    	//seta a distancia do nodo adjacente ate a origem
	    	nodoAdjacente.setDistancia(distanciaDoInicio + pesoAresta);
	    	
	    	//seta o caminho mais curto do nodo ajacente
	        LinkedList<Nodo> caminhoMaisCurto = new LinkedList<>(nodoAtual.getCaminhoMaisCurto());
	        caminhoMaisCurto.add(nodoAtual);
	        nodoAdjacente.setCaminhoMaisCurto(caminhoMaisCurto);
	    }
	}
	

}
