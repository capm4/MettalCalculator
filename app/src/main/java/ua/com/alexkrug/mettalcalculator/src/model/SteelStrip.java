package ua.com.alexkrug.mettalcalculator.src.model;


public class SteelStrip {
	private Double width;
	private Double thickness;
	private Double weight;
	private Double metersInTone;

	public SteelStrip() {
	}

	public SteelStrip(Double width, Double thickness, Double weight, Double metersInTone) {
		this.width = width;
		this.thickness = thickness;
		this.weight = weight;
		this.metersInTone = metersInTone;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getThickness() {
		return thickness;
	}

	public void setThickness(Double thickness) {
		this.thickness = thickness;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
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
		if (!(o instanceof SteelStrip)) return false;

		SteelStrip that = (SteelStrip) o;

		if (width != null ? !width.equals(that.width) : that.width != null) return false;
		if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
		if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
		return metersInTone != null ? metersInTone.equals(that.metersInTone) : that.metersInTone == null;
	}

	@Override
	public int hashCode() {
		int result = width != null ? width.hashCode() : 0;
		result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
		result = 31 * result + (weight != null ? weight.hashCode() : 0);
		result = 31 * result + (metersInTone != null ? metersInTone.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "SteelStrip{" +
				"width=" + width +
				", thickness=" + thickness +
				", weight=" + weight +
				", metersInTone=" + metersInTone +
				'}';
	}
}
