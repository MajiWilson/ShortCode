package ds_type.array;

public class Test {

    public static void main(String[] args){

        FindMinInArray findMinInArray = new FindMinInArray();
        int[] arr1 = {6,7,1,2,3,4};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = {5,6,7,8,9,1,2,3};
        int[] arr4 = {1,2,3,4,5,6,7,8};

        System.out.println(findMinInArray.findMin2(arr1));
        System.out.println(findMinInArray.findMin2(arr2));
        System.out.println(findMinInArray.findMin2(arr3));
        System.out.println(findMinInArray.findMin2(arr4));


        System.out.println(findMinInArray.findMax(arr1));
        System.out.println(findMinInArray.findMax(arr2));
        System.out.println(findMinInArray.findMax(arr3));
        System.out.println(findMinInArray.findMax(arr4));

        System.out.println("**********************************************");
        int[] nums1 = {9,7,6,3,4,5,8,10};
        int[] nums2 = {1,2,3,4,5,6,7};
        int[] nums3 = {8,7,6,4,1};

        FindNumInValley findNumInValley = new FindNumInValley();
        System.out.println(findNumInValley.findMin(nums1));
        System.out.println(findNumInValley.findMin(nums2));
        System.out.println(findNumInValley.findMin(nums3));



    }

}
