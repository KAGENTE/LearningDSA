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


              //Old code
/*             int temp = list.get(i);//swap the values of the current index to the lowest number encountered on the remaining array
            list.set(i, lowest);//cant be switched to swap method since we are not swiching indexes but abstraction of lowest number
            list.set(j, temp); */
           
    
            //Even more old code
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
        int start = 0; //first index of the array
        int end = list.size()-1;//size is -1 because of index that starts at 0
        int half = 0;
            while(list.get(half) != target){//need to find the number in the half index
                half = (end+start)/2;// getting to the half of the string
                if(list.get(half) < target){
                    start = half+1;//if target is bigger then you bring the start variable to the number at front of the old half variable
                }
                else if(half > target){
                    end = half-1;//else if target is less than targer then you bring the end variable to the index before
                }
                
            }
            return half+1;//return plus one because array start on 0
        }
    

    public static void bubbleSort(ArrayList<Integer> list){
        for(int i= 0;i < list.size();i++){//first loop to go through the indexes of string
            for(int j=0;j< list.size()-i-1;j++){//second loop to actualy swap the numbers
                if(list.get(j)>list.get(j+1)){
                    swap(list, j, j+1);//here you use the index in front of j instead a value from other loop as the 2 loops will go 
                                       //trough the array 1 time each
                }
            }
        }
    }

    public static void insertionSort(ArrayList<Integer> list){
        
        for(int i=1; i < list.size();i++){//loop through the array but starts at 1 because j will be 1 less than i
            int temp = list.get(i);//hold the value of i that will be changed in the future
            int j = i-1;//1 less than i, will start in index 0
                while(j>=0 && list.get(j) > temp){//test j value with i value that is temp variable
                    list.set(j+1, list.get(j));//set the value of the index in front of j (i) with the j index value
                    j--;//at this point we are bringing all the smallers values to the start so j-- will keep testing values behind the i variable
                }  
        list.set(j+1, temp);//set the value of the number in front of j to the old value of i
        }
    }

    public static void quickSort(ArrayList<Integer> list,int low,int high){
        if(low>=high){//end the loop if the pointers meet
            return;
        }
       int pivot =list.get(high);//the number we need to find the correct position to then divide the array and keep looping till its sorted
       int left = low;
       int right = high;

       while(left < right){//to keep looping till the indexes meet

        while (list.get(left) <= pivot && left < right){//keep adding up to left, highering the index will break if find a number less than the pivot
           left++; 
        }
        while(list.get(right) >= pivot && left < right){//keep subtracting, lowering the index, will break if find a number higher than the pivot
            right--;
        }
        swap(list, left, right);//then when the 2 loops break will swap the numbers
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