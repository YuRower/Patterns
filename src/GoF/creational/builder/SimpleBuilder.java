package GoF.creational.builder;

public class SimpleBuilder {

	public static void main(String[] args) {
		Tank tank = new SimpleTankBuilder().buildName(" M1 Abrams ").buildCountry(Country.USA).buildMaxSpeed(60)
				.build();
		System.out.println(tank);

	}
}

enum Country {
	USSR, USA
}

class Tank {
	String name;
	Country country;
	int maxSpeed;

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Tank [name=" + name + ", country=" + country + ", maxSpeed=" + maxSpeed + "]";
	}

}

class SimpleTankBuilder {

	String n = "Default";
	Country t = Country.USSR;
	int s = 60;

	SimpleTankBuilder buildName(String n) {
		this.n = n;
		return this;
	}

	SimpleTankBuilder buildCountry(Country t) {
		this.t = t;
		return this;
	}

	SimpleTankBuilder buildMaxSpeed(int s) {
		this.s = s;
		return this;
	}

	Tank build() {
		Tank tank = new Tank();
		tank.setName(n);
		tank.setCountry(t);
		tank.setMaxSpeed(s);
		return tank;
	}
}