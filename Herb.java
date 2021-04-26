class Herb extends Plant{
    private boolean isMedicinal;
    private String Season;

    public Herb() {

    }
    public Herb(String n, String c, boolean medicinal, String season) {
        super(n,c);
        isMedicinal = medicinal;
        Season = season;
    }
    public boolean getisMedicinal() {
        return isMedicinal;
    }
    public void setMedicinal(boolean medicinal) {
        isMedicinal = medicinal;
    }
    public String getSeason() {
        return Season;
    }
    public void setSeason(String season) {
        Season = season;
    }

    public String toString() {
        return "Herb [isMedicinal=" + isMedicinal + ", Season=" + Season + "]";
    }
}
