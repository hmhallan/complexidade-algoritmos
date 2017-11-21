package main;

import algoritmos.Prim;
import pojo.Aresta;
import pojo.Grafo;
import pojo.Nodo;

public class ExecutaPrim {

	public static void main(String[] args) {

		//Grafo da aula 1020 (slides 65-79)

		// cria os nodos
		Nodo a = new Nodo("A");
		Nodo b = new Nodo("B");
		Nodo c = new Nodo("C");
		Nodo d = new Nodo("D");
		Nodo e = new Nodo("E");
		Nodo f = new Nodo("F");
		Nodo g = new Nodo("G");
		Nodo h = new Nodo("H");
		Nodo i = new Nodo("I");

		// cria as arestas
		Aresta a1 = new Aresta(a, b, 4);
		Aresta a2 = new Aresta(a, h, 8);
		Aresta a3 = new Aresta(b, h, 11);
		Aresta a4 = new Aresta(b, c, 8);
		Aresta a5 = new Aresta(c, i, 2);
		Aresta a6 = new Aresta(c, d, 7);
		Aresta a7 = new Aresta(c, f, 4);
		Aresta a8 = new Aresta(d, e, 9);
		Aresta a9 = new Aresta(d, f, 14);
		Aresta a10 = new Aresta(e, f, 10);
		Aresta a11 = new Aresta(f, g, 2);
		Aresta a12 = new Aresta(g, i, 6);
		Aresta a13 = new Aresta(g, h, 1);
		Aresta a14 = new Aresta(h, i, 7);
		
		// cria o grafo
		Grafo grafo = new Grafo();
		grafo.addNodo(a);
		grafo.addNodo(b);
		grafo.addNodo(c);
		grafo.addNodo(d);
		grafo.addNodo(e);
		grafo.addNodo(f);
		grafo.addNodo(g);
		grafo.addNodo(h);
		grafo.addNodo(i);

		grafo.addAresta(a1);
		grafo.addAresta(a2);
		grafo.addAresta(a3);
		grafo.addAresta(a4);
		grafo.addAresta(a5);
		grafo.addAresta(a6);
		grafo.addAresta(a7);
		grafo.addAresta(a8);
		grafo.addAresta(a9);
		grafo.addAresta(a10);
		grafo.addAresta(a11);
		grafo.addAresta(a12);
		grafo.addAresta(a13);
		grafo.addAresta(a14);

		Grafo arvoreGeradoraMinima = Prim.obterArvoreGeradoraMinima(grafo, a);
		
		System.err.println(arvoreGeradoraMinima.toString());
	}
}
