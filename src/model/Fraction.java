package model;
/**
 * 分数の雛形を表す抽象クラス
 * @author kazut
 *
 */
public abstract class Fraction implements Comparable<Fraction> {
	/**　分子*/
	final protected int mol;

	/**　分母*/
	final protected int den;

	/**
	 * コンストラクタ
	 * @param num 整数
	 */
	protected Fraction(int num) {
		this(num, 1);
	}

	/**
	 * コンストラクタ（分母に0に設定された場合例外を投げる）
	 * @param mol
	 * @param den
	 */
	protected Fraction(int mol, int den) {
		//　もし分母にゼロがある場合（例外を投げる）
		if (den == 0) {
			throw new ArithmeticException();
		}
		//　分母に負数がある場合分子に負数を持っていく
		if (den < 0) {
			this.mol = -mol;
			this.den = -den;
		} else {
			this.mol = mol;
			this.den = den;
		}
	}

	/**
	 * 2つの整数から最大公約数を求める関数
	 * @param a　整数
	 * @param b　整数
	 * @return　最大公約数
	 */
	protected int gcd(int x, int y) {
		int r;

		//　負数の場合正の数に変換
		int a = x < 0 ? -x : x;
		int b = y < 0 ? -y : y;

		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while ((r = a % b) != 0) {
			a = b;
			b = r;
		}

		return b;
	}

	/**
	 * 分数同士の足し算
	 * @param f 加数
	 * @return 加算結果
	 */
	protected abstract Fraction add(Fraction f);

	/**
	 * 分数と整数同士の足し算
	 * @param num 整数
	 * @return　加算結果
	 */
	protected abstract Fraction add(int num);

	/**
	 * 分数同士の引き算
	 * @param f　引数
	 * @return　減算結果
	 */
	protected abstract Fraction sub(Fraction f);

	/**
	 * 分数と整数の引き算
	 * @param num
	 * @return　計算結果
	 */
	protected abstract Fraction sub(int num);

	/**
	 * 分数同士の掛け算
	 * @param f かける数
	 * @return　乗算結果
	 */
	protected abstract Fraction multi(Fraction f);

	/**
	 * 分数と整数の掛け算
	 * @param num 整数
	 * @return　乗算結果
	 */
	protected abstract Fraction multi(int num);

	/**
	 * 分数同士の割り算
	 * @param f　割る数
	 * @return　剰余結果
	 */
	protected abstract Fraction div(Fraction f);

	/**
	 * 分数と整数の割り算
	 * @param num　割る数
	 * @return　剰余結果
	 */
	protected abstract Fraction div(int num);

	/**
	 * 分数を約分する関数
	 * @return 約分された分数
	 */
	protected abstract Fraction reduce();

	/**
	 * 分数を浮動小数点に変換
	 * @return
	 */
	protected abstract double convertFloat();

	/**
	 * 整数に変換、できなければ例外処理
	 * @return　整数
	 */
	protected abstract int convertInt();

	@Override
	public abstract String toString();

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int compareTo(Fraction f);

}
