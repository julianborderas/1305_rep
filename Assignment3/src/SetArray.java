public class SetArray {

   Integer []arr = new Integer[1];
   int size = 0;


   void resize(){
      Integer []arr_size = new Integer [arr.length * 2];
      for ( int i = 0 ; i< arr.length;i++){
         arr_size[i] = arr[i];
      }
      arr = arr_size;
   }

   int getSize(){return size;}

   void add(int a){
      if(!contains(a)) {
         if (size <= .8 * arr.length)
            resize();
         arr[size++] = a;
      }
   }

   boolean contains(int a) {
      for(int i = 0; i < size; i++)
         if(arr[i] == a)
            return true;

      return false;
   }

   boolean isEmpty() {
      return size == 0;
   }

   void remove(int a) {
      int i;
      for( i = 0; i < size; i++)
         if(arr[i] == a)
            break;
      while( i < size){
         arr[i] = arr[i+1];
         i++;
      }
      size--;
   }

   Integer[] toArray() {
      Integer[]diff_arr = new Integer[size];
      for(int i = 0 ; i <diff_arr.length; i++ )
         diff_arr[i] = arr[i];
      return  diff_arr;
   }

   static SetArray intersection(SetArray setA, SetArray setB){

      SetArray inter = new SetArray();

      Integer[] setA_array = setA.toArray();
      for(int i = 0 ;  i < setA_array.length ; i++){
         if(setB.contains(setA_array[i]))
            inter.add(setA_array[i]);
      }
      return inter;

   }

   public static void main(String[] args) {
      SetArray setA = new SetArray();

      setA.add(4);
      setA.add(20);
      setA.add(7);
      setA.add(32);
      setA.add(10);
      setA.add(15);

      SetArray setB = new SetArray();

      setB.add(3);
      setB.add(23);
      setB.add(20);
      setB.add(9);
      setB.add(15);

      SetArray intSet = intersection(setA,setB);

      //for(int i = 0; i < intSet.size; i++){
      //   System.out.println(intSet[i]);
      //}

   }

}
