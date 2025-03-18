import java.util.Scanner;

public class PasswordChecker {
    private Integer minLen;
    private Integer maxRep;
    Scanner sc = new Scanner(System.in);
    public void setMinLength() throws IllegalArgumentException {
        System.out.println("Введите мин. длину пароля: \n");
        int a = sc.nextInt();
        if (a <= 0) {
            throw new IllegalArgumentException("Минимальная длина пароля должна быть меньше 0!");
        }
        minLen = a;
    }
    public void setMaxRepeats() throws IllegalArgumentException {

        System.out.println("Введите максимально допустимое количество повторений символа подряд: \n");
        int a = sc.nextInt();
        if (a <= 0) {
            throw new IllegalArgumentException("Макс. допустимое количество повторений не может быть меньше или равна 0!");
        }
        maxRep = a;
    }

    public boolean verify(String password) throws IllegalStateException {
        boolean res = true;
        int cnt = 0;
        boolean cntBool = cnt <= maxRep;
        char prevChar;
        if (maxRep == null || minLen == null) {
            throw new IllegalStateException("Вы не задали параметры для проверки пароля!");
        }
        if (password.length() < minLen) {
            res = false;
        }
        for (int cycle = 0; cycle < password.length(); cycle++) {
            if (cnt <= maxRep) {
                if (cycle != 0) {
                    System.out.println(password.charAt(cycle));
                    System.out.println(password.charAt(cycle - 1));
                    if (password.charAt(cycle) == password.charAt(cycle-1)) {
                        cnt++;
                    } else  {
                        cnt = 0;
                    }
                }
            } else {
               break;
            }
        }
        if (cnt > maxRep){
            res = false;
        }
        System.out.println(res);
        return res;
    }


}
