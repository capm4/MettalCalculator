package ua.com.alexkrug.mettalcalculator.src.model;


public class WireRod {
	private Double weight;
	private Double radius;
	private Double metersInTone;

	public WireRod() {
	}

	public WireRod(Double radius, Double weight, Double metersInTone) {
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
		if (!(o instanceof WireRod)) return false;

		WireRod wireRod = (WireRod) o;

		if (weight != null ? !weight.equals(wireRod.weight) : wireRod.weight != null) return false;
		if (radius != null ? !radius.equals(wireRod.radius) : wireRod.radius != null) return false;
		return metersInTone != null ? metersInTone.equals(wireRod.metersInTone) : wireRod.metersInTone == null;
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
		return "WireRod{" +
				"weight=" + weight +
				", radius=" + radius +
				", metersInTone=" + metersInTone +
				'}';
	}
}
