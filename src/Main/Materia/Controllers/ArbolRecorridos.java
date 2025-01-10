package Main.Materia.Controllers;

import java.util.Stack;

import Main.Materia.Models.Node;

public class ArbolRecorridos {
    public void preOrderIterativo(Node root){

        /// verificar si no esta vacio
        if(root == null){
            return;
        }
        /// Pila para manejar los nodos del arbol dirante el recorrido
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.getValue() + ", ");

            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
    }

    public void PreOrdenRecursivo(Node node){

        //Verificar si el nodo esta vacio
        if(node != null){
            //Imprimir el valor actual
            System.out.print(node.getValue() + ", ");
            PreOrdenRecursivo(node.getLeft());
            PreOrdenRecursivo(node.getRight());
        }
    }

    public void PostOrdenRecursivo(Node node){

        //Verificar si el nodo esta vacio
        if(node != null){
            //Imprimir el valor actual
            PostOrdenRecursivo(node.getLeft());
            PostOrdenRecursivo(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void InOrdenRecursivo(Node node){

        //Verificar si el nodo esta vacio
        if(node != null){
            //Imprimir el valor actual
            InOrdenRecursivo(node.getLeft());
            System.out.print(node.getValue() + ", ");
            InOrdenRecursivo(node.getRight());
        }
    }
}
