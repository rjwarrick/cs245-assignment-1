# cs245-assignment-1

Part 2, Requirement 3: "Quicker than Merge Sort"

My implementation of a Merge Sort algorithm merges pairs of already sorted regions inside the array. I accomplished this by modifying the sort and merge function from Merge Sort as well was implementing two other functions, get_sorted and copy_data, that aid in retreving the indices and values of each sorted region. 

My get_sorted function takes in the unsorted double[] array as the parameter and returns an ArrayList, al, that stores only the end indicies of each sorted region, as we do not need the start indicies to know when to sort.

My copy_data function takes in the unsorted double[] array, as well as an int left and int right that serve as the start and end indicies of each sorted region as parameters. This function copies over the values from each sorted region and returns that as a new double[] array called copy.

I modified the merge function from Merge Sort to call my get_sorted function and to store it into a new ArrayList, also called al. I used a while loop that that loops until the size of al is greater than 1, which means that it will keep merging and sorting until the ArrayList al has unsorted regions. It stops when the array is completely sorted. Inside the while loop, I have a for loop that loops through the ArrayList al and skips every other index, as we only need the end indicies. I declared an int start variable that equals 0, which is used to know which regions to merge. It equals 0 to take into account if it is at the start of the array, which has no sorted region yet. After one pass through the loop, start will then equal the starting index of the next sorted region. Then we get the first sorted region, called left, from copy_data which takes in the array arr, start, and current index of al. We also get the second sorted region, called right, also from copy_data, which takes in the array arr, the current index of al + 1, and that sorted region's end, through al.get(i + 1). Then we call our merge function that takes in the array arr, the left and right, and the start variable to merge each pair of sorted regions. After merging, we call al.remove(al.get(i)) that removes that sorted region from the ArrayList al as we do not need it anymore since it is already stored.

Note that this attempted at a Merge Sort inspired sorting algorithm is not quicker than Merge Sort, but after testing, it is on average faster than Selection, Bubble. For smaller array sizes (less than 300,000 items) it is faster than Insertion Sort, but as the array size gets larger (300,000+ items) it starts to become slower than Insertion Sort.

Link to data and graphs for Assignment 1:
https://docs.google.com/spreadsheets/d/1xEMvExnfcpE0sBf4nrnvgM0BVUYM9QFmAY3IQ5BITEk/edit?usp=sharing
