import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable { // marker interface -> means this can be clonable now

    private String ip;
    private String impData;
    private List<String> list;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImpData() {
        return impData;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(int idx, String val) {
        this.list.set(idx, val);
    }


    public void setImpData(String impData) {
        this.impData = impData;
    }

    public void loadImpData() {
        list = new ArrayList<>();
        list.add("vaibhav");
        list.add("Sky");
        list.add("Pratik");
        list.add("PP");

        this.impData = "Very Imp Data, takes time to load";
    }

    @Override
    public String toString() {
        return "NetworkConnection [ip=" + ip + ", impData=" + impData + "]" +" "+ list;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        

        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp(this.getIp());
        networkConnection.setImpData(this.getImpData());

        for (String d: this.getList()){
            networkConnection.getList().add(d);
        }
        return networkConnection;
        // return super.clone();
    }



}