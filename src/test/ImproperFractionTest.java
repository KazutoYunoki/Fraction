package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import model.Fraction;
import model.ImproperFraction;

public class ImproperFractionTest {

	@Test(expected = ArithmeticException.class)
	public void testConstract() {
		new ImproperFraction(1, 0);
	}

	@Test
	public void testHashCode() {

	}

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
		int num = 2;
		Fraction f = new ImproperFraction(1, 2);
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

		Fraction r1 = f.sub(num);
		assertThat("-3/2", is(r1.toString()));
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
		Fraction r1 = f.div(2);
		assertThat("1/4", is(r1.toString()));

		f.div(0);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReduce() {
		Fraction f = new ImproperFraction(3, 6);
		Fraction r = f.reduce();
		assertThat("1/2", is(r.toString()));
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
	public void testToString() {
		Fraction f = new ImproperFraction(2, 3);
		assertThat("2/3", is(f.toString()));
		Fraction f1 = new ImproperFraction(3, 1);
		assertThat("3", is(f1.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testEqualsObject() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f1 = new ImproperFraction(2, 4);
		Fraction f2 = new ImproperFraction(1, 3);
		assertThat(f.equals(f), is(true));
		assertThat(f.equals(f1), is(true));
		assertThat(f.equals(f2), is(false));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareTo() {
		Fraction f = new ImproperFraction(1, 2);
		Fraction f1 = new ImproperFraction(1, 3);

		SortedSet<Fraction> s = new TreeSet<Fraction>();
		s.add(f);
		s.add(f1);

		assertThat("1/3", is(s.first().toString()));
		assertThat("1/2", is(s.last().toString()));

	}

}
