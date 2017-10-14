import java.util.*;
public class Tst {
public static void main(String[] args) {
	Integer[] ints = new Integer[]{1,2,3};
	Number[] nums = ints;
	nums[2] = 3.14;
	
	List<Integer> in = Arrays.asList(1,2,3,4);
	List<? super Number> nu  = new ArrayList<>();
	nu.add(new Integer(1));
	nu.add(1.1d);
	
}
}
