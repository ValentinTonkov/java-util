public class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age){
            return 1;
        } else if (this.age < o.age) {
            return -1;
        }
        return 0;

        // could be replaced with
        // return this.age > o.age ? 1 : this.age < o.age ? -1 : 0;
        // or
        // return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

}
