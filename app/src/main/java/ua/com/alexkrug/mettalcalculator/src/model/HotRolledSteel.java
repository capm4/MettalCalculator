package ua.com.alexkrug.mettalcalculator.src.model;


public class HotRolledSteel {
	private Double weight;
	private Double width;
	private Double height;
	private Double thickness;

	public HotRolledSteel() {
	}

	public HotRolledSteel(Double thickness, Double weight, Double width, Double height) {
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.thickness = thickness;
	}

	@Override
	public String toString() {
		return "HotRolledSteel{" +
				"weight=" + weight +
				", width=" + width +
				", height=" + height +
				", thickness=" + thickness +
				'}';
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

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
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
		if (!(o instanceof HotRolledSteel)) return false;

		HotRolledSteel that = (HotRolledSteel) o;

		if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
		if (width != null ? !width.equals(that.width) : that.width != null) return false;
		if (height != null ? !height.equals(that.height) : that.height != null) return false;
		return thickness != null ? thickness.equals(that.thickness) : that.thickness == null;
	}

	@Override
	public int hashCode() {
		int result = weight != null ? weight.hashCode() : 0;
		result = 31 * result + (width != null ? width.hashCode() : 0);
		result = 31 * result + (height != null ? height.hashCode() : 0);
		result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
		return result;
	}

}
