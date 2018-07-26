package GoF.behavioral.chainofResponsibility.exampleTwo;

public class NoteModule500 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.UA500;
        int remind = money.getAmt()%Note.UA500;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.UA500);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}