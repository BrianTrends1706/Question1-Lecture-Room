/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Qtn_1;

/**
 *
 * @author HP
 */

import java.util.Scanner;
public class LectureRoomController {
    public static void main(String[] args) {
        LectureRoom room = new LectureRoom();
        EasyReader reader = new EasyReader();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Lecture Room Controller");
            System.out.println("W: Add students to the room");
            System.out.println("X: Remove students from the room");
            System.out.println("Y: Turn on a light");
            System.out.println("Z: Turn off a light");
            System.out.println("Q: Quit");
            System.out.print("Enter your choice: ");

            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'W':
                case 'w':
                    System.out.print("Enter the number of students to add: ");
                    int numStudentsToAdd = reader.readInt();
                    for (int i = 0; i < numStudentsToAdd; i++) {
                        room.addStudent();
                    }
                    System.out.println("Students added successfully!");
                    break;

                case 'X':
                case 'x':
                    System.out.print("Enter the number of students to remove: ");
                    int numStudentsToRemove = reader.readInt();
                    for (int i = 0; i < numStudentsToRemove; i++) {
                        room.removeStudent();
                    }
                    System.out.println("Students removed successfully!");
                    break;

                case 'Y':
                case 'y':
                    System.out.print("Enter the light number to turn on (1, 2, or 3): ");
                    int lightNumber = reader.readInt();
                    if (lightNumber >= 1 && lightNumber <= 3) {
                        room.turnOnLight(lightNumber);
                        System.out.println("Light turned on successfully!");
                    } else {
                        System.out.println("Invalid light number. Please try again.");
                    }
                    break;

                case 'Z':
                case 'z':
                    System.out.print("Enter the light number to turn off (1, 2, or 3): ");
                    lightNumber = reader.readInt();
                    if (lightNumber >= 1 && lightNumber <= 3) {
                        room.turnOffLight(lightNumber);
                        System.out.println("Light turned off successfully!");
                    } else {
                        System.out.println("Invalid light number. Please try again.");
                    }
                    break;

                case 'Q':
                case 'q':
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class LectureRoom {
    private int numStudents;
    private boolean[] lights;

    public LectureRoom() {
        numStudents = 0;
        lights = new boolean[3];
    }

    public void addStudent() {
        numStudents++;
    }

    public void removeStudent() {
        if (numStudents > 0) {
            numStudents--;
        }
    }

    public void turnOnLight(int lightNumber) {
        lights[lightNumber - 1] = true;
    }

    public void turnOffLight(int lightNumber) {
        lights[lightNumber - 1] = false;
    }
}

class EasyReader {
    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}