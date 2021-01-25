package model;

/**
 *仮分数を扱うクラス
 * @author kazut
 *
 */
public class ImproperFraction extends Fraction {

	/**construct
	 * @param num Integer
	 */
	public ImproperFraction(int num) {
		super(0, num, 1);
	}

	public ImproperFraction(int mol, int den) {
		super(mol, den);
	}

	public ImproperFraction() {
		super();
	}

	@Override
	public Fraction add(Fraction f) {
		//　帯分数かどうかチェックする関数
		Fraction impf = checkInstanceMixedFraction(f);

		//　通分処理
		int mol1 = this.mol * impf.den;
		int den1 = this.den * impf.den;

		int mol2 = impf.mol * this.den;

		//　分子同士を加算
		int mol = mol1 + mol2;

		//　加算結果の分数を作成
		Fraction re = new ImproperFraction(mol, den1);

		return re.reduce();
	}

	@Override
	public Fraction add(int num) {
		//　受け取った整数（int)をFraction型へ
		Fraction f = new ImproperFraction(num);

		Fraction re = this.add(f);

		return re;
	}

	@Override
	public Fraction sub(Fraction f) {
		//　帯分数かどうかチェックする関数
		Fraction impf = checkInstanceMixedFraction(f);
		Fraction min = impf.multi(-1);
		Fraction re = this.add(min);

		return re.reduce();
	}

	@Override
	public Fraction sub(int num) {
		Fraction f = new ImproperFraction(num);
		Fraction re = this.sub(f);

		return re;
	}

	@Override
	public Fraction multi(Fraction f) {
		//　帯分数かどうかチェックする関数
		Fraction impf = checkInstanceMixedFraction(f);
		int mol = this.mol * impf.mol;
		int den = this.den * impf.den;

		Fraction re = new ImproperFraction(mol, den);

		return re.reduce();
	}

	@Override
	public Fraction multi(int num) {
		Fraction f = new ImproperFraction(num);

		Fraction re = this.multi(f);

		return re.reduce();
	}

	@Override
	public Fraction div(Fraction f) {
		//　帯分数かどうかチェックする関数
		Fraction impf = checkInstanceMixedFraction(f);
		Fraction inv = new ImproperFraction(impf.den, impf.mol);

		Fraction re = this.multi(inv);

		return re;
	}

	@Override
	public Fraction div(int num) {
		if (num == 0) {
			throw new ArithmeticException();
		}
		Fraction f = new ImproperFraction(1, num);

		Fraction re = this.multi(f);

		return re;
	}

	@Override
	public Fraction reduce() {
		int g = gcd(this.den, this.mol);
		int d = this.den / g;
		int m = this.mol / g;

		Fraction f = new ImproperFraction(m, d);
		return f;
	}

	@Override
	public double convertFloat() {
		double f = (double) this.mol / this.den;
		return f;
	}

	@Override
	public int convertInt() {
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
