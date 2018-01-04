package vn.com.nct.model.response;

public class FrameDataCollectionResponse {
	
	private int 			id;
	private long 			time;
	private double 			pH;
	private double 			tempurature;
	private double 			humidity;
	private double 			co2;
	private FrameResponse 	frame;
	
	
	
	public FrameDataCollectionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FrameDataCollectionResponse(int id, long time, double pH, double tempurature, double humidity, double co2,
			FrameResponse frame) {
		super();
		this.id = id;
		this.time = time;
		this.pH = pH;
		this.tempurature = tempurature;
		this.humidity = humidity;
		this.co2 = co2;
		this.frame = frame;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getpH() {
		return pH;
	}
	public void setpH(double pH) {
		this.pH = pH;
	}
	public double getTempurature() {
		return tempurature;
	}
	public void setTempurature(double tempurature) {
		this.tempurature = tempurature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getCo2() {
		return co2;
	}
	public void setCo2(double co2) {
		this.co2 = co2;
	}
	public FrameResponse getFrame() {
		return frame;
	}
	public void setFrame(FrameResponse frame) {
		this.frame = frame;
	}
	
	
	
}
