package 递归;

/**
 * @Auther: shenguang
 * @Date: 2018/11/22 18:40
 * @Description:
 */
public class Triangle {
	public int index=1;
	public int triangle(int n){
		if(n==1){
			//为1时终止
			return 1;
		}else {
			int i = triangle(n - 1) + n;
			return i;
		}
	}
	public int feiBoLaQieShuLie(int n){
		if(n<=2){
			return 1;
		}
		int i = feiBoLaQieShuLie(n - 1) + feiBoLaQieShuLie(n - 2);
		return i;
	}
	public int jiecheng(int n){
		if(n==1){
			return 1;
		}
		return n*jiecheng(n-1);
	}

	public static void main(String[] args) {
		Triangle triangle = new Triangle();
//		System.out.println(triangle.triangle(3));
//		triangle.feiBoLaQieShuLie(6);
		System.out.println(triangle.jiecheng(5));
	}

	private static void yangHuiSanjiao(int NMAX) {
		// allocate triangular array
		int[][] odds = new int[NMAX + 1][];
		for (int n = 0; n <= NMAX; n++)
			odds[n] = new int[n + 1];

		// fill triangular array
		for (int n = 0; n < odds.length; n++)
			for (int k = 0; k < odds[n].length; k++)
			{
				/*
				 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
				 */
				int lotteryOdds = 1;
				for (int i = 1; i <= k; i++)
					lotteryOdds = lotteryOdds * (n - i + 1) / i;

				odds[n][k] = lotteryOdds;
			}

		// print triangular array
		for (int[] row : odds)
		{
			for (int odd : row)
				System.out.printf("%4d", odd);
			System.out.println();
		}
	}
}
