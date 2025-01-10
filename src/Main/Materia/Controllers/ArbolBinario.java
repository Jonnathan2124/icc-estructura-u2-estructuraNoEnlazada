package Main.Materia.Controllers;

import Main.Materia.Models.Node;

public class ArbolBinario {

    private Node root;

    public void insert(int value){

        root = insert(root, value);
    }
    
    private Node insert (Node node, int value){

        if(node == null)
            return new Node(value);
        
        if(value < node.getValue()){
                node.setLeft(insert(node.getLeft(),value));
            }
        else if(value > node.getValue()){
                node.setRight(insert(node.getRight(),value));
            }
        return node;
    }

    public void printTree(){
        printTree(root, " ", true);
    }

    private void printTree(Node node, String prefix, boolean isleft){

        if(node != null){
            System.out.println(prefix + (isleft ? "├── " : "└── ") + node.getValue());
            if(node.getLeft() != null || node.getRight() != null){
                if(node.getLeft() != null){
                    printTree(node.getLeft(), prefix + (isleft ? "|  " : "   "), true);
                }else{
                    System.out.println(prefix + (isleft ? "| " : "├──null"));
                }

                if(node.getRight() != null){
                    printTree(node.getRight(), prefix + (isleft ? "|  " : "   "), false);
                }else{
                    System.out.println(prefix + (isleft ? "| " : "├──null"));
                }            
            }
        }
    }

    public void printTreeNode2(Node root, String prefix, boolean isleft){
        
    }

    public Node getRoot(){

        return root;
    }
}
