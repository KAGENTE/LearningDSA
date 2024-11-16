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

        quickSort(array,0, array.size()-1);
        System.out.println(bynarySearch(array, 31));
        System.out.println(array);
    }

    public static ArrayList<Integer> arraySort(ArrayList<Integer> list){
        int menor = 0;
        int indexJ= 0;
       for(int i = 0;i< list.size();i++){
        menor = list.get(i);
        indexJ = i;
        for (int j = i+1; j< list.size();j++){
            if( list.get(j)< menor){
                menor = list.get(j);
                indexJ = j;
            }
        }

        int temp = list.get(i);
        list.set(i,  menor);
        list.set(indexJ, temp);
       }
       return list;
    }
    
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

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list){
        int temp;
            for(int i= 0;i < list.size();i++){
                for(int j=0;j< list.size()-i-1;j++){
                    if(list.get(j)>list.get(j+1)){
                        temp = list.get(j);
                        list.set(j, list.get(j+1));
                        list.set(j+1, temp);
                    }
                }
            }
            return list;
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