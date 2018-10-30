package Collections;

import java.util.*;

public class CollectionsConverter {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        ArrayList<Integer> arrayList = new ArrayList<>(linkedList);

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        hashMap.put(1, linkedList);
        hashMap.put(2, arrayList);

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(hashMap);

        System.out.println(hashMap.entrySet());
        Set<Map.Entry <Integer, List<Integer>>> entrySet = hashMap.entrySet();
        List<Map.Entry <Integer, List<Integer>>> entrySetList = new ArrayList<>(entrySet);
        Map.Entry<Integer, List<Integer>> integerListEntry = entrySetList.get(1);
        List<Integer> value = integerListEntry.getValue();
        Integer integer = value.get(1);
        System.out.println(entrySetList.get(1).getValue().get(1));

    }
}
