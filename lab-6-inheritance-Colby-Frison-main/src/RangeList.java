public class RangeList extends IntegerList{
    
    RangeList() {
        super();
    }

    RangeList(int lower, int upper){
        int temp = 0;
        if(lower > upper){
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        }
        else{
            for(int i = lower; i <= upper; i++){
                super.insert(temp, i);
                temp++;
            }
        }
    }

    public void add(int lower, int upper) throws IllegalArgumentException {
        if(lower > upper){
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        }  
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        int min = array[0];
        if(lower < min){
            min = lower;
        }
        if(upper > max){
            max = upper;
        }
        int temp = min;
        if(array.length < (max - min + 1)){
            array = new int[max - min + 1];
            size = max - min + 1;
        }
        for(int i = 0; i < array.length ; i++){
            array[i] = temp;
            temp++;
        }


    }

    public void remove(int lower, int upper) throws IllegalArgumentException {
        if(lower > upper){
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        } 
        else if(size == 0){
            throw new UnsupportedOperationException ("Cannot remove range from an empty list.");
        } 
        else if(lower < array[0] || upper > array[size - 1]){
            throw new IllegalArgumentException  ("Lower and/or upper bounds are out of the current list range.");
        }
        else if(lower != array[0] && upper != array[size]){
            throw new IllegalArgumentException  ("Cannot remove non-terminal ranges.");
        }
        else{
            int min = lower;
            do{
                remove(indexOf(min));
                min++;
            }while(min <= upper);
        }

        
    }

    public void insert(int num, int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void add(int num) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
