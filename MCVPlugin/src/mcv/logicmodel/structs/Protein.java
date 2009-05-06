package mcv.logicmodel.structs;

import mcv.logicmodel.structs.ProjectorInfo;

public class Protein {

    private String ID;
    private Family family;
    private ProteinContext context;
    private ProjectorInfo projects;

    public Protein(String ID, PPINetwork Network, Family fam) {
        this.ID = ID;
        this.family = fam;
        this.context = new ProteinContext(Network, null);
        this.projects = new ProjectorInfo();
    }

    public Protein(String ID, Protein ParentProtein, PPINetwork Network, Family fam) {
        this.ID = ID;
        this.family = fam;
        this.context = new ProteinContext(Network, ParentProtein);
        this.projects = new ProjectorInfo();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ProteinContext getContext() {
        return context;
    }

    public void setContext(ProteinContext context) {
        this.context = context;
    }

    public Family getFamily() {
        return this.family;
    }

    public void setFamily(Family Family) {
        this.family = Family;
    }

    public ProjectorInfo getProjects() {
        return projects;
    }

    public void setProjects(ProjectorInfo projects) {
        this.projects = projects;
    }
}
