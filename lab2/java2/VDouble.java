public class VDouble extends Value {
  public Double value;
  public VDouble (Double d) { value = d; }
  public boolean equals(Object o) {
    return (o instanceof VDouble) && this.value.equals(((VDouble)o).value);
  }
}
