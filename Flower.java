class Flower extends Plant{
    private boolean hasSmell;
    private boolean hasThorn;

    public Flower() {

    }
    public Flower(String n, String c, boolean smell, boolean thorn) {
        super(n,c);
        hasSmell = smell;
        hasThorn = thorn;
    }
    public boolean isHasSmell() {
        return hasSmell;
    }
    public void setHasSmell(boolean smell) {
        hasSmell = smell;
    }
    public boolean isHasThorn() {
        return hasThorn;
    }
    public void setHasThorn(boolean thorn) {
        hasThorn = thorn;
    }

    public String toString() {
        return "Flower [hasSmell=" + hasSmell + ", hasThorn=" + hasThorn + "]";
    }
}