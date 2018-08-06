package GoF.behavioral.visitor.exampleOne;


public interface Shape {
    public void move(int x, int y);
    public void draw();
    public String accept(Visitor visitor);
}