import java.util.Scanner;

public class NewPerson {
    private String name;
    private String gender;
    private String birthday;
    private String address;

    public NewPerson() {
    }

    public NewPerson(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public void inputInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        name = input.nextLine();
        System.out.println("Giới tính: ");
        gender = input.nextLine();
        System.out.println("Ngày sinh: ");
        birthday = input.nextLine();
        System.out.println("Địa chỉ: ");
        address = input.nextLine();
    }

    public void showInfo() {
        System.out.print("Tên: " + name + "   Giới tinh: " + gender +
                "    Ngày sinh: " + birthday + "    Địa chỉ: " + address);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
