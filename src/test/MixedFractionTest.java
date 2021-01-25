package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Fraction;
import model.ImproperFraction;
import model.MixedFraction;

public class MixedFractionTest {

	@Test
	public void testHashCode() {
		fail("まだ実装されていません");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddFraction() {
		Fraction f = new MixedFraction(1, 1, 2);
		Fraction f2 = new MixedFraction(2, 1, 3);
		Fraction r = f.add(f2);

		Fraction i = new ImproperFraction(1, 2);
		Fraction r2 = f.add(i);

		assertThat("3+5/6", is(r.toString()));
		assertThat("2", is(r2.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddInt() {
		Fraction f = new MixedFraction(1, 1, 2);
		int num = 2;
		Fraction r = f.add(num);
		assertThat("3+1/2", is(r.toString()));
	}

	@Test
	public void testSubFraction() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSubInt() {
		fail("まだ実装されていません");
	}

	@Test
	public void testMultiFraction() {
		fail("まだ実装されていません");
	}

	@Test
	public void testMultiInt() {
		fail("まだ実装されていません");
	}

	@Test
	public void testDivFraction() {
		fail("まだ実装されていません");
	}

	@Test
	public void testDivInt() {
		fail("まだ実装されていません");
	}

	@Test
	public void testReduce() {
		fail("まだ実装されていません");
	}

	@Test
	public void testConvertFloat() {
		fail("まだ実装されていません");
	}

	@Test
	public void testConvertInt() {
		fail("まだ実装されていません");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testToString() {
		Fraction f = new MixedFraction(1, 2, 3);
		assertThat("1+2/3", is(f.toString()));
	}

	@Test
	public void testEqualsObject() {
		fail("まだ実装されていません");
	}

	@Test
	public void testCompareTo() {
		fail("まだ実装されていません");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMixedFractionConstructInteger() {
		Fraction f = new MixedFraction(3);
		assertThat("3", is(f.toString()));
		Fraction f1 = new MixedFraction(0);
		assertThat("0", is(f1.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test(expected = ArithmeticException.class)
	public void testMixedFractionConstruct() {
		Fraction f = new MixedFraction(1, 2);
		Fraction f2 = new MixedFraction(1, 1, 2);

		assertThat("1/2", is(f.toString()));
		assertThat("1+1/2", is(f2.toString()));

		new MixedFraction(1, 1, 0);
	}

}
