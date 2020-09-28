import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {


	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		int num = 2;

		Fraction r = f.add(f2);
		assertThat("5/6", is(r.toString()));

		Fraction r1 = f.add(num);
		assertThat("5/2", is(r1.toString()));


	}
	@SuppressWarnings("deprecation")
	@Test
	public void testSub()
	{
		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		int num = 2;

		Fraction r = f.sub(f2);
		assertThat("1/6", is(r.toString()));

		Fraction r1 = f.sub(num);
		assertThat("-3/2", is(r1.toString()));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testMulti()
	{
		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		int num = 2;

		Fraction r = f.multi(f2);
		assertThat("1/6", is(r.toString()));

		Fraction r1 = f.multi(num);
		assertThat("1/1", is(r1.toString()));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testDiv() {
		Fraction f = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		int num = 2;

		Fraction r = f.div(f2);
		assertThat("3/2", is(r.toString()));

		Fraction r1 = f.div(num);
		assertThat("1/4", is(r1.toString()));

	}
	@SuppressWarnings("deprecation")
	@Test
	public void testReduction() {
		Fraction f = new Fraction(3, 6);
		f = f.reduction();
		assertThat("1/2", is(f.toString()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testToString()
	{
		Fraction f = new Fraction(1, 2);
		assertThat("1/2", is(f.toString()));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testConvertFloat()
	{
		Fraction f1 = new Fraction(1, 3);
		double floatPoint = f1.convertFloat();
		assertThat(floatPoint, is(0.3333333333333333));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testConvertInt() {
		Fraction f1 = new Fraction(4, 2);
		int num = f1.convertInt();
		assertThat(num, is(2));
		
		Fraction f2 = new Fraction(1, 3);
		int num1 = f2.convertInt();
		assertThat(num1, is(0));
	}


}
