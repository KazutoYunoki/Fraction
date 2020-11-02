
/**
 *仮分数を扱うクラス
 * @author kazut
 *
 */
public class ImproperFraction extends Fraction {

	protected ImproperFraction(int num) {
		super(num);
	}

	protected ImproperFraction(int mol, int den) {
		super(mol, den);
	}

	@Override
	protected Fraction add(Fraction f) {
		//　通分処理
		int mol1 = this.mol * f.den;
		int den1 = this.den * f.den;

		int mol2 = f.mol * this.den;

		//　分子同士を加算
		int mol = mol1 + mol2;

		//　加算結果の分数を作成
		Fraction re = new ImproperFraction(mol, den1);

		return re.reduce();
	}

	@Override
	protected Fraction add(int num) {
		//　受け取った整数（int)をFraction型へ
		Fraction f = new ImproperFraction(num);

		Fraction re = this.add(f);

		return re;
	}

	@Override
	protected Fraction sub(Fraction f) {
		Fraction min = f.multi(-1);
		Fraction re = this.add(min);

		return re.reduce();
	}

	@Override
	protected Fraction sub(int num) {
		Fraction f = new ImproperFraction(num);
		Fraction re = this.sub(f);

		return re;
	}

	@Override
	protected Fraction multi(Fraction f) {
		int mol = this.mol * f.mol;
		int den = this.den * f.den;

		Fraction re = new ImproperFraction(mol, den);

		return re.reduce();
	}

	@Override
	protected Fraction multi(int num) {
		Fraction f = new ImproperFraction(num);

		Fraction re = this.multi(f);

		return re.reduce();
	}

	@Override
	protected Fraction div(Fraction f) {
		Fraction inv = new ImproperFraction(f.den, f.mol);

		Fraction re = this.multi(inv);

		return re;
	}

	@Override
	protected Fraction div(int num) {
		if (num == 0) {
			throw new ArithmeticException();
		}
		Fraction f = new ImproperFraction(1, num);

		Fraction re = this.multi(f);

		return re;
	}

	@Override
	protected Fraction reduce() {
		int g = gcd(this.den, this.mol);
		int d = this.den / g;
		int m = this.mol / g;

		Fraction f = new ImproperFraction(m, d);
		return f;
	}

	@Override
	protected double convertFloat() {
		double f = (double) this.mol / this.den;
		return f;
	}

	@Override
	protected int convertInt() {
		if (this.mol % this.den == 0) {
			int num = this.mol / this.den;
			return num;
		} else {
			throw new ArithmeticException();
		}
	}

	@Override
	public String toString() {
		if (this.den != 1) {
			return String.valueOf(this.mol) + '/' + String.valueOf(this.den);
		} else {
			return String.valueOf(this.mol);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		Fraction f = this.reduce();
		result = prime * result + f.den;
		result = prime * result + f.mol;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Fraction)) {
			return false;
		}
		Fraction f = (ImproperFraction) o;
		f = f.reduce();

		Fraction f2 = this.reduce();

		return (f.mol == f2.mol) && (f.den == f2.den);
	}

	@Override
	public int compareTo(Fraction f) {
		int mol1 = this.mol * f.den;
		int mol2 = f.mol * this.den;

		return mol1 - mol2;
	}

}
