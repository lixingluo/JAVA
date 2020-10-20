package com.nmgtvb.booking;

import java.util.Date;
import java.util.Scanner;

public class BookingManager {
	private static int maxBooks = 3;
	private Book[] books;
	private Scanner scanner;
	private Book defeaultBook = new Book(0, "Default");

	public void init() {
		books = new Book[maxBooks];
		scanner = new Scanner(System.in);

		Book book = new Book();
		book.setId(1000);
		book.setName("高数");

		Book book1 = new Book();
		book1.setId(1001);
		book1.setName("高并发");

		Book book2 = new Book();
		book2.setId(1002);
		book2.setName("分布式");

		books[0] = check_book(book);
		books[1] = check_book(book1);
		books[2] = check_book(book2);
	}

	public Book check_book(Book book) {
		if (book != null) {
			return book;
		}
		return defeaultBook;
	}

	public void run() {
		System.out.println("======欢迎进入图书管理系统======");
		System.out.println("请根据提示选择");
		System.out.println("1.新增图书");
		System.out.println("2.删除图书");
		System.out.println("3.借阅图书");
		System.out.println("4.归还图书");
		System.out.println("5.图书风云榜");
		System.out.println("6.查看图书");
		System.out.println("7.图书馆扩容");

		if (!scanner.hasNextInt()) {
			System.out.println("请重新运行，输入整数");
			return;
		}
		int inputChoice = scanner.nextInt();
		switch (inputChoice) {
		case 1:
			addBook();
			break;
		case 2:
			deleteBook();
			break;
		case 3:
			borrowBook();
			break;
		case 4:
			returnBook();
			break;
		case 5:
			showBookRank();
			break;
		case 6:
			showBook();
			break;
		case 7:
			increaseCapacity();
			break;
		default:
			System.out.println("输入指令无效，你将重新进入图书管理系统");
			run();
			break;
		}
	}

	public void addBook() {
		System.out.println("---新增图书---");
		Book newBook = new Book();
		System.out.println("请输入图书编号:");
		int newId = scanner.nextInt();
		System.out.println("请输入图书名字:");
		String newName = scanner.next();
		newBook.setId(newId);
		newBook.setName(newName);

		int position = books.length;
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				position = i;
				break;
			}
		}

		if (position > books.length - 1) {
			System.out.println("图书馆库存已满，无法新增图书");
		} else {
			books[position] = newBook;
			System.out.println("新增图书成功");
		}

		isContinue();
	}

	public void deleteBook() {
		System.out.println("---删除图书---");
		System.out.println("请输入图书名字:");
		String deleteName = scanner.next();

		int position = -1;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getName().equals(deleteName)) {
					position = i;
					break;
				}
			}
		}

		if (position < 0) {
			System.out.println("图书馆内不包含你所输入的图书");
		} else {
			if (books[position].getStatus() == 1) {
				int lastIndex = 0;
				for (int i = 0; i < books.length; i++) {
					if (books[i] != null) {
						lastIndex = i;
					} else {
						break;
					}
				}
				for (int i = position; i < lastIndex; i++) {
					books[i] = books[i + 1];
				}
				books[lastIndex] = null;
				System.out.println("删除图书成功");
			} else {
				System.out.println("删除失败，这本图书还未被归还");
			}
		}

		isContinue();
	}

	public void borrowBook() {
		System.out.println("---借阅图书---");
		System.out.println("请输入图书名字:");
		String borrowName = scanner.next();

		int position = -1;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getName().equals(borrowName)) {
					position = i;
					break;
				}
			}
		}
		if (position < 0) {
			System.out.println("图书馆内不包含你所输入的图书");
		} else {
			if (books[position].getStatus() == 1) {
				books[position].setStatus(0);
				books[position].setBorrowDate(new Date());
				books[position].addBorrowCount(1);
				System.out.println("成功借阅图书");
			} else {
				System.out.println("借阅失败，这本图书还未被归还");
			}
		}

		isContinue();
	}

	public void returnBook() {
		System.out.println("---归还图书---");
		System.out.println("请输入图书名字:");
		String returnName = scanner.next();

		int position = -1;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getName().equals(returnName)) {
					position = i;
					break;
				}
			}
		}
		if (position < 0) {
			System.out.println("图书馆内不包含你所输入的图书");
		} else {
			if (books[position].getStatus() == 0) {
				books[position].setStatus(1);
				books[position].setReturnDate(new Date());
				books[position].addReturnCount(1);
				System.out.println("成功归还图书");
			} else {
				System.out.println("归还失败，这本图书还未被借阅");
			}
		}

		isContinue();
	}

	public void showBookRank() {
		Book[] newBooks = new Book[books.length];
		for (int i = 0; i < newBooks.length; i++) {
			// 没必要新建，因为我只是改变了新数组newBooks中不同index指向books的先后顺序，没有改变books里面各index的值
			// Book tmpBook = new Book();
			// tmpBook.setId(books[i].getId());
			// tmpBook.setName(books[i].getName());
			// tmpBook.setStatus(books[i].getStatus());
			// tmpBook.setBorrowDate(books[i].getBorrowDate());
			// tmpBook.setReturnDate(books[i].getReturnDate());
			// tmpBook.setBorrowCount(books[i].getBorrowCount());
			// tmpBook.setReturnCount(books[i].getReturnCount());
			// newBooks[i] = tmpBook;
			newBooks[i] = books[i];
		}

		for (int i = 1; i < newBooks.length; i++) {
			for (int j = 0; j < newBooks.length - i; j++) {
				if (newBooks[j] != null && newBooks[j + 1] != null) {
					if (newBooks[j].getBorrowCount() < newBooks[j + 1].getBorrowCount()) {
						Book tmpBook = newBooks[j + 1];
						newBooks[j + 1] = newBooks[j];
						newBooks[j] = tmpBook;
					}
				} else {
					break;
				}
			}
		}

		showTargetBook(newBooks);
		
		isContinue();
	}

	public void showBook() {
		System.out.println("---查看图书---");
		showTargetBook(books);
		isContinue();
	}

	public void showTargetBook(Book[] tarBooks) {
		System.out.println("编号\t书名\t库存\t借出时间\t\t归还时间\t\t被借次数\t\t归还次数\t");
		for (Book book : tarBooks) {
			if (book != null) {
				System.out
						.println(book.getId() + "\t" + book.getName() + "\t" + book.showStatus() + "\t" + book.showBorrowDate()
								+ "\t" + book.showReturnDate() + "\t" + book.getBorrowCount() + "\t\t" + book.getReturnCount());
			}
		}
		System.out.println();
	}

	public void isContinue() {
		System.out.println("是否回到主菜单(y/其他)");
		String inputMenuChoice = scanner.next();
		if (inputMenuChoice.equals("y")) {
			run();
		}
		System.out.println("本次操作已结束，欢迎下次再使用图书管理系统");
	}

	public void increaseCapacity() {
		System.out.println("---图书馆扩容---");
		Book[] newBooks = new Book[maxBooks * 2];
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				newBooks[i] = books[i];
			} else {
				break;
			}
		}
		books = newBooks;
		maxBooks *= 2;
		System.out.println("扩容成功，图书馆现在可容纳的规模是:" + books.length + "本书");

		isContinue();
	}
}
