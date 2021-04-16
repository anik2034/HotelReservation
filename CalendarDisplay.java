

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

class CalendarDisplay {


   private static final String[] monthName = {"Whoops", "      January", "      February",
             "       March", "       April", "        May", "       June", "       July",
             "       August", "      September", "      October",
             "      November", "      December"};
   private  static final int[] startOfMonth ={0,0,0,0,4,6,2,4,7,3,5,1,3,};


   private static final int[] numDays = {0,0,0,0,30,31,30,31,31,30,31,30,31};
   private static  final int[] daysInMonth= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,1,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};


   public static void printCurrentMonth(int month) {

       System.out.println();
       System.out.println(monthName[month] + " " + 2021);
       System.out.println("Mo Tu We Th Fr Sa Su");
       for (int j = 1; j <= numDays[month]; j++)
           if (j == 1) {
               System.out.print("   ".repeat(startOfMonth[month] - 1) + daysInMonth[j]);
               startOfMonth[month]++;


           } else if (j < 10) {


               if (startOfMonth[month] % 7 == 1) {
                   System.out.println();
                   System.out.print(daysInMonth[j]);
                   startOfMonth[month]++;

               } else {
                   System.out.print("  " + daysInMonth[j]);
                   startOfMonth[month]++;

               }
           } else {
               if (startOfMonth[month] % 7 == 1) {
                   System.out.println();
                   System.out.print(daysInMonth[j]);
                   startOfMonth[month]++;

               } else {
                   System.out.print(" " + daysInMonth[j]);
                   startOfMonth[month]++;

               }

           }
   }

   public static int getNumberBetweenDates(LocalDate start, LocalDate end){
       long noOfDaysBetween = DAYS.between(start, end);
       return (int)noOfDaysBetween;
   }










}
