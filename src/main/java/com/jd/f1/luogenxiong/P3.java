package com.jd.f1.luogenxiong;

import com.jd.f1.Solution;

public class P3 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        return calculte(input);
    }

    @Override
    public String getAuthor() {
        return "luogenxiong";
    }
    
	public int multiply(int a[],int loop_time,int init_length,int power){
		int temp = 0,reminder = 0;
		for (int k = 0; k < loop_time; k++) {
			int n = 0;
			int carry = 0;
			for (; n < init_length ; n++) {
				temp = (a[n]<<power) + carry;
				reminder = temp % 10;
				carry = temp / 10;
				a[n] = reminder;
			}
			a[n] = carry;
			if(a[n]>0)
				init_length++;
			
			while(a[n] >= 10){
				a[n+1] += a[n] / 10;
				a[n] = a[n] % 10;
				init_length++;
				n++;
			}
		}
		return init_length;
	}
	
	
	public int calculte(int m){
		int result [] = new int[m/3 + 1];
		int sum = 0;
		int init_length = 0;
		if (m < 31){
			int base = 1<<m;
			while (base > 0){
				result[init_length] = base % 10;
				base /= 10;
				init_length++;
			}
		}else {
			int num = (1<<31) - 1;
			while (num > 0){
				result[init_length] = num % 10;
				num /= 10;
				init_length++;
			}
			
			result[0] += 1;
			
			int fixed_power = 27;
			int loop = (m - 31) / fixed_power;
			int power = (m - 31) % fixed_power;
			
			init_length = multiply(result,loop,init_length,fixed_power);
			multiply(result,1,init_length,power);
		}
		
		for (int i = 0; i < result.length; i++) {
			sum += result[i];
		}
		return sum;
	}
}
