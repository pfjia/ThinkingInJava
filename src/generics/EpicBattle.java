package generics;

import java.util.List;

interface SuperPower {

}

interface XRayVision extends SuperPower {
	void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
	void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
	void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
	POWER power;

	public SuperHero(POWER power) {
		// TODO Auto-generated constructor stub
		this.power = power;
	}

	POWER getPower() {
		return power;
	}
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

	public SuperSleuth(POWER power) {
		super(power);
		// TODO Auto-generated constructor stub
	}

	void see() {
		power.seeThroughWalls();
	}
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends
		SuperHero<POWER> {

	public CanineHero(POWER power) {
		super(power);
		// TODO Auto-generated constructor stub
	}

	void hear() {
		power.hearSubtleNoises();
	}

	void smell() {
		power.trackBySmell();
	}
}

class SuperHearSmel implements SuperHearing, SuperSmell {

	@Override
	public void trackBySmell() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hearSubtleNoises() {
		// TODO Auto-generated method stub

	}

}

class DogBoy extends CanineHero<SuperHearSmel> {

	public DogBoy() {
		super(new SuperHearSmel());
		// TODO Auto-generated constructor stub
	}

}

public class EpicBattle {
	static <POWER extends SuperHearing> void userSuperHearing(
			SuperHero<POWER> hero) {
		hero.getPower().hearSubtleNoises();
		;
	}

	static <POWER extends SuperHearing & SuperSmell> void superFind(
			SuperHero<POWER> hero) {
		hero.getPower().hearSubtleNoises();
		hero.getPower().trackBySmell();
	}

	public static void main(String[] args) {
		DogBoy dogBoy = new DogBoy();
		userSuperHearing(dogBoy);
		superFind(dogBoy);

		List<? extends SuperHearing> audioBoys;
	}

}
