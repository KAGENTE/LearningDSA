import java.util.ArrayList;


class DataStructures{
    
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(4);
        array.add(2);
        array.add(15);
        array.add(6);
        array.add(21);
        array.add(7);
        array.add(9);
        array.add(5);
        array.add(3);
        array.add(8);
        array.add(12);
        array.add(31);
        System.out.println(array);

        selectionSort(array);
        System.out.println(bynarySearch(array, 31));
        System.out.println(array);
    }

    public static void selectionSort(ArrayList<Integer> list){

        for(int i = 0; i < list.size(); i++){//loop through the indexes of the array that will be tested if is greather than j later
            int lowestIndex = i;// set a variable with the number inside the index of i so it can be tested
            for(int j = i+1 ; j < list.size() ;j++){//now a loop to test if the value is less than the rest of the array
                if(list.get(lowestIndex)> list.get(j)){
                    lowestIndex = j;
                }
            }
            swap(list, lowestIndex, i); //now working with the indexes instead of the numbers it self we can use the new swap method
        }
        
    }
/*             int temp = list.get(i);//swap the values of the current index to the lowest number encountered on the remaining array
            list.set(i, lowest);//cant be switched to swap method since we are not swiching indexes but abstraction of lowest number
            list.set(j, temp); */
           
    

        /* for(int i = 0;i< list.size();i++){           Code i made  in the fist contact with DSA and selection sort
            int menor = list.get(i);                    had some troubble to understand but tried to do by myself knowing it wont be as good as it coud be
            int indexJ = i;                         
            for (int j = i+1; j< list.size();j++){ 
                if( list.get(j)< menor){
                    menor = list.get(j);
                    indexJ = j;
                }
            }

            int temp = list.get(i);
            list.set(i,  menor);
            list.set(indexJ, temp);
       } */
    
    
    public static int bynarySearch(ArrayList<Integer> list, int target){
        int start = 0;
        int end = list.size()-1;
        int half = 0;
        while(list.get(half) != target){
            half = (end + start)/2;
            if(target > list.get(half)){
                start = half+1;
            }else if (target < list.get(half)){
                end = half-1;
            }
        }return half+1;

    }

    public static void bubbleSort(ArrayList<Integer> list){
            for(int i= 0;i < list.size();i++){
                for(int j=0;j< list.size()-i-1;j++){
                    if(list.get(j)>list.get(j+1)){
                        swap(list, j, j+1);
                    }
                }
            }
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list){
        
        for(int i=1; i < list.size();i++){
            int temp = list.get(i);
            int j = i-1;
            while(j>=0 && list.get(j) > temp){
                list.set(j+1, list.get(j));
                j--;
            }  
            list.set(j+1, temp);
        }
        return list;
    }

    public static void quickSort(ArrayList<Integer> list,int low,int high){
        if(low>=high){
            return;
        }
       int pivot =list.get(high);
       int left = low;
       int right = high;

       while(left < right){

        while (list.get(left) <= pivot && left < right){
           left++; 
        }
        while(list.get(right) >= pivot && left < right){
            right--;
        }
        swap(list, left, right);
       }
       swap(list , left , high);
       quickSort(list, low, left-1);
       quickSort(list, left+1, high);
    }


    private static void swap (ArrayList<Integer> list,int index1,int index2){
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

     
}