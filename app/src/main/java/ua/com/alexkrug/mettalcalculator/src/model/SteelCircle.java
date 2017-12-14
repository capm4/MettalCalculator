package ua.com.alexkrug.mettalcalculator.src.model;


public class SteelCircle {
	private Double weight;
	private Double radius;
	private Double metersInTone;

	public SteelCircle() {
	}

	public SteelCircle(Double weight, Double radius, Double metersInTone) {
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
		if (!(o instanceof SteelCircle)) return false;

		SteelCircle that = (SteelCircle) o;

		if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
		if (radius != null ? !radius.equals(that.radius) : that.radius != null) return false;
		return metersInTone != null ? metersInTone.equals(that.metersInTone) : that.metersInTone == null;
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
		return "SteelCircle{" +
				"weight=" + weight +
				", radius=" + radius +
				", metersInTone=" + metersInTone +
				'}';
	}
}