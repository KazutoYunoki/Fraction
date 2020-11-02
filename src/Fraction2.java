/**
 * 分数を扱うクラス
 * @author kazut
 *
 */
public class Fraction2 implements Comparable<Fraction2> {
	/**　分子*/
	final protected int mol;
	/**　分母*/
	final protected int den;

	/**
	 * コンストラクタ
	 * @param num　整数
	 */
	public Fraction2(int num) {
		this(num, 1);
	}

	/**
	 * コンストラクタ（分母に0が設定された場合例外投げる）
	 * @param mol 分子
	 * @param den　分母
	 */
	public Fraction2(int mol, int den) {
		//　もし分母にゼロがある場合(例外を投げる）
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
	 * 分数同士の足し算
	 * @param f　加数
	 * @return　加算結果
	 */
	public Fraction2 add(Fraction2 f) {

		//　通分処理
		int mol1 = this.getMol() * f.getDen();
		int den1 = this.getDen() * f.getDen();

		int mol2 = f.mol * this.getDen();

		//　分子同士を加算
		int mol = mol1 + mol2;

		//　加算結果の分数を作成
		Fraction2 re = new Fraction2(mol, den1);

		return re.reduce();
	}

	/**
	 * 分数と整数同士の足し算
	 * @param num　整数
	 * @return　加算結果
	 */
	@Override
	public Fraction2 add(int num) {
		//　受け取った整数（int)をFraction型へ
		Fraction2 f = new Fraction2(num);
		//　分数同士の足し算を実施
		Fraction2 re = this.add(f);

		return re;
	}

	/**
	 * 分数同士の引き算
	 * @param f　引数
	 * @return　減算結果
	 */
	@Override
	public Fraction2 sub(Fraction2 f) {
		//　引数を-1倍にして加算
		Fraction2 min = f.multi(-1);

		Fraction2 re = this.add(min);

		return re.reduce();
	}

	/**
	 * 分数と整数の引き算
	 * @param num
	 * @return　計算結果
	 */
	@Override
	public Fraction2 sub(int num) {
		//　受け取った整数（int)をFraction型へ
		Fraction2 f = new Fraction2(num);
		//　分数同士の引き算を実施
		Fraction2 re = this.sub(f);

		return re;
	}

	/**
	 * 分数同士の掛け算
	 * @param f かける数
	 * @return　乗算結果
	 */
	@Override
	public Fraction2 multi(Fraction2 f) {
		//　分子と分母を掛け算する
		int mol = this.getMol() * f.getMol();
		int den = this.getDen() * f.getDen();

		Fraction2 re = new Fraction2(mol, den);

		return re.reduce();
	}

	/**
	 * 分数と整数の掛け算
	 * @param num 整数
	 * @return　乗算結果
	 */
	@Override
	public Fraction2 multi(int num) {
		//　整数を分数に変換
		Fraction2 f = new Fraction2(num);

		//　分数同士の掛け算
		Fraction2 re = this.multi(f);

		return re.reduce();
	}

	/**
	 * 分数同士の割り算
	 * @param f　割る数
	 * @return　剰余結果
	 */
	@Override
	public Fraction2 div(Fraction2 f) {
		//　逆数の分数を作成
		Fraction2 inv = new Fraction2(f.getDen(), f.getMol());

		//　逆数と乗算
		Fraction2 re = this.multi(inv);

		return re;

	}

	/**
	 * 分数と整数の割り算
	 * @param num　割る数
	 * @return　剰余結果
	 */
	@Override
	public Fraction2 div(int num) throws ArithmeticException {
		//　0で割る場合は例外処理
		if (num == 0) {
			throw new ArithmeticException();
		}
		//　整数の逆数を作成
		Fraction2 f = new Fraction2(1, num);

		//　逆数と掛け算
		Fraction2 re = this.multi(f);

		return re;
	}

	/**
	 * 分数を約分する関数
	 * @return 約分された分数
	 */
	public Fraction2 reduce() {

		//　最大公約数を取得
		int g = gcd(this.den, this.mol);

		//　最大公約数で分母と分子を割る
		int d = this.den / g;
		int m = this.mol / g;

		//　約分した分数を作成し返す
		Fraction2 f = new Fraction2(m, d);
		return f;
	}

	/**
	 * 分数を浮動小数点に変換
	 * @return
	 */
	public double convertFloat() {
		double f = (double) this.getMol() / this.getDen();
		return f;
	}

	/**
	 * 整数に変換、できなければ例外処理
	 * @return　整数
	 */
	public int convertInt() throws ArithmeticException {

		//　分子を分母で割り切れる場合整数に変換
		if (this.getMol() % this.getDen() == 0) {
			int num = this.getMol() / this.getDen();
			return num;
		} else {
			//　整数に変換できない場合は例外を投げる
			throw new ArithmeticException();
		}
	}

	/**
	 * 2つの整数から最大公約数を求める関数
	 * @param a　整数
	 * @param b　整数
	 * @return　最大公約数
	 */
	private int gcd(int x, int y) {
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
	 * 分子の値を取得
	 * @return　分子
	 */
	public int getMol() {
		return mol;
	}

	/**
	 * 分母の値を取得
	 * @return　分母
	 */
	public int getDen() {
		return den;
	}

	@Override
	public String toString() {

		//　整数でない場合
		if (this.den != 1) {
			return String.valueOf(this.mol) + '/' + String.valueOf(this.den);
		} else {
			return String.valueOf(this.mol);
		}
	}

	/**
	 * hashCode()のオーバーライド
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		//　約分してからハッシュ値を計算(同じ値の分数を同じハッシュ値にするため）
		Fraction2 f = this.reduce();
		result = prime * result + f.getDen();
		result = prime * result + f.getMol();
		return result;
	}

	/**
	 * equalsメソッドのオーバーライド
	 */
	@Override
	public boolean equals(Object o) {
		//　オブジェクトが同じ参照ならばtrue
		if (o == this) {
			return true;
		}
		//　オブジェクトの型がFractionでなければfalse
		if (!(o instanceof Fraction2)) {
			return false;
		}
		//　比較対象の分数を約分
		Fraction2 f = (Fraction2) o;
		f = f.reduce();

		//　比較する分数の約分
		Fraction2 f2 = this.reduce();

		//　分子同士、分母同士の比較結果を返す
		return (f.getMol() == f2.getMol()) && (f.getDen() == f2.getDen());
	}

	/**
	 * compareToメソッドのオーバーライド
	 */
	@Override
	public int compareTo(Fraction2 f) {
		//　分母を合わせて分子による比較
		int mol1 = this.getMol() * f.getDen();

		int mol2 = f.mol * this.getDen();

		return mol1 - mol2;
	}

}
