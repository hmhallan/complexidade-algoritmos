package algoritmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.Aresta;
import pojo.Grafo;
import pojo.Nodo;

public class Prim {
	
	//Key[v]: menor peso de qualquer aresta ligando v a algum vértice da árvore
	private static HashMap<Nodo, Integer> key = new HashMap<>();
	private static HashMap<Nodo, Nodo> pai = new HashMap<>();
	
	public static Grafo obterArvoreGeradoraMinima(Grafo grafo, Nodo raiz) {
		
		//TODO ainda está com erros...
		
		Grafo arvoreResultante = new Grafo();
		System.out.println("Calculando AGM-Prim");
		for(Nodo nodo: grafo.getNodos()){
			key.put(nodo, Integer.MAX_VALUE);//simulando o valor infinito
			pai.put(nodo, null);
		}
		
		key.put(raiz, 0);
		
		List<Nodo> filaQ = new ArrayList<>(grafo.getNodos());
		
		while(!filaQ.isEmpty()){
			Nodo u = extractMin(filaQ);
			
			arvoreResultante.addNodo(u);
			
			Map<Nodo, Integer> adjacentesU = u.getNodosAdjacentes();
			for(Nodo v: adjacentesU.keySet()){
				if(filaQ.contains(v) && adjacentesU.get(v) < key.get(v)){
					pai.put(v, u);
					key.put(v, adjacentesU.get(v));
					
					Aresta a = new Aresta(u, v, adjacentesU.get(v));
					arvoreResultante.addAresta(a);
				}
			}
		}
		
		System.out.println("Fim AGM-Prim");
		
		return arvoreResultante;
		
	}

	private static Nodo extractMin(List<Nodo> filaQ) {
		
		Nodo nodoMenorPeso = null;
		int menorPeso = Integer.MAX_VALUE;
		Integer pesoNodo;
		for(Nodo nodo: filaQ){
			pesoNodo = key.get(nodo);
			if(key.get(nodo) < menorPeso){
				menorPeso = pesoNodo;
				nodoMenorPeso = nodo;
			}
		}
		filaQ.remove(nodoMenorPeso);
		
		return nodoMenorPeso;
	}
}