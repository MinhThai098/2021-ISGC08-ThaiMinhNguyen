import java.util.Scanner;

public class ViewConsole {
	private Controller c;
	
	
	public void viewUi () {
		c = new Controller(null);
		System.out.println("1. Läs fil");
		System.out.println("2. Skapa ny fil");
		Scanner sc = new Scanner(System.in);
		System.out.println("Välj ett nummer:");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("Du har valt: " + num);
		String filePath = null;
		String content;
		switch (num) {
		case 1:
			System.out.println("Ange filnamn inklusiva sökväg: ");
			System.out.println(num);
			filePath = sc.nextLine();
			content = c.actionPerformedConsole(num, filePath);
			System.out.println("innehållet är följande: \n" + content);
			break;
		case 2:
			System.out.println("Ange sökvägen för filen samt filnamn");
			filePath = sc.nextLine();
			content = c.actionPerformedConsole(num, filePath);
			System.out.println(content);
			break;
		}
		
		sc.close();
	}
	
	public int chooseUi() {
		System.out.println("Hej och välkommen till notepad editor");
		System.out.println("1. Grafisk meny");
		System.out.println("2. Console meny");
		System.out.println("Välj ett av följande: ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("Du har valt följande: " + num);
		if (num > 2 || 0 > num) {
			chooseUi();
		}
		return num;
		
	}
}
