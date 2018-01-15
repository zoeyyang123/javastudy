package sort;

/**
 * BubbleSort class
 * 冒泡排序
 * 冒泡排序的要点是：里面一层，要冒泡，看似每个比较都是大的往前交换，实际上是小的往下沉底
 * @author zhaoyi
 * @date 18-1-10
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{0,6,4,5,3,1,2,7,8,9};
        int temp;
        int c1 = 0;
        int c2 = 0;
        boolean flag =false;
        for (int i = 0; i < array.length; i++) {
            flag=true;
            for (int j = array.length-1; j > i; j--) {
                c1++;
                if (array[j-1]>array[j]){
                    c2++;
                    temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
        System.out.println("比较次数："+c1);
        System.out.println("交换次数："+c2);
    }
}
