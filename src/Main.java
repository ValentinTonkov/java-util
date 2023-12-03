import java.util.*;

public class Main {
    private static final Printer<Integer> printer = new Printer<>();

    public static void main(String[] args) {
        creatingLists();
        manipulatingLists();
        iteratingCollections();
        setDemonstration();
        mapDemonstration();
        listOfPeople();

        task1();
        task2();
    }

    private static void creatingLists() {
        //creating lists
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("one");
        list.add("three");
        list.add("four");
        list.add("five");

        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(32);
        l1.add(326);
        l1.add(322);

        List<Integer> l2 = new LinkedList<>(l1);

        List<Integer> l3 = new LinkedList<>(List.of(1, 2, 3, 45, 53));
        List<Integer> l4 = List.of(12, 312, 32, 323, 323);
        System.out.println("new LinkedList<>(List.of(1, 2, 3, 45, 53)) -> " + l3.getClass());
        System.out.println("List.of(12, 312, 32, 323, 323) -> " + l4.getClass());
        //l4.add(90); //will produce UnsupportedOperationException

        Integer[] arr = {12, 212, 323, 32, 677, 86};
        List<Integer> l5 = Arrays.asList(arr);

        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vector = new Vector<>(); // synchronised
        vector.add(1);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.print("The stack contains: ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void manipulatingLists() {
        List<Integer> integers = new LinkedList<>();

        //adding elements:
        integers.add(12);
        integers.add(13);
        integers.addAll(List.of(12, 33, 42, 60, 2));

        System.out.print("\nintegers: ");
        printer.print(integers);

        System.out.println("integers.contains(12) = " + integers.contains(12)); // returns true
        System.out.println("integers.indexOf(33) = " + integers.indexOf(33));
        System.out.println("integers.get(2) = " + integers.get(2));

        Integer i = 2;
        integers.remove(i);      // i is an Object, so method remove(Object o) is called
        System.out.print("after integers.remove(i) -> ");
        printer.print(integers);

        integers.remove(2); // now the element with index 2 will be removed
        System.out.print("after integers.remove(2) -> ");
        printer.print(integers);

        integers.clear();
        System.out.println("after integers.clear(), .isEmpty() = " + integers.isEmpty());
    }

    private static void iteratingCollections() {
        List<Integer> list = List.of(21, 32, 34, 45, 56, 6, 7, 8);

        System.out.println("\n");
        //using for
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //using foreach
        for (Integer i :
                list) {
            System.out.print(i + " ");
        }
        System.out.println();

        //using .forEach
        list.forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        //using iterator and .forEachRemaining
        Iterator<Integer> it = list.iterator();
        it.forEachRemaining(integer -> System.out.print(integer + " "));
        System.out.println();

        //using iterator
        Iterator<Integer> it2 = list.iterator();
        while (it2.hasNext()){
            System.out.print(it2.next() + " ");
        }
        System.out.println();

        //using ListIterator
        ListIterator<Integer> it3 = list.listIterator();
        while (it3.hasNext()){
            System.out.print(it3.next() + " ");
        }
        System.out.println();
        while (it3.hasPrevious()){
            System.out.print(it3.previous() + " ");
        }
        System.out.println("\n");
    }

    private static void setDemonstration() {
        // set doesn't allow duplicates
        Set<Integer> hSet = new HashSet<>(); //unordered
        hSet.add(2);
        hSet.add(3);
        hSet.add(2); //this won't be inserted again and will return false
        hSet.add(1);
        hSet.add(4);
        System.out.print("HashSet -> ");
        printer.print(hSet);

        Set<Integer> linkedSet = new LinkedHashSet<>(); //ordered
        linkedSet.add(2);
        linkedSet.add(3);
        linkedSet.add(2);
        linkedSet.add(1);
        linkedSet.add(4);
        System.out.print("LinkedHashSet -> ");
        printer.print(linkedSet);

        Set<Integer> treeSet = new TreeSet<>(); //sorted
        treeSet.add(2);
        treeSet.add(22);
        treeSet.add(12);
        treeSet.add(-43);
        System.out.print("TreeSet -> ");
        printer.print(treeSet);
    }

    private static void mapDemonstration() {
        Map<Integer, String> people = new HashMap<>(); //unordered
        //Map<Integer, String> people = new LinkedHashMap<>(); //ordered

        people.put(20, "Ivan");
        people.put(21, "Stoyan");
        people.put(22, "Georgi");
        people.put(44, "Simona");

        System.out.println("\nMap..\npeople.get(21) -> " + people.get(21));

        //iterating with .forEach
        people.forEach((i, s) -> System.out.println(i + " " + s));
        System.out.println();

        //iterating with foreach
        for (Map.Entry<Integer, String> entry: people.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }

    private static void listOfPeople() {
        List<Person> people = new LinkedList<>(List.of(
                new Person(23, "Simona"),
                new Person(22, "Stoyan"),
                new Person(25, "Ivan"),
                new Person(19, "Georgi")
        ));
        people.add(new Person(44, "Dimitar"));

        Collections.sort(people);
        System.out.println("sorting list of people by age (Comparable interface)");
        people.forEach(person -> System.out.println(person.getAge() + " " + person.getName()));
    }


    private static void task1() {
        System.out.println("\nTask1");
        Integer[] arr = {5, 0, 3, 1, 2, 3, 0, 0};

        Set<Integer> uniques = new LinkedHashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        for (Integer i :
                arr) {
            if (!uniques.add(i)) {
                duplicates.add(i);
            }
        }

        uniques.removeAll(duplicates);

        System.out.println("numbers: " + Arrays.toString(arr));
        System.out.print("uniques: ");
        uniques.forEach(i -> System.out.printf("%d ", i));
        System.out.println();
        System.out.print("duplicates: ");
        duplicates.forEach(i -> System.out.printf("%d ", i));
        System.out.println("\n");
    }

    private static void task2() {
        String s = "one two one two three four one";

        System.out.println("Task2\nstring: " + s);
        String[] strings = s.split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word :
                strings) {
            if (!map.containsKey(word)){
                map.put(word, 0);
            }
            Integer i = map.get(word);
            i++;
            map.put(word, i);
        }

        map.forEach((w, i) -> {
            System.out.printf("%s : %d\n", w, i);
        });
    }
}