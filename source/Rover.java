class Rover {
	private int x;
	private int y;
	private int degrees;

	public Rover(int _x, int _y, String _f) {
		x = _x;
		y = _y;
		setDegrees(_f);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getFacing() {
		return degreesToCardinal();
	}

	public String[] getPosition() {
		String[] p = {""+x, ""+y, getFacing()};
		return p;
	}

	public Rover left() {
		degrees = degrees - 90;
		return this;
	}

	public Rover right() {
		degrees = degrees + 90;
		return this;
	}

	public Rover move() {
		x = x + (int) Math.sin(degreesToRadians());
		y = y + (int) Math.cos(degreesToRadians());
		return this;
	}

	private void setDegrees(String cardinal) {
		switch(cardinal) {
			case "N" : degrees = 0; break;
			case "E" : degrees = 90; break;
			case "S" : degrees = 180; break;
			case "W" : degrees = 270; break;
			default : System.out.println("Error: Unrecognized facing " + cardinal);
		}
	}

	private String degreesToCardinal() {
		String cardinal = "";
		switch(deflatedDegrees()) {
			case -270 : cardinal = "E"; break;
			case -180 : cardinal = "N"; break;
			case  -90 : cardinal = "W"; break;
			case    0 : cardinal = "N"; break;
			case   90 : cardinal = "E"; break;
			case  180 : cardinal = "S"; break;
			case  270 : cardinal = "W"; break;
		}
		return cardinal;
	}

	private int deflatedDegrees() {
		return (degrees % 360);
	}

	private double degreesToRadians() {
		return Math.toRadians( (double) deflatedDegrees() );
	}

}
