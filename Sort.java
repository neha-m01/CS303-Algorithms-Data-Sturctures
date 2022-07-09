package mergeSort;

public class Sort{
	
	public static void merge(int[] list, int l, int mid, int h) {
		
		//creating temporary Arrays that are subarrays of int[] list.
		int lArray[] = new int[mid - l + 1];
		int rArray[] = new int[h - mid];
		
		//inputting subarrays into the temporary arrays
		for (int i = 0; i < lArray.length; i++) {
			lArray[i] = list[l + i];
		}
		for (int i = 0; i < rArray.length; i++) {
			rArray[i] = list[mid + i + 1];
		}
		
		//index of the temporary subarrays
		int li = 0;
		int ri = 0;
		
		//inputting the new values from left and right arrays into the main array(list).
		for (int i = l; i < h + 1; i++) {
			if (li < lArray.length && ri < rArray.length) {
				if (lArray[li] < rArray[ri]) {
					list[i] = lArray[li];
					li++;
				} else {
					list[i] = rArray[ri];
					ri++;
				}
			} else if (li < lArray.length) {
				// if all elements have been copied from right array, copy the rest of left array into the main array.
				list[i] = lArray[li];
				li++;
			} else if(ri < rArray.length) { 
				// if all elements have been copied from left array, copy the rest of right array into the main array.
				list[i] = rArray[ri];
				ri++;
			}
		}
	}
	
	public static void mergeSort(int[] list, int l, int h) {
		if (h <= l) {
			return;
		}
		int m = ((l + h) / 2);
		mergeSort(list, l, m);
		mergeSort(list, m + 1, h);
		merge(list, l, m, h);
	}

}
