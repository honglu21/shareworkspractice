import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PlaySports implements Serializable {
    private static final long serialVersionUID = 1L;
    String sport;
    List<Sports> mySports;
    String name;

    public PlaySports() {
        mySports = new LinkedList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Sports getMySport(int index) {
        return mySports.get(index);
    }

    public List<Sports> getMySports() {
        return this.mySports;
    }

    public void addMySports(Sports sport) {
        mySports.add(sport);
    }

    public List<Sports> removeMySports(Sports sport) {
        mySports.remove(sport);
        return mySports;
    }
}
