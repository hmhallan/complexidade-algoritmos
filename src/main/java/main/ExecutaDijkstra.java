package main;

import algoritmos.Dijkstra;
import algoritmos.verbose.DijkstraVerbose;
import pojo.Grafo;
import pojo.Nodo;

public class ExecutaDijkstra {
	
	public static void main(String [] args){
		
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
		
		//cria os nodos
		Nodo a = new Nodo("A");
		Nodo b = new Nodo("B");
		Nodo c = new Nodo("C");
		Nodo d = new Nodo("D");
		Nodo e = new Nodo("E");
		Nodo f = new Nodo("F");
		Nodo g = new Nodo("G");
		Nodo h = new Nodo("H");

		//adiciona as arestas
		a.addDestino(b, 1);
		a.addDestino(c, 2);
		b.addDestino(d, 3);
		b.addDestino(e, 1);
		c.addDestino(f, 2);
		c.addDestino(g, 9);
		c.addDestino(h, 5);
		e.addDestino(f, 1);
		
		//cria o grafo
		Grafo grafo = new Grafo();
		grafo.addNodo(a);
		grafo.addNodo(b);
		grafo.addNodo(c);
		grafo.addNodo(d);
		grafo.addNodo(e);
		grafo.addNodo(f);
		grafo.addNodo(g);
		grafo.addNodo(h);
		
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
