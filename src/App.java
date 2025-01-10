import Main.Ejercicio_03_listLevels.ListLevels;
import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorridos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        runArbolBinario();
        runEjercicio3();
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
            lista = levels.listLevels(arbolBinario.getRoot());
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


}
