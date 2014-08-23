package com.jd.f1.guomin;

import com.jd.f1.Solution;


/**
 *
 * @author: GuoMin
 * @since:  2013-10-23
 *
 */
public class P3 implements Solution<Integer, Integer>
{

	public static void main(String[] args)
	{
		//205891132094649
		//18446744073709551616=2^64
		//1267650600228229401496703205376=2^100
		//2^64*2^64*2^64...15...*2^40
		//Long.MAX_VALUE * ... * Long.MAX_VALUE (15) * Integer.MAX_VALUE * 2^8
		long start = System.currentTimeMillis();
		int maxDigest = 1000;
		System.out.println("2^" + maxDigest + "结果：" + count(maxDigest));
		System.out.println("time:" + (System.currentTimeMillis()-start) + "毫秒");
		start = System.currentTimeMillis();
		System.out.println("2^" + maxDigest + "结果：" + count2(maxDigest));
		System.out.println("time:" + (System.currentTimeMillis()-start) + "毫秒");
		System.out.println(Math.pow(9, 10));
		start = System.currentTimeMillis();
		P3 p = new P3();
		System.out.println(p.run(maxDigest));
		System.out.println("time:" + (System.currentTimeMillis()-start) + "毫秒");
	}
	
	public static int count(int maxDigest)
	{
		int[] digests = new int[1000];
		int n = 1;
		int maxLength = 0;
		while(n <= maxDigest)
		{
			if(n == 1)
			{
				digests[n-1] = 2;
				maxLength++;
			}
			else
			{
				int bit = 0;
				for(int m = 0; m < maxLength; m++)
				{
					int result = digests[m] * 2 + bit;
					if(result >= 10)
					{
						bit = result / 10;
						result = result % 10;
						if(m == maxLength - 1)
						{
							maxLength++;
						}
					}
					else
					{
						bit = 0;
					}
					digests[m] = result;
				}
			}
			n++;
		}
		//10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376
//		StringBuffer sb = new StringBuffer();
		int total = 0;
		for(int b = maxLength-1; b >= 0; b--)
		{
//			sb.append(digests[b]);
			total += digests[b];
		}
//		System.out.println(sb);
		return total;
	}
	
	public static int count2(int maxDigest)
	{
		int total = 0;
		int[] digests = new int[1000];
		int n = 1;
		int maxLength = 0;
		//2^64=18446744073709551616
		if(maxDigest >= 64)
		{
			String str = "18446744073709551616";
			n = 65;
			maxLength = str.length();
			int i = 0;
			while(i < maxLength)
			{
				digests[i] = str.charAt(i) - 48;
				i++;
			}
		}
		
		while(n <= maxDigest)
		{
			if(n == 1)
			{
				digests[n-1] = 2;
				maxLength++;
			}
			else
			{
				int bit = 0;
				for(int m = 0; m < maxLength; m++)
				{
					int result = digests[m] * 2 + bit;
					if(result >= 10)
					{
						bit = result / 10;
						result = result % 10;
						if(m == maxLength - 1)
						{
							maxLength++;
						}
					}
					else
					{
						bit = 0;
					}
					digests[m] = result;
				}
			}
			n++;
		}
		for(int b = maxLength-1; b >= 0; b--)
		{
			total += digests[b];
		}
		return total;
	}

	@Override
	public Integer run(Integer input)
	{
		return count(input.intValue());
	}

	@Override
	public String getAuthor()
	{
		return "GuoMin";
	}
}
