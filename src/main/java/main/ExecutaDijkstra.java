package main;

import algoritmos.verbose.DijkstraVerbose;
import pojo.Aresta;
import pojo.Grafo;
import pojo.Nodo;

public class ExecutaDijkstra {

	public static void main(String[] args) {

		/**						 A
		 * 					 /	     \
		 * 					/    	  \
		 * 			 	   1   	       2
		 * 			 	  /			    \
		 * 			 	 /		 	     \
		 * 			    B		  	  	  C ------ 9 G
		 * 			   / \		 	   /	\
		 *            3   1     	  2   	 5
		 *           /     \	      |	      \	  
		 *          D       E---1---- F		   H
		 */

		// cria os nodos
		Nodo a = new Nodo("A");
		Nodo b = new Nodo("B");
		Nodo c = new Nodo("C");
		Nodo d = new Nodo("D");
		Nodo e = new Nodo("E");
		Nodo f = new Nodo("F");
		Nodo g = new Nodo("G");
		Nodo h = new Nodo("H");

		// cria as arestas
		Aresta a1 = new Aresta(a, b, 1);
		Aresta a2 = new Aresta(a, c, 2);
		Aresta a3 = new Aresta(b, d, 3);
		Aresta a4 = new Aresta(b, e, 1);
		Aresta a5 = new Aresta(c, f, 2);
		Aresta a6 = new Aresta(c, g, 9);
		Aresta a7 = new Aresta(c, h, 5);
		Aresta a8 = new Aresta(e, f, 1);

		// a.addDestino(b, 1);
		// a.addDestino(c, 2);
		// b.addDestino(d, 3);
		// b.addDestino(e, 1);
		// c.addDestino(f, 2);
		// c.addDestino(g, 9);
		// c.addDestino(h, 5);
		// e.addDestino(f, 1);

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

		grafo.addAresta(a1);
		grafo.addAresta(a2);
		grafo.addAresta(a3);
		grafo.addAresta(a4);
		grafo.addAresta(a5);
		grafo.addAresta(a6);
		grafo.addAresta(a7);
		grafo.addAresta(a8);

		DijkstraVerbose.calculaCaminhoMaisCurtoDeUmNodoInicial(grafo, a);

		System.out.println(a.escreveCaminho());
		System.out.println(b.escreveCaminho());
		System.out.println(c.escreveCaminho());
		System.out.println(d.escreveCaminho());
		System.out.println(e.escreveCaminho());
		System.out.println(f.escreveCaminho());
		System.out.println(g.escreveCaminho());
		System.out.println(h.escreveCaminho());
	}

}
