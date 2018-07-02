import java.util.Random;
import java.util.Scanner;

public class Fighter {
	private String name;
	private int healthPoints;
	private int staminaPoints;
	private Opponent opponent;
	Scanner scanner = new Scanner(System.in);
	String command;
	
	public Fighter(String name) {
		this.name = name;
		this.healthPoints = 100;
		this.staminaPoints = 10;
		
	}
	public Opponent setOpponent() {
		return this.opponent = this.generateBadGuy(this);
	}
	public Opponent generateBadGuy(Fighter fighter) {
		System.out.println("Your opponent shall be...");
		String[] fighters = {"Steve", "Tom", "Jeff", "Esteban", "Jimmy", "Bobby", "Goofus", "Evil Jeff" };
		Random generator = new Random();
		int roll = generator.nextInt(8)- 1;
		String opponent = fighters[roll];
		System.out.println(opponent + "!!!!!!!");
		return new Opponent(opponent, fighter);
	}
	public void welcome() {
		 System.out.println("Welcome " + this.name + "! It is time to fight!");
		 this.getReady();
	}
	public void getReady() {
		 this.setOpponent();
		 this.action();
	}
	public void action() {
		 System.out.println("Choose an attack! Punch, Kick or Stamina: " + "[ HP: " + this.healthPoints + " SP: " + this.staminaPoints + " ]");
		 String attack = this.scanner.next();
		 this.command(attack);
	}
	public void command(String attack) {
		if(attack.equals("punch")) {
			boolean check = this.stamCheck(attack);
			if(check) {
				System.out.println("You threw a punch!!!!");
				this.staminaPoints -= 2;
				this.opponent.punched();
				this.opponent.attackChoice();
			} else {
				System.out.println("You don't have enough stamina");
			}
			
		} else if(attack.equals("kick")) {
			boolean check = this.stamCheck(attack);
			if(check == true) {
			this.staminaPoints -= 4;
			this.opponent.kicked();
			this.opponent.attackChoice();
			}
		} else if (attack.equals("stamina")) {
			System.out.println("You take a turn to get stamina! You have a nice snack...");
			this.replinishStamina();
			this.opponent.attackChoice();
		}
	}
	public void attacked(String attack) {
		if(attack.equals("Punch")) {
			this.punched();
		} else if(attack.equals("Kick")) {
			this.kicked();
		} else if(attack.equals("Stamina")) {
			this.action();
		}
	}
	public void punched() {
		Random generator = new Random();
		int roll = generator.nextInt(10);
		if (roll <= 2) {
			System.out.println("They took a swing at you and missed! He kicks up dust, embarrassed");
			this.healthCheck();
		} else if(roll >= 8) {
			this.healthPoints -= 10;
			System.out.println("They punched " + this.name + " in the tummy for 10 HP damage!");
			this.healthCheck();
		}else {
			this.healthPoints -= 20;
			System.out.println("SMAAAAAAASH! they punched " + this.name + " in the dome for 20 HP damage!");
			this.healthCheck();
		}
		this.action();
	}
	public void kicked() {
			Random generator = new Random();
			int roll = generator.nextInt(10);
			if (roll <= 5) {
				System.out.println("They jump at you with their leg out but they failed to kick you! That's just sad, dude.");
			} else if(roll >= 8) {
				this.healthPoints -= 25;
				System.out.println("They kicked " + this.name + " in the tummy for 25 damage, and you pooed a little");
				this.healthCheck();
			}else {
				this.healthPoints -= 40;
				System.out.println("Awwwww Snap! They jump kicked " + this.name + " for 40 damage, and you probably have CTE now");
				this.healthCheck();
			}
			this.action();
		
	}
	public void healthCheck() {
		if (this.healthPoints <= 0) {
			System.out.println(this.name + " was defeated... Restart app to play again.");
			System.exit(0);
		}
	}
	public boolean stamCheck(String attack) {
		if(attack.equals("punch")) {
			if(this.staminaPoints >= 2) {
				return true;
			}
		}else if(attack.equals("kick")) {
			if(this.staminaPoints >= 4) {
				return true;
			}
		}
		return false;
	}
	public void replinishStamina() {
		Random generator = new Random();
		int stamSurge = generator.nextInt(4) + 1;
		switch(stamSurge) {
		case 1: this.staminaPoints += 4;
		System.out.println("After taking a quick breath " + this.name + " says, generates 4 stamina!");
		break;
		case 2: this.staminaPoints += 5;
		System.out.println("After some delicious orange slices, " + this.name + " generates 5 stamina!");
		break;
		case 3: this.staminaPoints += 6;
		System.out.println("After a refreshing quinoa salad, " + this.name + " , generates 6 stamina!");
		break;
		case 4: this.staminaPoints = 10;
		System.out.println("After a handful of almonds, " + this.name + " generates back all stamina!");
		break;
	}
		this.stamLimiter();

	}
	public void stamLimiter() {
		if(this.staminaPoints > 10) {
			this.staminaPoints = 10;
		}
	}
}
