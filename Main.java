
import java.util.*;

class home {
    home() {
        String[] arr = { "\n 1:- PIN CHANGE", "\n 2:-  WITHDRAWAL", "\n 3:- BALANCE ENQUARY", "\n 4:- CREATE ACCOUNT" };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        } // it prints all option
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {// all opration perform according to No
            case 1:
                modify_details edit = new modify_details();
                edit.modify_details();
                break;
            case 2:
                withdraw_mony withdraw = new withdraw_mony();
                withdraw.withdraw();
                break;
            case 3:
                Balance_check obj_of_balance = new Balance_check();
                obj_of_balance.Check_balance();
                break;
            case 4:
                New_account new_account_obj = new New_account();
                new_account_obj.new_account();
            default:
                System.out.println("enter valid input");
        }
    }
}

// it check tha user account balance
class Balance_check {
    Scanner input = new Scanner(System.in);
    User_details obj = new User_details();

    public void Check_balance() {
        System.out.println("please Enter your Account no:-");
        boolean user_bool = true;
        boolean bol1;
        while (user_bool) {
            bol1 = obj.accountno(input.nextInt());
            if (bol1) {
                user_bool = false;
            } else {
                System.out.println("Enter right Account No");
            }
        }
        user_bool = true;
        System.out.println("Please enter Password");
        while (user_bool) {
            bol1 = obj.password(input.next());
            if (bol1) {
                user_bool = false;
                System.out.println("Your balance is " + obj.userammount());
            } else {
                System.out.println("please Enter right password");
            }
        }
    }
}

// withdrow money class
class withdraw_mony {
    public void withdraw() {
        System.out.println("Please Enter Your Account No:- ");
        boolean user_account_true = true;
        User_details user_details_obj = new User_details();
        Scanner input = new Scanner(System.in);
        String user_name = "hi";
        // wheck tha account no is valid or not
        while (user_account_true) {
            int accountno = input.nextInt();
            boolean bool1 = user_details_obj.accountno(accountno);
            if (bool1) {
                user_account_true = false;
                user_name = user_details_obj.username(accountno);
            } else {
                System.out.println("Account not found\n enter valid account No:-");
            }
        }
        user_account_true = true;
        System.out.println("Please Enter your password");
        // wheck tha password no is valid or not
        while (user_account_true) {
            boolean bool2 = user_details_obj.password(input.next());
            if (bool2) {
                user_account_true = false;
            } else {

                System.out.println("Please Enter your right password");
            }
        }
        System.out.println("Dear " + user_name + " please enter ammount");
        user_account_true = true;
        while (user_account_true) {
            boolean ammount = user_details_obj.ammount(input.nextInt());
            if (ammount) {
                System.out.println("Your Payment is recived");
                home home = new home();
            } else {
                System.out.println("Balence is not more\n please enter less ammount");
            }
        }
    }
}

class modify_details {
    Scanner input = new Scanner(System.in);

    public void modify_details() {
        System.out.println("Please Enter your ATM NO ");
        User_details obj1 = new User_details();
        boolean user_right_account = true;
        while (user_right_account) {
            int Account_number_user = input.nextInt();
            if (obj1.accountno(Account_number_user)) {
                user_right_account = false;
            } else {
                System.out.println("Wrong NO \n please right no");
            }
        }
        System.out.println("Enter your password ");
        user_right_account = true;
        while (user_right_account) {
            String user_password = input.next();
            if (obj1.password(input.next())) {
                user_right_account = false;
            } else {
                System.out.println("Wrong \n Enter again!");
            }
        }
        user_right_account = true;
        while (user_right_account) {
            System.out.println("Enter your New password ");
            String new_password = input.next();
            System.out.println("Enter your New Repassword ");
            String new_repassword = input.next();
            if (new_repassword.equals(new_password)) {
                obj1.change_password(new_repassword);
                System.out.println("Password Changed");
                home home = new home();
                user_right_account = false;
            } else {
                System.out.println("password wrong");
            }
        }
    }
}

class User_details {
    private String password = "123019";
    private int account_no = 1304850100;
    private String username = "shivam kumar";
    private double user_ammount = 12344.32;

    // Scanner input=new Scanner(System.in);
    public void change_password(String new_repassword) {
        this.password = new_repassword;
    }

    public boolean password(String password_in) {
        if (password_in.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean accountno(int accountno_in) {
        if (accountno_in == this.account_no) {
            return true;
        } else {
            return false;
        }
    }

    public String username(int accountno) {
        return this.username;
    }

    public double userammount() {
        return this.user_ammount;
    }

    public boolean ammount(int ammount) {
        if (ammount <= user_ammount) {
            this.user_ammount -= ammount;
            return true;
        } else {
            return false;
        }
    }

    public void create_Account(int Account_no, String repassword, String username) {
        user_ammount = Account_no;
        password = repassword;
        this.username = username;
    }
}

class Main {
    public static void main(String args[]) {
        home home = new home();

    }
}

class New_account {
    User_details obj1 = new User_details();
    Scanner input = new Scanner(System.in);

    public void new_account() {
        System.out.println("Enter Your 10 last digit no");
        int Account_no;
        Account_no = input.nextInt();
        System.out.println("Enter Your name");
        String User_name = input.next();

        String password;
        boolean bool1 = true;
        while (bool1) {
            System.out.println("Enter Your password no");
            password = input.next();
            System.out.println("Enter Your repassword no");
            String repassword = input.next();
            if (password.equals(repassword)) {
                obj1.create_Account(Account_no, repassword, User_name);
                System.out.println("Your Account created Successfully");
                bool1 = false;
                home home = new home();
            } else {
                System.out.println("Enter right password ");
            }
        }
    }
}