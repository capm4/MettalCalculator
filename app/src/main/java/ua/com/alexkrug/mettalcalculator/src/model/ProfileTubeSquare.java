package ua.com.alexkrug.mettalcalculator.src.model;


public class ProfileTubeSquare {
	private Double weight;
	private Double width;
	private Double thickness;
	private Double metersInTone;

	public ProfileTubeSquare() {
	}

	public ProfileTubeSquare(Double width, Double thickness, Double metersInTone, Double weight) {
		this.weight = weight;
		this.width = width;
		this.thickness = thickness;
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

	public Double getMetersInTone() {
		return metersInTone;
	}

	public void setMetersInTone(Double metersInTone) {
		this.metersInTone = metersInTone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProfileTubeSquare)) return false;

		ProfileTubeSquare that = (ProfileTubeSquare) o;

		if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
		if (width != null ? !width.equals(that.width) : that.width != null) return false;
		if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
		return metersInTone != null ? metersInTone.equals(that.metersInTone) : that.metersInTone == null;
	}

	@Override
	public int hashCode() {
		int result = weight != null ? weight.hashCode() : 0;
		result = 31 * result + (width != null ? width.hashCode() : 0);
		result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
		result = 31 * result + (metersInTone != null ? metersInTone.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ProfileTubeSquare{" +
				"weight=" + weight +
				", width=" + width +
				", thickness=" + thickness +
				", metersInTone=" + metersInTone +
				'}';
	}
}
