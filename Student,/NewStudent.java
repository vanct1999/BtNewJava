import java.util.Scanner;

public class NewStudent extends NewPerson {
    private String rollNo;
    private float mark;
    private String email;

    public NewStudent() {
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("; rollNo: "+ rollNo+"    mark: "+mark+"    email: "+email);
        System.out.println("");
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sv: ");
        while (true) {
            String rollNoInput = input.nextLine();
            boolean check = setRollNo(rollNoInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhập điểm SV: ");
        while (true) {
            float markInput = Float.parseFloat(input.nextLine());
            boolean check = setMark(markInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhập email: ");
        while (true) {
            String emailInput = input.nextLine();
            boolean check = setEmail(emailInput);
            if (check) {
                break;
            }
        }
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if (rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.out.println("Nhập lại mã SV: ");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.out.println("Nhập lại điểm: ");
            return false;
        }

    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.out.println("Nhập lại mail: ");
            return false;
        }
    }

    public boolean checkScholarship() {
        if (mark >= 8) {
            return true;
        } else {
            return false;
        }
    }
}

