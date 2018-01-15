package sort;

/**
 * InsertSort class
 * 插入排序
 * 如果第i+1个比第i个小 则把第i个记录下来，依次从第i处比较，插入合适的位置，后面的元素依次向后挪移一位
 * @author zhaoyi
 * @date 18-1-11
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{0,6,4,5,3,1,2,7,8,9};
        int temp;
        for (int i = 1; i < array.length; i++) {
            if (array[i]<array[i-1]){
                temp=array[i];
                for (int j = i; j > 0; j--) {
                    if (array[j-1]>temp){
                        array[j]=array[j-1];
                    }else {
                        array[j]=temp;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
