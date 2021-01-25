package model;

/**
 * 帯分数を扱うためのクラス
 * TODO コンストラクタの時点で分母より分子が大きい場合、帯分数に変換する処理を実装
 * @author kazut
 *
 */
public class MixedFraction extends Fraction {

	//　仮分数形式のFraction型を保持
	private Fraction cvThisImpFraction = cvImproperFraction(this);

	public MixedFraction(int num) {
		super(num, 0, 1);
	}

	public MixedFraction(int mol, int den) {
		super(0, mol, den);
	}

	public MixedFraction(int num, int mol, int den) {
		super(num, mol, den);
	}

	@Override
	public Fraction add(Fraction f) {
		//　引数が帯分数の場合、仮分数に変換する。仮分数の場合は仮分数
		Fraction cvFimpFraction = checkInstanceMixedFraction(f);

		//　仮分数での加算を実施
		Fraction improperResult = cvThisImpFraction.add(cvFimpFraction);
		//　帯分数に変換
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction add(int num) {
		Fraction improperResult = cvThisImpFraction.add(num);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction sub(Fraction f) {
		//　引数が帯分数の場合、仮分数に変換する。仮分数の場合は仮分数
		Fraction cvFimpFraction = checkInstanceMixedFraction(f);

		Fraction improperResult = cvThisImpFraction.sub(cvFimpFraction);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction sub(int num) {
		Fraction improperResult = cvThisImpFraction.sub(num);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction multi(Fraction f) {
		//　引数が帯分数の場合、仮分数に変換する。仮分数の場合は仮分数
		Fraction cvFimpFraction = checkInstanceMixedFraction(f);
		Fraction improperResult = cvThisImpFraction.multi(cvFimpFraction);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction multi(int num) {
		Fraction improperResult = cvThisImpFraction.multi(num);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction div(Fraction f) {
		//　引数が帯分数の場合、仮分数に変換する。仮分数の場合は仮分数
		Fraction cvFimpFraction = checkInstanceMixedFraction(f);
		Fraction improperResult = cvThisImpFraction.div(cvFimpFraction);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction div(int num) {
		Fraction improperResult = cvThisImpFraction.div(num);
		Fraction mixedResult = cvMixedFraction(improperResult);
		return mixedResult;
	}

	@Override
	public Fraction reduce() {
		Fraction r = cvThisImpFraction.reduce();
		return r.cvMixedFraction(r);
	}

	@Override
	public double convertFloat() {
		return cvThisImpFraction.convertFloat();
	}

	@Override
	public int convertInt() {
		return cvThisImpFraction.convertInt();
	}

	@Override
	public String toString() {
		if (this.num != 0 && this.mol != 0) {
			return String.valueOf(this.num) + "+" + String.valueOf(this.mol) + "/" + String.valueOf(this.den);
		} else if (this.num == 0 && this.mol != 0) {
			return String.valueOf(this.mol) + "/" + String.valueOf(this.den);
		} else {
			return String.valueOf(this.num);
		}
	}

	@Override
	public int hashCode() {
		return cvThisImpFraction.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return cvThisImpFraction.equals(o);
	}

	@Override
	public int compareTo(Fraction f) {
		return cvThisImpFraction.compareTo(f);
	}

}
