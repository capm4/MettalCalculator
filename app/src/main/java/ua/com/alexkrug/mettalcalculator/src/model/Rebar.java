package ua.com.alexkrug.mettalcalculator.src.model;


public class Rebar {
	private Double weight;
	private Double radius;
	private Double metersInTone;

	public Rebar() {
	}

	public Rebar(Double radius,  Double metersInTone, Double weight) {
		this.weight = weight;
		this.radius = radius;
		this.metersInTone = metersInTone;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getMetersInTone() {
		return metersInTone;
	}

	public void setMetersInTone(Double metersInTone) {
		this.metersInTone = metersInTone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rebar)) return false;

		Rebar rebar = (Rebar) o;

		if (weight != null ? !weight.equals(rebar.weight) : rebar.weight != null) return false;
		if (radius != null ? !radius.equals(rebar.radius) : rebar.radius != null) return false;
		return metersInTone != null ? metersInTone.equals(rebar.metersInTone) : rebar.metersInTone == null;
	}

	@Override
	public int hashCode() {
		int result = weight != null ? weight.hashCode() : 0;
		result = 31 * result + (radius != null ? radius.hashCode() : 0);
		result = 31 * result + (metersInTone != null ? metersInTone.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Rebar{" +
				"weight=" + weight +
				", radius=" + radius +
				", metersInTone=" + metersInTone +
				'}';
	}
}
