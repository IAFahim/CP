class Plant{
    private String name = "N/A";
    private String color = "N/A";
    public Plant() {

    }
    public Plant(String n, String c) {
        name = n;
        color = c;
    }
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String c) {
        color = c;
    }
    public String toString() {
        return "Plant [name=" + name + ", color=" + color + "]";
    }
}