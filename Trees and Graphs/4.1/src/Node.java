
import java.util.ArrayList;
import java.util.List;


class Node {

    public String name;
    public boolean isVisited;
    public List<Node> children;

    public Node(String name, List<Node> children) {
        this.name = name;
        isVisited=false;
        this.children = children;
    }

    public Node(String name) {
        this(name,new ArrayList<Node>());
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
    
    public void addChild(Node n)
    {
        children.add(n);
    }
    
    
}
