package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyy): ");
		// o sdf.parse converte o arquivo que está sendo capturado através do sc.next
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());

		// ! = não. Portanto, if checkOut não for posterior ao CheckIn, então faça...
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after Check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter below data to update your reservation");
			System.out.print("Check-in date (dd/MM/yyy): ");
			// o sdf.parse converte o arquivo que está sendo capturado através do sc.next
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after Check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Updated reservation: " + reservation);
			}
		}
		sc.close();
	}
}
