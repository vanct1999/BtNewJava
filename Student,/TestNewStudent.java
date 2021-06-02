import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TestNewStudent {
    public static void main(String[] args) {
        ArrayList<NewStudent> studentList = new ArrayList<>();
        int choose;
        Scanner scanner = new Scanner(System.in);
        showMenu();
        do {
            System.out.println("Choose: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.print("Nhập số SV: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        NewStudent std = new NewStudent();
                        std.inputInfo();

                        studentList.add(std);
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 3:
                    int minIndex = 0, maxIndex = 0;
                    float minMark, maxMark;
                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();
                    for (int i = 1; i < studentList.size(); i++) {
                        if (studentList.get(i).getMark() < minMark) {
                            minIndex = i;
                            minMark = studentList.get(i).getMark();
                        }
                        if (studentList.get(i).getMark() > maxMark) {
                            maxIndex = i;
                            maxMark = studentList.get(i).getMark();
                        }
                    }
                    System.out.println("Sinh viên có điểm cao nhất: ");
                    studentList.get(maxIndex).showInfo();

                    System.out.println("Sinh viên có điểm thấp nhất: ");
                    studentList.get(minIndex).showInfo();
                    break;
                case 4:
                    System.out.println("Nhập mã sv cần tìm: ");
                    String rollNoSearch = scanner.nextLine();
                    int count = 0;
                    for (NewStudent student : studentList) {
                        if (student.getRollNo().equalsIgnoreCase(rollNoSearch)) {
                            student.showInfo();
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Không tìm thấy ");
                    }
                    break;
                case 5:
                    //Sắp xếp theo A-Z
                    Collections.sort(studentList, new Comparator<NewStudent>() {
                        @Override
                        public int compare(NewStudent o1, NewStudent o2) {
                            int cmp = o1.getName().compareTo(o2.getName());
                            if (cmp >= 0) {
                                return 1;
                            }
                            return -1;
                        }
                    });

                    //Hiển thị
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 6:
                    Collections.sort(studentList, new Comparator<NewStudent>() {
                        @Override
                        public int compare(NewStudent o1, NewStudent o2) {
                            return o1.getMark() >= o2.getMark() ? -1 : 1;
                        }
                    });
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).checkScholarship()) {
                            studentList.get(i).showInfo();
                        }
                    }
                    break;
                case 7:

                    System.out.println("Good bye!");
                    break;
                default:
                    System.err.println("Nhập sai!!!");
            }
        } while (choose != 7);

    }

    static void showMenu() {
        System.out.println("1. Nhập vào N sinh viên");
        System.out.println("2. Hiển thị thông tin sinh viên");
        System.out.println("3. Hiển thị max và min theo điểm TB");
        System.out.println("4. Tìm kiếm theo mã sinh viên");
        System.out.println("5. Sort A-Z theo tên sinh viên và hiển thị");
        System.out.println("6. Hiển thị sinh viên được học bổng và sắp xếp giảm dần");
        System.out.println("7. Thoát");
    }
}
