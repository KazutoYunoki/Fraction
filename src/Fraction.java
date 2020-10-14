/**
 * 分数を扱うクラス
 * @author kazut
 *
 */
public class Fraction implements Comparable<Fraction>{
	/**　分子*/
	private int mol;
	/**　分母*/
	private int den;
	/**
	 * コンストラクタ
	 * @param num　整数
	 */
	public Fraction(int num) {
		this(num, 1);
	}
	/**
	 * コンストラクタ（分母に0が設定された場合例外投げる）
	 * @param mol 分子
	 * @param den　分母
	 */
	public Fraction(int mol, int den)
	{
		//　もし分母にゼロがある場合(例外を投げる）
		if(den == 0)
		{
			throw new ArithmeticException();
		}
		//　分母に負数がある場合分子に負数を持っていく
		if(den < 0)
		{
			this.mol = -mol;
			this.den = -den;
		}
		else
		{
			this.mol = mol;
			this.den = den;
		}
	}
	/**
	 * 分数同士の足し算
	 * @param f　加数
	 * @return　加算結果
	 */
	public Fraction add(Fraction f) {

		//　通分処理
		int mol1 = this.getMol() * f.getDen();
		int den1 = this.getDen() * f.getDen();

		int mol2 = f.mol * this.getDen();

		//　分子同士を加算
		int mol = mol1 + mol2;

		//　加算結果の分数を作成
		Fraction re = new Fraction(mol, den1);

		//　約分する
		re = re.reduction();
		return re;
	}
	/**
	 * 分数と整数同士の足し算
	 * @param num　整数
	 * @return　加算結果
	 */
	public Fraction add(int num)
	{
		//　受け取った整数（int)をFraction型へ
		Fraction f = new Fraction(num);
		//　分数同士の足し算を実施
		Fraction re = this.add(f);

		return re;
	}
	/**
	 * 分数同士の引き算
	 * @param f　引数
	 * @return　減算結果
	 */
	public Fraction sub(Fraction f)
	{
		int mol1 = this.getMol() * f.getDen();
		int den1 = this.getDen() * f.getDen();

		int mol2 = f.getMol() * this.getDen();

		//　分子同士を引き算
		int mol = mol1 - mol2;

		//　加算結果の分数を作成
		Fraction re = new Fraction(mol, den1);

		//　約分する
		re = re.reduction();
		return re;
	}
	/**
	 * 分数と整数の引き算
	 * @param num
	 * @return　計算結果
	 */
	public Fraction sub(int num)
	{
		//　受け取った整数（int)をFraction型へ
		Fraction f = new Fraction(num);
		//　分数同士の引き算を実施
		Fraction re = this.sub(f);

		return re;
	}
	/**
	 * 分数同士の掛け算
	 * @param f かける数
	 * @return　乗算結果
	 */
	public Fraction multi(Fraction f)
	{
		//　分子と分母を掛け算する
		int mol = this.getMol() * f.getMol();
		int den = this.getDen() * f.getDen();

		Fraction re = new Fraction(mol, den);
		re = re.reduction();

		return re;
	}
	/**
	 * 分数と整数の掛け算
	 * @param num 整数
	 * @return　乗算結果
	 */
	public Fraction multi(int num)
	{
		int mol = this.getMol() * num;
		int den = this.getDen();

		Fraction re = new Fraction(mol, den);
		re = re.reduction();

		return re;
	}
	/**
	 * 分数同士の割り算
	 * @param f　割る数
	 * @return　剰余結果
	 */
	public Fraction div(Fraction f)
	{
		//　逆数の分数を作成
		Fraction inv = new Fraction(f.getDen(), f.getMol());

		//　逆数と乗算
		Fraction re = this.multi(inv);

		return re;

	}
	/**
	 * 分数と整数の割り算
	 * @param num　割る数
	 * @return　剰余結果
	 */
	public Fraction div(int num) throws ArithmeticException
	{
		//　0で割る場合は例外処理
		if(num == 0)
		{
			throw new ArithmeticException();
		}
		//　整数の逆数を作成
		Fraction f = new Fraction(1, num);

		//　逆数と掛け算
		Fraction re = this.multi(f);

		return re;
	}
	/**
	 * 分数を約分する関数
	 * @return 約分された分数
	 */
	public Fraction reduction() {

		//　分母の値と分子の値を取得
		int a = this.getDen();
		int b = this.getMol();

		//　負数の場合正の数に変換
		a = a < 0 ? -a : a;
		b = b < 0 ? -b : b;

		//　最大公約数を取得
		int g = gcd(this.den, this.mol);

		//　最大公約数で分母と分子を割る
		int d = this.den / g;
		int m = this.mol / g;


		//　約分した分数を作成し返す
		Fraction f = new Fraction(m, d);
		return f;
	}
	/**
	 * 分数を浮動小数点に変換
	 * @return
	 */
	public double convertFloat()
	{
		double f = (double)this.getMol() / this.getDen();
		return f;
	}
	/**
	 * 整数に変換、できなければ例外処理
	 * @return　整数
	 */
	public int convertInt() throws ArithmeticException
	{

		//　分子を分母で割り切れる場合整数に変換
		if(this.getMol() % this.getDen() == 0)
		{
			int num = this.getMol() / this.getDen();
			return num;
		}
		else
		{
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
	private int gcd(int a, int b) {
		int r;
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while((r = a % b) != 0)
		{
			a = b;
			b = r;
		}

		return b;
	}
	/**
	 * 分子の値を取得
	 * @return　分子
	 */
	public int getMol()
	{
		return mol;
	}
	/**
	 * 分母の値を取得
	 * @return　分母
	 */
	public int getDen()
	{
		return den;
	}

	@Override
	public String toString() {
		return String.valueOf(this.mol) + '/' + String.valueOf(this.den);
	}
	/**
	 * hashCode()のオーバーライド
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		//　約分してからハッシュ値を計算(同じ値の分数を同じハッシュ値にするため）
		Fraction f = this.reduction();
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
		if(o == this) {
			return true;
		}
		//　オブジェクトの型がFractionでなければfalse
		if(!(o instanceof Fraction))
		{
			return false;
		}
		//　比較対象の分数を約分
		Fraction f = (Fraction) o;
		f = f.reduction();

		//　比較する分数の約分
		Fraction f2 = this.reduction();

		//　分子同士、分母同士の比較結果を返す
		return (f.getMol() == f2.getMol()) && (f.getDen() == f2.getDen());
	}
	/**
	 * compareToメソッドのオーバーライド
	 */
	@Override
	public int compareTo(Fraction f) {
		//　分母を合わせて分子による比較
		int mol1 = this.getMol() * f.getDen();

		int mol2 = f.mol * this.getDen();

 		return mol1 - mol2;
	}




}

