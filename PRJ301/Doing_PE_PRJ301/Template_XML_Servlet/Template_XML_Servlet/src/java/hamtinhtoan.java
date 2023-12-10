
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC-Phong
 */
public class hamtinhtoan {
 //   --Check số nguyên tố
 public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

public int tinhGiaiThua(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int giaiThua = 1;

            for (int i = 2; i <= n; i++) {
                giaiThua *= i;
            }

            return giaiThua;
        }
    }

public int age(String dob_raw) {
         String dobArr[] = dob_raw.split("-");
         LocalDate cur = LocalDate.now();
        return cur.getYear() -Integer.parseInt(dobArr[0]);
    }


//code.startsWith("FPT") : kiểm tra cái thằng code có bắt đầu bằng FPT không
//tương với endWith("FPT"): kiểm tra kết thúc xxxxFPT->true xxxxFPTxxx->false

     











}
