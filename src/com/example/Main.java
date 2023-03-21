package com.example;

import com.example.myexceptions.PasswordCompositionException;
import com.example.myexceptions.WrongLoginException;
import com.example.myexceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {

        System.out.println(validate("java_skypro.go", "ddd", "ddd"));

    }

    public static boolean validate(String login, String password, String confirmPassword) {

        try {
            if (!login.matches("[.\\w]{1,20}")) {
                throw new WrongLoginException();
            }
            if (!password.matches("\\w{1,19}")) {
                throw new PasswordCompositionException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }

        } catch (WrongLoginException e) {
            System.out.println("Параметр Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания." +
                    "\n Длина должна быть меньше или равна 20 символам.");
            return false;
        } catch (PasswordCompositionException e) {
            System.out.println("Параметр Password должен содержать в себе только латинские буквы, цифры и знак подчеркивания." +
                    "\n Длина должна быть меньше 20 символам.");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Password и confirmPassword не совпадают");
            return false;
        }

        return true;
    }
}