package sort;

/**
 * SelectionSort class
 * 选择排序
 * 选择排序的要点是：逐个在剩下的数据里比较，如果比当前数据小，记录下标，直至全部遍历结束后，交换这个下标与当前数据
 * @author zhaoyi
 * @date 18-1-10
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{6,0,4,5,3,1,2,7,8,9};
        int temp;
        int min;
        for (int i = 0; i < array.length; i++) {
            min=i;
            for (int j = i; j < array.length; j++) {
                if (array[j]<array[min]){
                    min=j;
                }
            }
            if (min!=i){
                temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
