package code;

import java.util.Scanner;

public class SearchingAndSortingEngine {

	public static int[] populateSequentially(int[] array)
	{
		for(int x = 0; x < array.length; x++)
		{
			array[x] = x+1;
		}
		
		return array; 
	}

	public static int[] populateRandomly(int[] array)
	{
		for(int x = 0; x < array.length; x++)
		{
			array[x] = (int)(Math.random()*(101));
			if(array[x] == 0)
			{
				array[x] += 1;
			}
		}
		
		return array; 
	}
	
	public static void display(int[] array)
	{
		for(int x = 0; x < 10; x++)
		{
			for(int y = 0; y<10; y++)
			{
				System.out.print(array[x*10+y] + " ");
				
				if(array[x*10+y]<10 && array[x*10+y]>0)
				{
					System.out.print("  ");
				}
				if(array[x*10+y]<100 && array[x*10+y]>9)
				{
					System.out.print(" ");
				}
			}	
			System.out.println(" ");
		}
	}
	
	public static boolean checkSorted(int[] array)
	{
		boolean sorted = true;
		
		for(int x = 0; x < array.length - 1; x++)
		{
			if(array[x+1] < array[x])
			{
				sorted = false;
			}
		}
		
		return sorted; 
	}
	
	public static int[] shuffle(int[] array)
	{
		
		for(int x = 0; x < array.length; x++)
		{
			int random = (int)(Math.random()*(100));
			
			int temp = array [x];
			array [x] = array [random];
			array [random] = temp;
		}
		
		return array; 
	}
	
	public static int linearSearch(int[] array, int number)
	{
		int index = 0;
		
		for(int x = 0; x < array.length; x++)
		{
			if(array[x] == number)
			{
				index = x;
				break;
			}
		}
		
		return index; 
	}
	
