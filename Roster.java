public class Roster {
    private String teamName;
    private String PG;
    private String SG;
    private String SF;
    private String PF;
    private String C;

    public Roster(String teamName, String PG, String SG, String SF, String PF, String C) {
        this.teamName = teamName;
        this.PG = PG;
        this.SG = SG;
        this.SF = SF;
        this.PF = PF;
        this.C = C;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPG() {
        return PG;
    }

    public void setPG(String PG) {
        this.PG = PG;
    }

    public String getSG() {
        return SG;
    }

    public void setSG(String SG) {
        this.SG = SG;
    }

    public String getSF() {
        return SF;
    }

    public void setSF(String SF) {
        this.SF = SF;
    }

    public String getPF() {
        return PF;
    }

    public void setPF(String PF) {
        this.PF = PF;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String toString() {  // how it appears on the listView selection
        return teamName;
    }
}