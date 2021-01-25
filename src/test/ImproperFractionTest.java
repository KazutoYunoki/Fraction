package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Fraction;
import model.ImproperFraction;

public class ImproperFractionTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testAddFraction() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f2 = new ImproperFraction(-1, 3);

		Fraction r = f.add(f2);
		assertThat("1/6", is(r.toString()));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddInt() {
		Fraction f = new ImproperFraction(1, 2);
		int num = 2;
		Fraction r1 = f.add(num);
		assertThat("5/2", is(r1.toString()));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSubFraction() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f2 = new ImproperFraction(1, 3);

		Fraction r = f.sub(f2);
		assertThat("1/6", is(r.toString()));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSubInt() {
		Fraction f = new ImproperFraction(1, 2);
		int num = 2;

		Fraction r = f.sub(num);
		assertThat("-3/2", is(r.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMultiFraction() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f2 = new ImproperFraction(1, 3);

		Fraction r = f.multi(f2);
		assertThat("1/6", is(r.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMultiInt() {
		Fraction f = new ImproperFraction(1, 2);
		int num = 2;

		Fraction r = f.multi(num);
		assertThat("1", is(r.toString()));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDivFraction() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f2 = new ImproperFraction(1, 3);

		Fraction r = f.div(f2);
		assertThat("3/2", is(r.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test(expected = ArithmeticException.class)
	public void testDivInt() {
		Fraction f = new ImproperFraction(1, 2);
		int num = 2;
		Fraction r = f.div(num);
		assertThat("1/4", is(r.toString()));
		f.div(0);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReduce() {
		Fraction f = new ImproperFraction(3, 6);
		f = f.reduce();
		assertThat("1/2", is(f.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testConvertFloat() {
		Fraction f = new ImproperFraction(1, 3);
		double floatPoint = f.convertFloat();
		assertThat(floatPoint, is(0.3333333333333333));
	}

	@SuppressWarnings("deprecation")
	@Test(expected = ArithmeticException.class)
	public void testConvertInt() {
		Fraction f = new ImproperFraction(4, 2);
		int num = f.convertInt();
		assertThat(num, is(2));

		Fraction f1 = new ImproperFraction(1, 3);
		f1.convertInt();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testEqualsObject() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f2 = new ImproperFraction(2, 4);

		assertThat(f.equals(f), is(true));
		assertThat(f.equals(f2), is(true));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testIntegerFraction() {
		Fraction f = new ImproperFraction(2);
		assertThat("2", is(f.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test(expected = ArithmeticException.class)
	public void testImproperFraction() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f2 = new ImproperFraction(3, 2);
		assertThat("3/2", is(f2.toString()));
		assertThat("1/2", is(f.toString()));
		new ImproperFraction(1, 0);
	}
}
