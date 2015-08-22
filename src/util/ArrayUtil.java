/**   
 * @fileName ArrayUtil.java
 * @package util
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-22 下午8:46:42
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-22 下午8:46:42
   * Why & What is modified
 * @version V1.0
 */
package util;

/**
 * @className ArrayUtil
 * @description 数组工具
 * @author sllx
 * @date 2014-5-22 下午8:46:42
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-22 下午8:46:42
 * Why & What is modified
 */
public class ArrayUtil {
	
	
	/**
	 * @title innerMoveBackward
	 * @description 在一个boolean数组内部向后移动,因为是向后移动,为了避免覆盖数据,需要从后向前遍历 
	 * @return void
	 * @param array
	 * @param begin
	 * @param end
	 * @param offset    
	 */
	public static void innerMoveBackward(boolean[] array, int begin, int end, int offset){
		if(begin < 0 ||  end + offset > array.length - 1){
			throw new ArrayIndexOutOfBoundsException(ArrayUtil.class.getName() + ".innerMoveBackward(boolean[] array, int begin, int end, int offset)");
		}
		for(int i=end; i>=begin; i--){
			array[i+offset] = array[i];
		}
	}
	
	
}
