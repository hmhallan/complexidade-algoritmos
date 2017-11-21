package algoritmos;

import java.util.Iterator;
import java.util.List;

import pojo.Aresta;
import pojo.Grafo;
import pojo.Nodo;

public class Kruskal {

	public static Grafo obterArvoreGeradoraMinima(Grafo grafo) {

		Grafo arvoreResultante = new Grafo();
		
		System.out.println("Calculando AGM-Kruskal");
		for(Nodo nodo: grafo.getNodos()){
			makeSet(nodo);
		}
		
		List<Aresta> arestasOrdenadas = grafo.ordenarArestasPorPeso();
		
		for(Aresta aresta: arestasOrdenadas){
			
			System.out.println("Aresta selecionada: " + aresta.toString());
			String idRepresentanteConjuntoNodoOrigem = findSet(aresta.getNodoOrigem());
			String idRepresentanteSetNodoDestino = findSet(aresta.getNodoDestino());
			
			if(!idRepresentanteConjuntoNodoOrigem.equals(idRepresentanteSetNodoDestino)){
				System.out.println("Aresta adicionada à árvore geradora mínima: " + aresta.toString());
				arvoreResultante.addAresta(aresta);
				
				union(grafo.getNodos(),aresta.getNodoOrigem(), aresta.getNodoDestino());
			}
		}
		
		System.out.println("Fim AGM-Kruskal");
		
		return arvoreResultante;
		
	}

	private static void makeSet(Nodo nodo) {
		nodo.setNomeRepresentanteConjuntoAlgoritmoKruskal(nodo.getNome());
	}
	private static void union(List<Nodo> nodos, Nodo nodoOrigem, Nodo nodoDestino) {
		System.out.println("****** Union (" +  nodoOrigem.toString() + "," + nodoDestino.toString() + ": " + nodoDestino.getNomeRepresentanteConjuntoAlgoritmoKruskal() + ")");
		
		Iterator<Nodo> iteratorNodos = nodos.iterator();
		String representanteOrigem = nodoOrigem.getNomeRepresentanteConjuntoAlgoritmoKruskal();
		while(iteratorNodos.hasNext()){
			Nodo n = iteratorNodos.next();
			if(n.getNomeRepresentanteConjuntoAlgoritmoKruskal().equals(representanteOrigem)){
				n.setNomeRepresentanteConjuntoAlgoritmoKruskal(nodoDestino.getNomeRepresentanteConjuntoAlgoritmoKruskal());
			}
		}
	}

	private static String findSet(Nodo nodo) {
		return nodo.getNomeRepresentanteConjuntoAlgoritmoKruskal();
	}
}
