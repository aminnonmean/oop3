import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        PasswordChecker a = new PasswordChecker();
        Scanner sc = new Scanner(System.in);
        a.setMinLength();
        a.setMaxRepeats();
        String inp;
        boolean iscont = true;
        while (iscont) {
            System.out.println("Введите пароль или end");
            inp = sc.next();
            if (inp.equals("end")) {
                iscont = false;
                break;
            }
            if (a.verify(inp)) {
                System.out.println("Подходит!");
            } else {
                System.out.println("Не подходит!");
            }

            }
        }
    }
