package runners;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

public class FreeMind {
	static int largest(int[] candies) {
		int i;

		int max = candies[0];

		for (i = 1; i < candies.length; i++)
			if (candies[i] > max)
				max = candies[i];
		return max;
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> a = new ArrayList<Boolean>();
		for (int i : candies) {
			int max = largest(candies);
			System.out.println(max);
			if (i + extraCandies >= max) {
				System.out.println(i + " extra " + extraCandies);
				a.add(true);
			} else
				a.add(false);
		}
		return a;
	}

	
	@Test
	public void pub() {
		int candies[] = new int[] { 2, 3, 5, 1, 3 };
		int extraCandies = 3;
		System.out.println(kidsWithCandies(candies, extraCandies));
	}
}
