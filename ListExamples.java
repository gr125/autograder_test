import java.util.ArrayList;
import java.util.List;

interface StringChecker { boolean checkString(String s); }

class ListExamples {

  static List<String> result = new ArrayList<>();
  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    if(list.size() == 0) { return list; }
    result.clear();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(s);
      }
    }
    return result;
  }


  // Takes two sorted list of strings (so "a" appears before "b" and so on),
  // and return a new list that has all the strings in both list in sorted order.
  static List<String> merge(List<String> list1, List<String> list2) {
    List<String> result = new ArrayList<>();
    int index1 = 0, index2 = 0;
    int sizeList1= list1.size();
    int sizeList2= list2.size();
    while(index1 < sizeList1 && index2 < sizeList2) {
      int compared = list1.get(index1).compareTo(list2.get(index2));
      if(compared == 0) {
        result.add(list1.get(index1));
        sizeList1 -= 1;
        sizeList2 -= 1;
      }
      else if(compared < 0) {
        result.add(list1.get(index1));
        sizeList1 -= 1;
      }
      else {
        result.add(list2.get(index2));
        sizeList2 -= 1;
      }
    }
    while(index1 < list1.size()) {
      result.add(list1.get(index1));
      sizeList1 -= 1;
    }
    while(index2 < list2.size()) {
      result.add(list2.get(index2));
      sizeList2 -= 1;
    }
    return result;
  }


}
