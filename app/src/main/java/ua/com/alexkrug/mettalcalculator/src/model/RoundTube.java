package ua.com.alexkrug.mettalcalculator.src.model;


public class RoundTube {
	private Double weight;
	private Double radius;
	private Double thickness;
	private Double metersInTone;

	public RoundTube() {
	}

	public RoundTube(Double radius, Double thickness, Double weight, Double metersInTone) {
		this.weight = weight;
		this.radius = radius;
		this.thickness = thickness;
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

	public Double getThickness() {
		return thickness;
	}

	public void setThickness(Double thickness) {
		this.thickness = thickness;
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
		if (!(o instanceof RoundTube)) return false;

		RoundTube roundTube = (RoundTube) o;

		if (weight != null ? !weight.equals(roundTube.weight) : roundTube.weight != null) return false;
		if (radius != null ? !radius.equals(roundTube.radius) : roundTube.radius != null) return false;
		if (thickness != null ? !thickness.equals(roundTube.thickness) : roundTube.thickness != null) return false;
		return metersInTone != null ? metersInTone.equals(roundTube.metersInTone) : roundTube.metersInTone == null;
	}

	@Override
	public int hashCode() {
		int result = weight != null ? weight.hashCode() : 0;
		result = 31 * result + (radius != null ? radius.hashCode() : 0);
		result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
		result = 31 * result + (metersInTone != null ? metersInTone.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "RoundTube{" +
				"weight=" + weight +
				", radius=" + radius +
				", thickness=" + thickness +
				", metersInTone=" + metersInTone +
				'}';
	}
}
