package structs;

public class GroupNode {

    private String ID;
    private GroupNodeContext context;

    public GroupNode(String ID, Protein motherProtein) {
        this.ID = ID;
        this.context = new GroupNodeContext(motherProtein);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public GroupNodeContext getContext() {
        return context;
    }

    public void setContext(GroupNodeContext context) {
        this.context = context;
    }
}
