public class IntegerTriple {
    private Integer source;
    private Integer weight;
    private Integer dest;

    public IntegerTriple(Integer w, Integer s, Integer d) {
        source = s;
        weight = w;
        dest = d;
    }

    public Integer getSource() {
        return source;
    }

    public Integer getDest() {
        return dest;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return weight + " " + source + " " + dest;
    }
}
