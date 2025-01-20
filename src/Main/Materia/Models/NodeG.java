package Main.Materia.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeG {
    
    private int value;
    private List <NodeG> neighbors;

    public NodeG (int value){
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<NodeG> getNeighbors() {
        return neighbors;
    }

    public void addNeighbors(NodeG neighbors) {
        this.neighbors.add(neighbors);
    }

    public void setNeighbors(List<NodeG> neighbors) {
        this.neighbors = neighbors;
    }

}   
