/**
 *                            License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS  
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.  
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR  
 * COPYRIGHT LAW IS PROHIBITED.
 * 
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND  
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE  
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED 
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 * 
 */
package com.l1fx.core;

/**
 * 快速亂數產生器
 * @author l1j-tw
 * 
 */
public class Random {
	private static final int _max = Short.MAX_VALUE;

	private static int _idx = 0;

	private static double[] _value = new double[_max + 1];

	static {
		for (_idx = 0; _idx < _max + 1; _idx++) {
			_value[_idx] = (Math.random() + Math.random() + Math.random()
					+ Math.random() + Math.random()) % 1.0;
		}
	}

	/**
	 * 取得隨機值(整數)
	 * 
	 * @param maxValue
	 * @return
	 */
	public static int nextInt(int maxValue) {
		_idx = _idx & _max;
		return (int) (_value[_idx++] * maxValue);
	}

	/**
	 * 取得隨機值(整數)
	 * 
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public static int nextInt(int minValue, int maxValue) {
		_idx = _idx & _max;
		return minValue + (int) (_value[_idx++] * maxValue);
	}

	/**
	 * 取得隨機值(布林)
	 * 
	 * @return
	 */
	public static boolean nextBoolean() {
		return (nextInt(2) == 1);
	}

	/**
	 * 取得隨機值(Byte)
	 * 
	 * @return
	 */
	public static byte nextByte() {
		return (byte) nextInt(256);
	}

	/**
	 * 取得隨機值(Long)
	 * 
	 * @return
	 */
	public static long nextLong() {
		long l = nextInt(Integer.MAX_VALUE) << 32 + nextInt(Integer.MAX_VALUE);
		return l;
	}
}