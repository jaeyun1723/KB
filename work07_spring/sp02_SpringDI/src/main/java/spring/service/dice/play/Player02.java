package spring.service.dice.play;

import spring.service.dice.Dice;
import spring.service.dice.DiceA;

/*
 *	Dice를 hasing 하는 Player02
 */
public class Player02 {

	/// Field
	private int totalValue;
	private Dice dice;

	/// Constructor Method
	public Player02() {
	}

	public Player02(Dice dice) {
		this.dice = dice;
	}

	/// Method (getter/setter)
	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	// ==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count) {

		System.out.println("==>" + getClass().getName() + ".DiceAImpl.java\r\n" + "DiceBImpl.java\r\n"
				+ "DiceCImpl.javaplayDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ " + dice.getClass().getName() + " ] 의 선택된수 : " + dice.getValue());
			totalValue += dice.getValue();
		}

		System.out.println("==>" + getClass().getName() + ".playDice() end....");
	}

}// end of class