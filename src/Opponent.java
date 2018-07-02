import java.util.Random;

public class Opponent {
	private String name;
	private int healthPoints;
	private int staminaPoints;
	private Fighter fighter;
		
	public Opponent(String name, Fighter fighter) {
		this.name = name;
		this.healthPoints = 100;
		this.staminaPoints = 10;
		this.fighter = fighter;
		}
		public void generateBadGuy(Fighter fighter) {
			System.out.println("Your opponent shall be...");
			String[] fighters = {"Steve", "Tom", "Jeff", "Esteban", "Jimmy", "Bobby", "Goofus", "Evil Jeff" };
			Random generator = new Random();
			int roll = generator.nextInt(8) - 1;
			String opponent = fighters[roll];
			System.out.println(opponent + "!!!!!!!");
			new Opponent(opponent, fighter);
		}

		public void punched() {
			Random generator = new Random();
			int roll = generator.nextInt(10);
			if (roll <= 2) {
				System.out.println("Ha, you missed a punch, how pathetic!");
				this.healthCheck();
				this.attackChoice();
			} else if(roll >= 8) {
				this.healthPoints -= 10;
				System.out.println("You punched " + this.name + " in the tummy for 10 HP damage!");
				this.healthCheck();
				this.attackChoice();
			}else {
				this.healthPoints -= 20;
				System.out.println("SMAAAAAAASH! You punched " + this.name + " in the dome for 20 HP damage!");
				this.healthCheck();
				this.attackChoice();
			}
		}
		public void kicked() {
				Random generator = new Random();
				int roll = generator.nextInt(10);
				if (roll <= 5) {
					System.out.println("Ha, you missed a kick and fell over, that's pretty funny");
					this.healthCheck();
					this.attackChoice();
				} else if(roll >= 8) {
					this.healthPoints -= 25;
					System.out.println("You kicked " + this.name + " in the tummy for 25 damage, and he also threw up a little");
					this.healthCheck();	
					this.attackChoice();

				}else {
					this.healthPoints -= 40;
					System.out.println("Awwwww Snap! You jump kicked " + this.name + " for 40 damage, and he probably has CTE now");
					this.healthCheck();
					this.attackChoice();
				}
			
		}
		public void healthCheck() {
			if (this.healthPoints <= 0) {
				System.out.println("You defeated " + this.name + "! We'll get another opponent for you");
				this.fighter.getReady();
			}
		}

		public void attackChoice() {
			System.out.println(this.name + ": [HP: " + this.healthPoints + " SP: " + this.staminaPoints + "]");
			if(this.staminaPoints >= 8) {
				Random generator = new Random();
				int roll = generator.nextInt(10);
				if(roll >= 5) {
					String newAttackChoice =  "Kick";
					this.staminaPoints -= 4;
					this.fighter.attacked(newAttackChoice);
				}
				else {
					String newAttackChoice = "Punch";
					this.staminaPoints -= 2;
					this.fighter.attacked(newAttackChoice);
				}
			} else if(this.staminaPoints >= 4 && this.staminaPoints <= 7) {
				Random generator = new Random();
				int roll = generator.nextInt(10);
				if(roll >= 5) {
					String newAttackChoice =  "Punch";
					this.staminaPoints -= 2;
					this.fighter.attacked(newAttackChoice);
				}
				else {
					String newAttackChoice = "Kick";
					this.staminaPoints -= 4;
					this.fighter.attacked(newAttackChoice);
				}
			}
			else if(this.staminaPoints < 4 && this.staminaPoints >= 2) {
				String newAttackChoice = "Punch";
				this.fighter.attacked(newAttackChoice);
			}
			else {
				String[] taunts = {"You punch pretty hard for an insect", "'tis only a flesh wound", "I've fought stronger squirrels", "I'm getting a little more resistance from gravity, to be honest", "You are the chumpest of chumps, chump!", "Stop attacking me, this is getting really sad for you"};
				Random generator = new Random();
				int roll = generator.nextInt(6);
				int stamSurge = generator.nextInt(4) + 1;
				switch(stamSurge) {
				case 1: this.staminaPoints += 4;
				System.out.println(taunts[roll] + "! " + this.name + " says, generating 4 stamina!");
				break;
				case 2: this.staminaPoints += 5;
				System.out.println(taunts[roll] + "! " + this.name + " says, generating 5 stamina!");
				break;
				case 3: this.staminaPoints += 6;
				System.out.println(taunts[roll] + "! " + this.name + " says, generating 6 stamina!");
				break;
				case 4: this.staminaPoints = 10;
				System.out.println(taunts[roll] + "! " + this.name + " says, generating back all stamina!");
			}
				String newAttackChoice = "Stamina";
				this.fighter.attacked(newAttackChoice);
		}
			
		}
		
}
		

