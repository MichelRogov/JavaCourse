package Reflection;

import Multithreading.Printers.Printer;

public class RefelctionHelperTestApp {
    public static void main(String[] args) {
        int interval = 100;
        Printer printer = ReflectionHelper.instantiate(Printer.class, "Symbol", interval);
        System.out.println(printer.getSymbols());

        System.out.println(ReflectionHelper.getFieldValue(printer, "interval"));
    }
}
