package test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Fraction2;

public class Fraction2Test {

	@Test(expected = ArithmeticException.class)
	public void testConstract() {
		new Fraction2(1, 0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		Fraction2 f = new Fraction2(1, 2);
		Fraction2 f2 = new Fraction2(-1, 3);
		int num = 2;

		Fraction2 r = f.add(f2);
		assertThat("1/6", is(r.toString()));

		Fraction2 r1 = f.add(num);
		assertThat("5/2", is(r1.toString()));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSub() {
		Fraction2 f = new Fraction2(1, 2);
		Fraction2 f2 = new Fraction2(1, 3);
		int num = 2;

		Fraction2 r = f.sub(f2);
		assertThat("1/6", is(r.toString()));

		Fraction2 r1 = f.sub(num);
		assertThat("-3/2", is(r1.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMulti() {
		Fraction2 f = new Fraction2(1, 2);
		Fraction2 f2 = new Fraction2(1, 3);
		int num = 2;

		Fraction2 r = f.multi(f2);
		assertThat("1/6", is(r.toString()));

		Fraction2 r1 = f.multi(num);
		assertThat("1", is(r1.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test(expected = ArithmeticException.class)
	public void testDiv() {
		Fraction2 f = new Fraction2(1, 2);
		Fraction2 f2 = new Fraction2(1, 3);

		Fraction2 r = f.div(f2);
		assertThat("3/2", is(r.toString()));

		Fraction2 r1 = f.div(2);
		assertThat("1/4", is(r1.toString()));

		f.div(0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testreduce() {
		Fraction2 f = new Fraction2(3, 6);
		f = f.reduce();
		assertThat("1/2", is(f.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testToString() {
		Fraction2 f = new Fraction2(1, 2);
		Fraction2 f1 = new Fraction2(2, 4);
		Fraction2 f2 = new Fraction2(3);

		assertThat("1/2", is(f.toString()));
		assertThat("2/4", is(f1.toString()));
		assertThat("3", is(f2.toString()));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testConvertFloat() {
		Fraction2 f1 = new Fraction2(1, 3);
		double floatPoint = f1.convertFloat();
		assertThat(floatPoint, is(0.3333333333333333));
	}

	@SuppressWarnings("deprecation")
	@Test(expected = ArithmeticException.class)
	public void testConvertInt() {

		Fraction2 f1 = new Fraction2(4, 2);
		int num = f1.convertInt();
		assertThat(num, is(2));

		Fraction2 f2 = new Fraction2(1, 3);
		f2.convertInt();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testEquals() {
		Fraction2 f1 = new Fraction2(1, 2);
		Fraction2 f2 = new Fraction2(2, 4);

		assertThat(f1.equals(f1), is(true));
		assertThat(f1.equals(f2), is(true));
	}

}
