package BT;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static List<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    inputStudent();
                    break;
                case 2:
                    editById();
                    break;
                case 3:
                    deleteById();
                    break;
                case 4:
                    sortByMark();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    displayStudent();
                    break;
                case 7:
                    saveFile();
                    break;
                case 8:
                    readFile();
                    break;
                case 9:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Nhập sai");
                    break;
            }
        } while (choose != 9);
    }

    private static void readFile() {
    }

    private static void saveFile() {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream("student.txt");
            for(Student student:studentList){
                String line=student.getFileSave();
                byte[] b=line.getBytes();
                fileOutputStream.write(b);
            }
        }catch (FileNotFoundException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayStudent() {
        for (Student student:studentList){
            student.display();
        }
    }

    private static void sortByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    private static void sortByMark() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getMark()>o2.getMark()){
                    return -1;
                }
                return 1;
            }
        });
    }

    private static void deleteById() {
        System.out.println("Nhập ID sinh viên muốn xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                break;
            }
        }
    }

    private static void editById() {
        System.out.println("Nhập ID sinh viên muốn sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.input();
                break;
            }
        }
    }

    private static void inputStudent() {
        System.out.println("Nhập số sinh viên cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.input();
            studentList.add(student);
        }
    }

    static void showMenu() {
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Chỉnh sửa theo ID");
        System.out.println("3. Xóa theo ID");
        System.out.println("4. Sắp xếp theo điểm");
        System.out.println("5. Sắp xếp theo tên");
        System.out.println("6. Hiển thị thông tin sinh viên");
        System.out.println("7. Lưu file");
        System.out.println("8. Đọc file");
        System.out.println("9. Exit");
        System.out.println(" Chọn: ");

    }

}
