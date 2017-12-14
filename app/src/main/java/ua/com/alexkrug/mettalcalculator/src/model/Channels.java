package ua.com.alexkrug.mettalcalculator.src.model;


public class Channels {
	private Double weightOfMeter;
	private Double width;
	private Double height;
	private Double thickness;
	private Double shelfAverageThickness;
	private Double innerRadius;
	private Double shelfRoundingRadius;
	private Double metersInTone;
	private String number;

	public Channels() {
	}

	public Channels(String number, Double width, Double height, Double thickness, Double shelfAverageThickness, Double innerRadius, Double shelfRoundingRadius, Double metersInTone,  Double weightOfMeter) {
		this.weightOfMeter = weightOfMeter;
		this.width = width;
		this.height = height;
		this.thickness = thickness;
		this.shelfAverageThickness = shelfAverageThickness;
		this.innerRadius = innerRadius;
		this.shelfRoundingRadius = shelfRoundingRadius;
		this.metersInTone = metersInTone;
		this.number = number;
	}

	public Double getWeightOfMeter() {
		return weightOfMeter;
	}

	public void setWeightOfMeter(Double weightOfMeter) {
		this.weightOfMeter = weightOfMeter;
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

	public Double getShelfAverageThickness() {
		return shelfAverageThickness;
	}

	public void setShelfAverageThickness(Double shelfAverageThickness) {
		this.shelfAverageThickness = shelfAverageThickness;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Channels)) return false;

		Channels channels = (Channels) o;

		if (weightOfMeter != null ? !weightOfMeter.equals(channels.weightOfMeter) : channels.weightOfMeter != null)
			return false;
		if (width != null ? !width.equals(channels.width) : channels.width != null) return false;
		if (height != null ? !height.equals(channels.height) : channels.height != null) return false;
		if (thickness != null ? !thickness.equals(channels.thickness) : channels.thickness != null) return false;
		if (shelfAverageThickness != null ? !shelfAverageThickness.equals(channels.shelfAverageThickness) : channels.shelfAverageThickness != null)
			return false;
		if (innerRadius != null ? !innerRadius.equals(channels.innerRadius) : channels.innerRadius != null)
			return false;
		if (shelfRoundingRadius != null ? !shelfRoundingRadius.equals(channels.shelfRoundingRadius) : channels.shelfRoundingRadius != null)
			return false;
		if (metersInTone != null ? !metersInTone.equals(channels.metersInTone) : channels.metersInTone != null)
			return false;
		return number != null ? number.equals(channels.number) : channels.number == null;
	}

	@Override
	public int hashCode() {
		int result = weightOfMeter != null ? weightOfMeter.hashCode() : 0;
		result = 31 * result + (width != null ? width.hashCode() : 0);
		result = 31 * result + (height != null ? height.hashCode() : 0);
		result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
		result = 31 * result + (shelfAverageThickness != null ? shelfAverageThickness.hashCode() : 0);
		result = 31 * result + (innerRadius != null ? innerRadius.hashCode() : 0);
		result = 31 * result + (shelfRoundingRadius != null ? shelfRoundingRadius.hashCode() : 0);
		result = 31 * result + (metersInTone != null ? metersInTone.hashCode() : 0);
		result = 31 * result + (number != null ? number.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Channels{" +
				"weightOfMeter=" + weightOfMeter +
				", width=" + width +
				", height=" + height +
				", thickness=" + thickness +
				", shelfAverageThickness=" + shelfAverageThickness +
				", innerRadius=" + innerRadius +
				", shelfRoundingRadius=" + shelfRoundingRadius +
				", metersInTone=" + metersInTone +
				", number='" + number + '\'' +
				'}';
	}
}
