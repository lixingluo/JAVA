package com.nmgtvb.calendar;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("请输入年份");
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		System.out.println("请输入月份");
		int month = scanner.nextInt();
		
		int totalDays = 0;
		for(int i = 1900;i < year;i++) {
			if(isLeapYear(i)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		
		for(int i = 1; i < month;i++) {
			totalDays += getMonthDays(i, year);
		}
		totalDays += 1;
	
		System.out.println(year + "-" + month);
		
		System.out.println("一\t二\t三\t四\t五\t六\t日");
		
		int weekday = totalDays % 7;
		weekday = weekday == 0 ? 7 : weekday;
		for(int i = 1; i < weekday;i++) {
			System.out.print("\t");
		}
		
		int currentMonthDays = getMonthDays(month, year);
		for(int i = 1;i <= currentMonthDays;i++) {
			System.out.print(i);
			if((weekday + i - 1) % 7 == 0) {
				System.out.println();
			} else {
				System.out.print("\t");
			}
		}
		
	}
	
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 ? true : (year % 4 == 0 && year % 100 != 0) ? true : false;
	}
	
	public static int getMonthDays(int month, int year) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			if(isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		default:
			return 30;
		}
	}
}
