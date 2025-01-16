package org.example.Challenges;

class Main {

    public int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length -1;

        while(low <= high){
            int mid = low + (high  - low)/2;

            if(arr[mid] == target){
                return mid;
            } else if( arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid -1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] nums= {45,5,32,9,68,255,0,6};

        Main obj = new Main();
        int result = obj.binarySearch(nums, 255);
        System.out.println(result);
    }
}