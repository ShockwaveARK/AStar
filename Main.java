
public class Main {
	  public static void main(String[] args) { 
		Control controle = new Control();
		controle.Initialize(args[0], (Integer.parseInt(args[1])-1), (Integer.parseInt(args[2])-1));
		controle.findPath();
	}
}