	public static int binarySearch(int[] array, int number)
	{
		if(checkSorted(array) == false)
		{
			System.out.println("Sort first");
			return -1;
		}
		
		int index = 0;
		int left = 0;
		int right = array.length - 1;
		
		if(left == number)
		{
			index = left;
		}
		
		if(right == number)
		{
			while(array[right-1] == array[right])
			{
				right--;
			}
			
			index = right;
		}
		
		while(left < right)
		{
			int middle = (left + right) / 2;
			
			if(array[middle] == number)
			{
				while(array[middle-1] == array[middle])
				{
					middle--;
				}
				
				index = middle;
				break;
			}
			else if(array[middle] > number)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		
		if(left == right || right < left)
		{
			if(array[left] == number)
			{
				index = left;
			}
			else
			{
				System.out.println("Not in array");
				return -1;
			}
		}
		
		return index; 
	}
	
	public static int[] bubbleSort(int[] array)
	{
		
		for(int y = 0; y < array.length - 1; y++)
		{
			for(int x = 0; x < array.length - 1; x++)
			{
				if(array[x+1] < array[x])
				{
					int temp = array[x];
					array[x] = array[x+1];
					array[x+1] = temp;
				}
			}
		}
		return array; 
	}
	
	public static int[] selectionSort(int[] array)
	{
		
		for(int x = 0; x < array.length; x++)
		{
			int lowest = array[x];
			int lowestIndex = x;
					
			for(int y = x; y < array.length; y++)
			{
				if(array[y] < lowest)
				{
					lowest = array[y];
					lowestIndex = y;
				}
			}
			
			int temp = array[x];
			array[x] = array[lowestIndex];
			array[lowestIndex] = temp;
			
		}
		
		return array; 
	}
	
	public static int[] insertionSort(int[] array)
	{
		
		for(int x = 1; x < array.length; x++) 
		{
			int temp = array[x];
			
			int y;
			for(y = (x - 1); y >= 0; y--) 
			{
				if(temp < array[y]) 
				{				
					array[y+1] = array[y]; 
				}
				else
				{
					break;
				}
			}
			
			array[y+1] = temp;
		}
		
		return array; 
	}
	
	public static int[] radixSort(int[] array)
	{
		int[] copy = new int[array.length];
		
		for(int pass = 0; pass < 3; pass++)
		{
			copy = new int[array.length];
			
			for(int x = 0; x < copy.length; x++) 
			{
				int minimum = 10, minimumIndex = 0;	
				
				for(int y = 0; y < array.length; y++)
				{
					if(minimum > digitAt(array[y], pass) && array[y] != 0)
					{
						minimum = digitAt(array[y], pass);
						minimumIndex = y;
					}
				}
				
				copy[x] = array[minimumIndex];
				array[minimumIndex] = 0;
			}
			
			array = copy;

		}
		
		return array; 
	}
	
	public static int digitAt(int number, int position)
	{	
		return number / (int)Math.pow(10, position) % 10;
	}
	
	public static int[] quickSort(int[] array, int begin, int end)
	{
		int leftSlider = begin, rightSlider = end;
		
		while(rightSlider != leftSlider)
		{
			while(array[rightSlider] >= array[leftSlider] && rightSlider != leftSlider)
			{
				rightSlider--;
			}
			
			int temp = array[leftSlider];
			array[leftSlider] = array[rightSlider];
			array[rightSlider] = temp;
			
			while(array[leftSlider] <= array[rightSlider] && rightSlider != leftSlider)
			{
				leftSlider++;
			}
			
			temp = array[leftSlider];
			array[leftSlider] = array[rightSlider];
			array[rightSlider] = temp;
		}

		if(leftSlider - begin > 1)
		{
			quickSort(array, begin, leftSlider-1);
		}
	
		if(end - rightSlider > 1)
		{
			quickSort(array, rightSlider + 1, end);
		}
		
		return array; 
	}
	
	public static int[] mergeSort(int[] array)
	{	
		int middleIndex = (array.length-1)/2;
		int[] leftSide = new int[middleIndex+1];
		int[] rightSide = new int[array.length - (middleIndex + 1)];
		
		for(int x = 0; x < middleIndex + 1; x++)
		{
			leftSide[x] = array[x];
		}
		for(int x = middleIndex + 1; x < array.length; x++)
		{
			rightSide[x - (middleIndex + 1)] = array[x];
		}

		if(leftSide.length > 1)
		{
			mergeSort(leftSide);
		}
		if(rightSide.length > 1)
		{
			mergeSort(rightSide);
		}
		
		merge(array, leftSide, rightSide);
		
		return array;
	}

	public static int[] merge(int[] array, int[] leftSide, int[] rightSide)
	{	
		int l = 0, r = 0, a = 0;
		
		while(l < leftSide.length && r < rightSide.length)
		{
			if(leftSide[l] <= rightSide[r])
			{
				array[a] = leftSide[l];
				l++;
			}
			else
			{
				array[a] = rightSide[r];
				r++;
			}
			
			a++;
		}
		while(l < leftSide.length)
		{
			array[a] = leftSide[l];
			l++;
			a++;
		}
		while(r < rightSide.length)
		{
			array[a] = rightSide[r];
			r++;
			a++;
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		
		int menu = 0;
		int[] array = new int[100];
		Scanner input = new Scanner(System.in);
		
		do
		{
			
			System.out.println("0. Exit\r\n"
					+ "1. Populate the array sequentially from 1 to 100\r\n"
					+ "2. Populate the array randomly with numbers from 1 to 100\r\n"
					+ "3. Checks to see if the array is sorted\r\n"
					+ "4. Displays the array to the screen in a neatly arranged grid with numbers aligned in rows\r\n"
					+ "and columns\r\n"
					+ "5. Shuffles the array\r\n"
					+ "6. Linear search\r\n"
					+ "7. Binary search\r\n"
					+ "8. Sorts the list with bubble sort\r\n"
					+ "9. Sorts the list with selection sort\r\n"
					+ "10. Sorts the list with insertion sort\r\n"
					+ "11. Radix sort\r\n"
					+ "12. Quick sort\r\n"
					+ "13. Merge sort");
			
			menu = input.nextInt();

			if(menu == 1)
			{
				populateSequentially(array);
			}
			if(menu == 2)
			{
				populateRandomly(array);
			}
			if(menu == 3)
			{
				System.out.println(checkSorted(array));
			}
			if(menu == 4)
			{
				display(array);
			}
			if(menu == 5)
			{
				shuffle(array);
			}
			if(menu == 6)
			{
				int number = input.nextInt();
				
				System.out.println(linearSearch(array, number));
			}
			if(menu == 7)
			{
				int number = input.nextInt();
				
				if(binarySearch(array, number) != -1)
				{
					System.out.println(binarySearch(array, number));
				}

			}
			if(menu == 8)
			{
				bubbleSort(array);
			}
			if(menu == 9)
			{
				selectionSort(array);
			}
			if(menu == 10)
			{
				insertionSort(array);
			}
			if(menu == 11)
			{
				array = radixSort(array); //point arraymain at arrayradix
			}
			if(menu == 12)
			{
				quickSort(array, 0, array.length - 1);
			}
			if(menu == 13)
			{
				mergeSort(array);
			}
			
		}while(menu != 0);
	} 

}

