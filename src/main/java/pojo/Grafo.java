package pojo;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private Set<Nodo> nodos;
	private Set<Aresta> arestas;

	public Grafo() {
		this.nodos = new HashSet<>();
		this.arestas = new HashSet<>();
	}

	public void addNodo(Nodo nodo) {
		nodos.add(nodo);
	}

	public void addAresta(Aresta aresta) {
		arestas.add(aresta);
	}

	public Set<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(Set<Nodo> nodos) {
		this.nodos = nodos;
	}

	public Set<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(Set<Aresta> arestas) {
		this.arestas = arestas;
	}
	
	public void ordenarArestasPorPeso() {
		//TODO em desenvolvimento
	}
}