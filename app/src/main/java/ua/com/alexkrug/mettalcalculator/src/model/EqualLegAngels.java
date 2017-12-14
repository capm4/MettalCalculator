package ua.com.alexkrug.mettalcalculator.src.model;


public class EqualLegAngels {
	private Double weight;
	private Double width;
	private Double thickness;
	private Double innerRadius;
	private Double shelfRoundingRadius;
	private Double metersInTone;

	public EqualLegAngels() {
	}


	public EqualLegAngels(Double width,Double thickness, Double innerRadius, Double shelfRoundingRadius, Double metersInTone, Double weight) {
		this.weight = weight;
		this.width = width;
		this.thickness = thickness;
		this.innerRadius = innerRadius;
		this.shelfRoundingRadius = shelfRoundingRadius;
		this.metersInTone = metersInTone;
	}

	public Double getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(Double innerRadius) {
		this.innerRadius = innerRadius;
	}

	public Double getShelfRoundingRadius() {
		return shelfRoundingRadius;
	}

	public void setShelfRoundingRadius(Double shelfRoundingRadius) {
		this.shelfRoundingRadius = shelfRoundingRadius;
	}

	public Double getMetersInTone() {
		return metersInTone;
	}

	public void setMetersInTone(Double metersInTone) {
		this.metersInTone = metersInTone;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof EqualLegAngels)) return false;

		EqualLegAngels that = (EqualLegAngels) o;

		if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
		if (width != null ? !width.equals(that.width) : that.width != null) return false;
		if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
		if (innerRadius != null ? !innerRadius.equals(that.innerRadius) : that.innerRadius != null) return false;
		if (shelfRoundingRadius != null ? !shelfRoundingRadius.equals(that.shelfRoundingRadius) : that.shelfRoundingRadius != null)
			return false;
		return metersInTone != null ? metersInTone.equals(that.metersInTone) : that.metersInTone == null;
	}

	@Override
	public int hashCode() {
		int result = weight != null ? weight.hashCode() : 0;
		result = 31 * result + (width != null ? width.hashCode() : 0);
		result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
		result = 31 * result + (innerRadius != null ? innerRadius.hashCode() : 0);
		result = 31 * result + (shelfRoundingRadius != null ? shelfRoundingRadius.hashCode() : 0);
		result = 31 * result + (metersInTone != null ? metersInTone.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "EqualLegAngels{" +
				"weight=" + weight +
				", width=" + width +
				", thickness=" + thickness +
				", innerRadius=" + innerRadius +
				", shelfRoundingRadius=" + shelfRoundingRadius +
				", metersInTone=" + metersInTone +
				'}';
	}
}
