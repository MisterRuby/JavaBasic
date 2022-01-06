package setCollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetCollection {

	public static void main(String[] args) {
		
		/**
		 * Set : collection 계열 중 하나. List와 달리 인덱스가 아닌 값으로 내부 값을 탐색한다. 때문에 내부에 중복된 값을 저장할 수 없다.
		 */
		Set<String> stringSet = new HashSet<>();
		
		stringSet.add("ruby");
		stringSet.add("ruby");
		
		System.out.println(stringSet.size());		// 1, 중복된 값은 저장되지 않는다.
		
		/**
		 * Iterator : 반복자
		 */
		Iterator<String> iterator = stringSet.iterator();
		
		int total = 0;
		
		/**
		 * hasNext() : 다음 요소(원소)가 있는지 확인해서 그 결과를 진리값으로 반환하는 메서드
		 */
		while(iterator.hasNext()) {
			iterator.next();
			total++;
		}
		
		System.out.println(total == 2);
	}

}


/*
Collection
	List	- 값들을 인덱스를 통해 검색해서 조회할 수 있는 구조
	Set		- 값들을 값으로 검색해서 조회할 수 있는 구조
	
Map	- 키와 값이 한 쌍으로 이루어져 있는 구조. 키를 통해 해당되는 값을 조회할 수 있으며 키값은 서로 중복될 수 없다.
*/