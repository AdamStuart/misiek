package main;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import mappers.IDMapper;
import structs.model.Family;
import structs.model.GroupNode;
import structs.model.PPINetwork;
import structs.model.PPINetworkProjection;
import structs.model.Protein;
import structs.model.ProteinProjection;

public class DataHandle {

    private static IDMapper networkIDMapper = new IDMapper();
    private static IDMapper projectionsIDMapper = new IDMapper();
    private static Map<String, PPINetworkProjection> projections = new HashMap<String, PPINetworkProjection>();
    private static Map<String, PPINetwork> networks = new HashMap<String, PPINetwork>();
    private static Map<String, Family> families = new HashMap<String, Family>();
    private static PPINetwork rootNetwork;

    public static GroupNode createGroupNode(String groupNodeID, Protein motherProtein) {
        GroupNode node = new GroupNode(groupNodeID, motherProtein);
        return node;
    }

    public static PPINetworkProjection createProjectionNetwork(String ProjectionID, PPINetwork motherNetwork) {
        PPINetworkProjection projection = new PPINetworkProjection(ProjectionID, motherNetwork);
        projections.put(ProjectionID, projection);
        return projection;
    }

    public static ProteinProjection createProteinProjection(String ProteinProjectionID, Protein motherProtein, Protein protein, PPINetworkProjection projection) {
        ProteinProjection proteinProjection = new ProteinProjection(ProteinProjectionID, protein, motherProtein);
        projection.addProteinProjection(proteinProjection);
        return proteinProjection;
    }

    public static void createRootPPINetwork(String NetworkID) {
        PPINetwork net = new PPINetwork(NetworkID, null);
        networks.put(NetworkID, net);
        rootNetwork = net;
    }

    public static void createPPINetwork(String NetworkID, String ParentNetworkID) {
        //   if (!networks.containsKey(NetworkID)) {
        PPINetwork ParentNetwork = networks.get(ParentNetworkID);
        PPINetwork net = new PPINetwork(NetworkID, ParentNetwork);
        ParentNetwork.getContext().addChild(net);
        networks.put(NetworkID, net);
    }

    public static void createFamily(String FamilyID, Color color) {
        //  if (!families.containsKey(FamilyID)) {
        Family fam = new Family(FamilyID, color);
        families.put(FamilyID, fam);
    }

    public static void createProtein(String ProteinID, String ParentProteinID, String NetworkID, String FamilyID) {
        PPINetwork network = networks.get(NetworkID);
        PPINetwork ParentNetwork = network.getContext().getParentNetwork();
        Protein ParentProtein = ParentNetwork.getProteins().get(ParentProteinID);
        Family family = families.get(FamilyID);
        network.addProtein(ProteinID, ParentProtein, family);
    }

    public static void createRootProtein(String ProteinID, String NetworkID, String FamilyID) {
        PPINetwork network = networks.get(NetworkID);
        Family family = families.get(FamilyID);
        network.addRootProtein(ProteinID, family);
    }

    public static void createInteraction(String ID, String NetworkID, String SourceID, String TargetID, Double Probability) {
        PPINetwork network = networks.get(NetworkID);

        network.addInteraction(ID, SourceID, TargetID, Probability);
    }

    public static PPINetwork findNetworkByCytoID(String PPINetworkCytoID) {

        String PPINetworkID = networkIDMapper.getIDByCytoID(PPINetworkCytoID);
        return networks.get(PPINetworkID);
    }

    public static PPINetworkProjection findProjectionByCytoID(String PPINetworkProjectionCytoID) {

        String PPINetworkProjectionID = projectionsIDMapper.getIDByCytoID(PPINetworkProjectionCytoID);
        return projections.get(PPINetworkProjectionID);
    }

    public static void addProjectionIDMapping(String CytoID, String ID) {
        projectionsIDMapper.addMapping(CytoID, ID);
    }

    public static void addNetworkIDMapping(String CytoID, String ID) {
        networkIDMapper.addMapping(CytoID, ID);
    }

    public static Map<String, PPINetwork> getNetworks() {
        return networks;
    }

    public static void setNetworks(Map<String, PPINetwork> nets) {
        networks = nets;
    }

    public static Map<String, Family> getFamilies() {
        return families;
    }

    public static void setFamilies(Map<String, Family> families) {
        DataHandle.families = families;
    }

    public static IDMapper getNetworkIDMapper() {
        return networkIDMapper;
    }

    public static void setNetworkIDMapper(IDMapper networkIDMapper) {
        DataHandle.networkIDMapper = networkIDMapper;
    }

    public static Map<String, PPINetworkProjection> getProjections() {
        return projections;
    }

    public static void setProjections(Map<String, PPINetworkProjection> projections) {
        DataHandle.projections = projections;
    }

    public static IDMapper getProjectionsIDMapper() {
        return projectionsIDMapper;
    }

    public static void setProjectionsIDMapper(IDMapper projectionsIDMapper) {
        DataHandle.projectionsIDMapper = projectionsIDMapper;
    }

    public static PPINetwork getRootNetwork() {
        return rootNetwork;
    }

    public static void setRootNetwork(PPINetwork rootNetwork) {
        DataHandle.rootNetwork = rootNetwork;
    }
}
