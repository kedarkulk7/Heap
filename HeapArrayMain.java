package utd.ds.assign3;

import java.util.Arrays;
import java.util.Random;

public class HeapArrayMain {

	public static void main(String[] args) {

		Random random = new Random();
		//int[] array = {9,7,13,96,15,21,19,77,11,81};
		int[] array = new int[14];
		array[0] = array.length - 1;
		for(int k = 1; k < array.length; k++) {
			array[k] = random.nextInt(100);
		}

		System.out.println("Initial array: ");
		for(Integer i : array) {
			System.out.print(i+" ");
		}
		System.out.println();

		array = createMinHeap(array, 1);
		System.out.println("Heap: ");

		for(Integer i : array) {
			System.out.print(i+" ");
		}
		System.out.println();

		//adding a new number
		int newNo = random.nextInt(100);
		System.out.println("After inserting no: "+newNo);
		
		array = Arrays.copyOf(array, array.length +1);
				
		array[0] = array[0] + 1;
		
		array[array.length - 1] = newNo; 
		array = createMinHeap(array, 1);

		for(Integer i : array) {
			System.out.print(i+" ");
		}
		System.out.println();

		
		//Deleting a no from heap
		
		System.out.println("After deleting a no from heap: ");
		
		
		array[0] = array[0] - 1;
		array[1] = array[array.length - 1];
		array = Arrays.copyOf(array, array.length - 1);
		
		array = createMinHeap(array, 1);
		for(Integer i : array) {
			System.out.print(i+" ");
		}
		System.out.println();

	}

	public static int[] createMinHeap(int[] array, int parentNode) {

		int i = array[0];
		boolean singleChild = false;

		if(array[0] % 2 == 0) {
			singleChild = true;
		}

		while(i > parentNode) {		

			if(singleChild) {
				int root = array[(i+1)/2];
				int child = array[i];
				int min = Math.min(root, child);

				if(child == min) {
					array[i] = root;
					array[(i+1)/2] = min;
				}				

			}else {
				int root = array[i/2];
				int child1 = array[i];
				int child2 = array[i-1];

				int min = Math.min(root, Math.min(child1, child2));

				if(root != min) {
					if(child1 == min) {
						array[i] = root;
						array[(i-1)/2] = child1;
					}else {
						array[i-1] = root;
						array[(i-1)/2] = child2;
					}				

					array = createMinHeap(array, i);
				}			

			}

			if(singleChild) {
				i = i-1;
				singleChild = false;
			}else {
				i = i-2;
			}
		}

		return array;
	}

}
