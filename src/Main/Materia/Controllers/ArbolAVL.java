package Main.Materia.Controllers;

import Main.Materia.Models.Node;

public class ArbolAVL {
    
    private Node root;

    public void insert(int value){
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value){
        if(nodo == null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }
        if(value < nodo.getValue()){
            nodo.setLeft(insert(nodo.getLeft(), value));
        }
        else if(value > nodo.getValue()){
            nodo.setRight(insert(nodo.getRight(),value));
        }else{
            return nodo;
        }
        nodo.setHeight(1 + Math.max(height(nodo.getLeft()),height(nodo.getRight())));
        

        ///Obtener  el balance o factor de equilibrio del nodo ancestro
        int balance = getBalance(nodo);

        System.out.println("-Nodo actual: " + nodo.getValue());
        System.out.println("    Altura del nodo: " + nodo.getValue() +  " es= " + nodo.getHeight());
        System.out.println("    Equilibrio del nodo: " + nodo.getValue() + " es= " + balance);

        //Caso Izquierda-Izquierda
        if(balance > 1 && value < nodo.getLeft().getValue()){
            return rightRotate(nodo);
        }
        //Caso Derecha-Derecha
        if(balance < -1 && value > nodo.getRight().getValue()){
            return leftRotate(nodo);
        }
        //Caso Izquierda-Derecha
        if(balance > 1 && value > nodo.getLeft().getValue()){
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);
        }
        //Caso Derecha-Izquierda
        if(balance < -1 && value < nodo.getRight().getValue()){
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }
        //Devolvemos el nodo sin cambios

        return nodo;

    }

    //Rotacion a la Derecha
    private Node rightRotate(Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotamos derecha el nodo: " + y.getValue() + ", Balance: " + getBalance(y));

        //Realizamos la rotacion
        x.setRight(y);
        y.setLeft(temp);

        //Actualizar las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())));

        System.out.println("Nueva raiz despues de rotaciones:" + x.getValue());

        return x;
    }
    //Rotacion Izquierda
    private Node leftRotate(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();

        //Imprimir informacion antes de la rotacion
        System.out.println("left Rotate on mode: " + x.getValue() + ", Balance: " + getBalance(x));
        //Realizar rotacion 
        y.setLeft(x);
        x.setRight(temp);
        //Actualizar alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        //Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de rotacion izq: " + y.getValue());

        return y;
    }

    private int height(Node node){
        if(node == null){
            return 0;
        }
        return node.getHeight();
    }


    private int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }
    public void printTree(){
        printTree(root, " ", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            // Imprimir el nodo actual
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            
            // Imprimir los hijos si existen, o 'null' si no
            if (node.getLeft() != null || node.getRight() != null) {
                // Imprimir el hijo izquierdo si existe
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "    "), true);
                } else {
                    // Imprimir 'null' cuando el hijo izquierdo no existe
                    System.out.println(prefix + (isLeft ? "|   " : "    ") + "├──null");
                }

                // Imprimir el hijo derecho si existe
                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "    "), false);
                } else {
                    // Imprimir 'null' cuando el hijo derecho no existe
                    System.out.println(prefix + (isLeft ? "|   " : "    ") + "└──null");
                }
            }
        }
    }

}
