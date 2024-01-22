public class TripleInteger {
    private Integer weight;
    private Integer source;
    private Integer dest;

    public TripleInteger(Integer w, Integer s, Integer d) {
        weight = w;
        source = s;
        dest = d;
    }

    public Integer getDest() {
        return dest;
    }
    public Integer getSource() {
        return source;
    }
    public Integer getWeight() {
        return weight;
    }

    public void setDest(Integer dest) {
        this.dest = dest;
    }
    public void setSource(Integer source) {
        this.source = source;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return weight + " " + source + " " + dest;
    }
}
