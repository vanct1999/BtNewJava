package BT;

import java.util.Scanner;

public class Student {

    private int id;
    private int age;
    private String name;
    private String address;
    private float mark;

    public Student() {

    }

    public Student(int id,int age, String name, String address, float mark) {
        this.id=id;
        this.age = age;
        this.name = name;
        this.address = address;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID: ");
        id = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên: ");
        name = sc.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = sc.nextLine();

        System.out.println("Nhập tuổi: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập điểm: ");
        mark = Float.parseFloat(sc.nextLine());

    }

    public void display() {
        System.out.println(this);
    }

    public String getFileSave() {
        return id + ", " + name + ", " + age + ", " + mark + ", " + address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mark=" + mark +
                '}';
    }
}
