package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Subset2 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		// arr.add(9);
		// arr.add(7);
		// arr.add(6);
		// arr.add(11);
		arr.add(6);
		arr.add(6);
		arr.add(3);
		arr.add(3);
		arr.add(6);
		arr.add(5);
		Subset2 obj = new Subset2();
		System.out.print(obj.subsetsWithDup(arr));

	}

	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	HashSet<ArrayList<Integer>> check = new HashSet<>();

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		Collections.sort(A, Collections.reverseOrder());
		subset(A, 0, new ArrayList<Integer>());
		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				if (!o1.isEmpty() && !o2.isEmpty()) {
					int i = 0;
					int value = o1.get(i).compareTo(o2.get(i));
					while (value == 0) {
						i++;
						if (i < o1.size() && i < o2.size()) {
							value = o1.get(i).compareTo(o2.get(i));
						} else {
							return value;
						}
					}
					return value;
				}

				else {
					return 1;
				}
			}

		});
		return result;
	}

	public void subset(ArrayList<Integer> A, int idx, ArrayList<Integer> temp) {
		if (idx == A.size()) {
			Collections.sort(temp);
			if (!check.contains(temp)) {
				check.add(new ArrayList<Integer>(temp));
				result.add(new ArrayList<Integer>(temp));
			}
			return;
		}
		ArrayList<Integer> arr = new ArrayList<>(temp);

		subset(A, idx + 1, arr);
		arr.add(A.get(idx));
//		Collections.sort(arr);
		subset(A, idx + 1, arr);
	}
}
