package GoF.behavioral.chainofResponsibility.exampleTwo;

public class BankomatApp {
	public static void main(String[] args) {

		System.out.println("Сумма к выдаче: 3 350 UA");
		NoteModule note500 = new NoteModule500();
		NoteModule note200 = new NoteModule200();
	//	NoteModule note100 = new NoteModule100();
		NoteModule note50 = new NoteModule50();

		note500.setNextMoneyModule(note200);
	//	note200.setNextMoneyModule(note100);
		note200.setNextMoneyModule(note50);

		note500.takeMoney(new Money(3_350));
	}
}