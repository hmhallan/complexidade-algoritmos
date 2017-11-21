package pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {

	private List<Nodo> nodos;
	private Set<Aresta> arestas;

	public Grafo() {
		this.nodos = new ArrayList<>();
		this.arestas = new HashSet<>();
	}

	public void addNodo(Nodo nodo) {
		nodos.add(nodo);
	}

	public void addAresta(Aresta aresta) {
		arestas.add(aresta);
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	public Set<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(Set<Aresta> arestas) {
		this.arestas = arestas;
	}
	
	public List<Aresta> ordenarArestasPorPeso() {
		List<Aresta> lista = new ArrayList<>(arestas); 
		
		System.out.println("Arestas antes da ordenação");
		for (Aresta a: lista) {
			System.out.println(a.toString());
		}
		System.out.println("===========================");
				
		Collections.sort(lista, new Comparator<Aresta>() {
			@Override
			public int compare(Aresta a1, Aresta a2) {
				int resultado = 0;
				if(a1.getPeso() > a2.getPeso()){
					resultado = 1;
				}else if(a1.getPeso() < a2.getPeso()){
					resultado = -1;
				}
				return resultado;
			}
		});
		
		System.out.println("Arestas ordenadas por peso");
		for (Aresta a: lista) {
			System.out.println(a.toString());
		}
		System.out.println("===========================");
		
		return lista;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Arestas: \n");
		for(Aresta a: this.getArestas()){
			sb.append(a.toString() + "\n");
		}
			
		return sb.toString();
	}
	
	public String toStringNodos() {
		StringBuilder sb = new StringBuilder();
		for(Nodo n: this.getNodos()){
			sb.append(n.toString() + "\n");
		}
			
		return sb.toString();
	}
	
	
}