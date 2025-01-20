import Main.Ejercicio_03_listLevels.ListLevels;
import Main.Materia.Controllers.ArbolAVL;
import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorridos;
import Main.Materia.Controllers.Graph;
import Main.Materia.Models.NodeG;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //runArbolBinario();
        //runEjercicio3();
        //runArbolAVL();
        runGraph();
                    }          
        
            private static void runEjercicio3() {
            ArbolBinario arbolBinario= new ArbolBinario();
            ListLevels levels = new ListLevels();

            ArbolRecorridos arbolRecorridos = new ArbolRecorridos();
            int[] valores = {1,2,3,4,5,6,7,9};
         
            for(int i = 0;i < valores.length; i++){
                arbolBinario.insert(valores[i]);
            }
            arbolBinario.printTree();
            //lista = levels.listLevels(arbolBinario.getRoot());
            }
        
    public static void runArbolBinario(){
        ArbolBinario arbolBinario= new ArbolBinario();

         ArbolRecorridos arbolRecorridos = new ArbolRecorridos();
         int[] valores = {40,20,60,10,30,50,70,5,15,55};
         

         for(int value : valores)
         arbolBinario.insert(value);
         arbolBinario.printTree();
         System.out.println("PreOrden Iterativo: ");
         arbolRecorridos.preOrderIterativo(arbolBinario.getRoot());
         System.out.println("\nPreOrden Recursivo: ");
         arbolRecorridos.PreOrdenRecursivo(arbolBinario.getRoot());
         System.out.println("\nPostOrden Recursivo: ");
         arbolRecorridos.PostOrdenRecursivo(arbolBinario.getRoot());
         System.out.println("\nInOrden Recursivo: ");
         arbolRecorridos.InOrdenRecursivo(arbolBinario.getRoot());
    }

    public static void runArbolAVL() {

        ArbolAVL arbolAVL = new ArbolAVL();
    
        int[] valores = {10, 20, 15, 24, 9, 21, 23, 50, 25};
    
        for (int value : valores) {
            arbolAVL.insert(value);
            arbolAVL.printTree();
        }
    }

    private static void runGraph() {
        Graph grafo = new Graph();

        NodeG node0 = grafo.addNode(0);
        NodeG node1 = grafo.addNode(1);
        NodeG node2 = grafo.addNode(2);
        NodeG node3 = grafo.addNode(3);
        NodeG node4 = grafo.addNode(4);
        NodeG node5 = grafo.addNode(5);
        NodeG node7 = grafo.addNode(7);
        NodeG node8 = grafo.addNode(8);
        NodeG node9 = grafo.addNode(9);

        System.out.println("Grafo dirigido: ");

        grafo.addEdge(node3, node2);
        grafo.addEdge(node3, node4);
        grafo.addEdge(node4, node1);
        grafo.addEdge(node2, node1);
        grafo.addEdge(node1, node0);
        grafo.addEdge(node0, node5);
        grafo.addEdge(node0, node3);

        grafo.printGraph();

        grafo.getDFS(node0);
        grafo.getBFS(node0);

        System.out.println("\nGrafo no dirigido: ");
        grafo.addEdgeDos(node0, node5);
        grafo.addEdgeDos(node0, node3);
        grafo.addEdgeDos(node0, node1);
        grafo.addEdgeDos(node3, node2);
        grafo.addEdgeDos(node3, node4);
        grafo.addEdgeDos(node3, node7);
        grafo.addEdgeDos(node3, node9);
        grafo.addEdgeDos(node2, node1);
        grafo.addEdgeDos(node4, node1);
        grafo.addEdgeDos(node7, node8);
        grafo.addEdgeDos(node8, node1);
        grafo.addEdgeDos(node1, node0);

        grafo.printGraph();

        grafo.getDFS(node0);
        grafo.getBFS(node0);
    }
}
