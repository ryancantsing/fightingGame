import java.util.Scanner; 
public class FightingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		System.out.print("Enter your name, fighter: ");
		name = scanner.next();
		Fighter f1 = new Fighter(name);
		f1.welcome();
	}
}
