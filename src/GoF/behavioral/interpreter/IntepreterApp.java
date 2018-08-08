package GoF.behavioral.interpreter;

public class IntepreterApp {
	public static void main(String[] args) {

		Context context = new Context();
		Expression expr = context.evaluate("1+2+3");
		System.out.println(expr.interprete());

	}
}

interface Expression {
	int interprete();
}

class NumberExpression implements Expression {
	int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int interprete() {
		return number;
	}

}

class MinusExpression implements Expression {
	Expression left;
	Expression right;

	public MinusExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interprete() {
		return left.interprete() - right.interprete();
	}
}

class PlusExpression implements Expression {
	Expression left;
	Expression right;

	public PlusExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interprete() {
		return left.interprete() + right.interprete();
	}

}

class Context {
	Expression evaluate(String s) {
		int pos = s.length()-1;
		while (pos > 0) {
			if (Character.isDigit(s.charAt(pos))) {
				pos--;
			} else {
				Expression left = evaluate(s.substring(0, pos));
				Expression right = new NumberExpression(Integer.valueOf(s.substring(pos + 1, s.length())));
				char operation = s.charAt(pos);
				switch (operation) {
				case '+':
					return new PlusExpression(left, right);
				case '-':
					return new MinusExpression(left, right);

				}
			}
		}
		int result = Integer.valueOf(s);
		return new NumberExpression(result);
	}
}
