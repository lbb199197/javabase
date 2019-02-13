package com.jiebing.algorithm;

/**
 * test
 */
public class App {

	/**
	 * 移位字符到最后
	 * 
	 * @author libb
	 * @date 2019年2月13日
	 * @param a
	 * @param n
	 */
	public static void LeftShiftOne(char[] s, int n) {
		char t = s[0];// 保存第一个字符
		for (int i = 1; i < n; i++) {
			s[i - 1] = s[i];
		}
		s[n - 1] = t;
	}

	/**
	 * 多个字符一起移位到最后（方法一）
	 * 
	 * @author libb
	 * @date 2019年2月13日
	 * @param a
	 * @param n
	 */
	public static void LeftRotateString(char[] s, int n, int m) {
		while (m-- > 0) {
			LeftShiftOne(s, n);
		}
	}

	/**
	 * 将一个字符数组某段位置翻转
	 * 
	 * @author libb 
	 * @date 2019年2月13日
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void ReverseString(char[] s, int from, int to) {
		while (from < to) {
	        char t = s[from];
	        s[from++] = s[to];
	        s[to--] = t;
	    }
	}
	
	/**
	 * 多个字符一起移位到最后（方法二）
	 * 
	 * @author libb 
	 * @date 2019年2月13日
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void LeftRotateStringTwo(char[] s,int n,int m) {
	    m %= n;               //若要左移动大于n位，那么和%n 是等价的
	    ReverseString(s, 0, m - 1); //反转[0..m - 1]，套用到上面举的例子中，就是X->X^T，即 abc->cba
	    ReverseString(s, m, n - 1); //反转[m..n - 1]，例如Y->Y^T，即 def->fed
	    ReverseString(s, 0, n - 1); //反转[0..n - 1]，即如整个反转，(X^TY^T)^T=YX，即 cbafed->defabc。
	}

	public static void main(String[] args) {
		char[] s = { 'a', 'b', 'c', 'd', 'e', 'f' };
//		LeftShiftOne(s, 6);
//		LeftRotateString(s, s.length, 3);
//		ReverseString(s, 1, 3);
		LeftRotateStringTwo(s, s.length, 4);
		System.out.println(s);
	}

}