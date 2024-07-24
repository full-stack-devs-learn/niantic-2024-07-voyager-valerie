package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples()
    {
        // i. Create a variable that stores the name of the best
        // programming language.
        String bestLanguage;
        bestLanguage = "Java";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + bestLanguage);
        System.out.println();



        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01()
    {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();



        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)
        String name = "Valerie Kuan";

        System.out.println("1. Declare a variable to hold my name.");
        System.out.println("My name: " + name);
        System.out.println();

        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age = 23;

        System.out.println("2. Declare a variable to hold my age.");
        System.out.println("My age: " + age);
        System.out.println();

        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        double pi  = 3.1415;

        System.out.println("3. Declare a variable that holds the first 5 digits of pi.");
        System.out.println("First 5 digits of pi: " + pi);
        System.out.println();

        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)
        double price = 19.5;

        System.out.println("4. Declare a variable to hold the price of an adult meal at a buffet.");
        System.out.println("Adult meal price at a buffet: " + price);
        System.out.println();

        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
    }

    public static void section02()
    {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.



        // 5. Declare a variable to store the name of your
        // favorite super hero.

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.

        String favoriteSuperHero = "Spiderman";

        System.out.println("5. Declare a variable for your favorite superhero.");
        System.out.println("My favorite superhero: " + favoriteSuperHero);
        System.out.println();

        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)
        int testScore = 78;

        System.out.println("6. Declare a variable to hold the test score.");
        System.out.println("My test score: " + testScore);
        System.out.println();



        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)
        System.out.println("7. Declare a variable to hold the current population in the United States.");

        long USPopulation = 333300000;    // 333.3million, which is too large for the max possible value for int

        System.out.println("Current US population: " + USPopulation);
        System.out.println();

        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today) 1.412 billion
        long ChinaPopulation = 1412000000;

        System.out.println("8. Declare a variable to hold the current population in China.");
        System.out.println("Current Chinese population: " + ChinaPopulation);
        System.out.println();

        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today) // 7.951 billion
        System.out.println("9. Declare a variable to hold the current population in the world.");

        long worldPopulation = 7951000000L;

        System.out.println("Current world population: " + worldPopulation);
        System.out.println();


        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.
        System.out.println("10. Declare a variable that specifies whether your mouse is wireless or not.");

        boolean wirelessMouse = false;

        System.out.println("Is my mouse wireless? " + wirelessMouse);
        System.out.println();


        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.
        double hometownLongitude = 37.4323;
        double hometownLatitude = 121.8996;

        System.out.println("11. Search what the longitude and latitude of your hometown are");
        System.out.println("Hometown Longitude: " + hometownLongitude);
        System.out.println("Hometown Latitude: " + hometownLatitude);
        System.out.println();

        // 12. Create a variable that holds the current
        // Microsoft stock price.
        System.out.println("12. What is the current Microsoft stock price?");

        double microsoftStock = 444.85;

        System.out.println("Current Microsoft stock price: " + microsoftStock);
    }

    
    public static void section03()
    {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.

        // How many shots did Pete take?
        int peteBasketballShots = 7;
        int peteScored = peteBasketballShots - 3;

        System.out.println("13. How many shots did Pete take in his last basketball game?");
        System.out.println("Pete took " + peteBasketballShots + " shots in his last basketball game.");
        System.out.println();


        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.

        // How many 2 point shots did Pete make?\
        System.out.println("14. How many 2 point shots did Pete make in his last basketball game?");

        int peteTwoPointShots = 20 - 6 - 3;

        System.out.println("Pete made " + peteTwoPointShots + " two-point shots in his last basketball game.");
        System.out.println();


        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.

        // How many total shots did they make?
        System.out.println("15. How many shots did Pete and Pat make collectively?");

        int peteShots = 6;
        int patShots = peteShots * 2;
        int petePatTotalShots = peteShots + patShots;

        System.out.println("Pete and Pat collectively made " + petePatTotalShots + " shots.");
        System.out.println();


        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?
        System.out.println("16. How many shots did the Terrifying Twosome make in the game?");

        int peteTerrifyingTwosome = 13;
        peteTerrifyingTwosome++;

        int patTerrifyingTwosome = 9;
        patTerrifyingTwosome++;

        int totalTerrifyingTwosome = peteTerrifyingTwosome + patTerrifyingTwosome;

        System.out.println("The Terrifying Twosome collectively made " + totalTerrifyingTwosome + " shots during the game.");
        System.out.println();


        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.

        // What percentage of his shots did he make?
        System.out.println("17. What percentage of Pete's shots did he make in his last game?");

        int peteShotsMade = 11;
        int peteMissedShots = 4;

        double peteDecimalShotsScored = (peteShotsMade - peteMissedShots) / (double) peteShotsMade;
        double petePercentageShotsScored = peteDecimalShotsScored * 100;

        System.out.println("Pete made " + petePercentageShotsScored +"% of his shots.");
        System.out.println();



        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.
        System.out.println("18. How many shots do Pete and Pat have to take to win this game?");
        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?
        int opposingTeamPoints = 31;
        double petePatSuccessfulShots = 0.7;    // the percentage of shots they make

        int petePat3Pts = opposingTeamPoints / 3;  // evaluates to 10, but need to beat the opposing team and score 11 times
        petePat3Pts++;                      // +1 so we can win (these are the successful shots, NOT total)

        double petePatWin = petePat3Pts / petePatSuccessfulShots;   // total shots made to win
        System.out.println("Pete and Pat need to make " + petePatWin + " shots to win, which is approximately 16 total shots.");

    }
    
    public static void clairesCookies()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();



        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        System.out.println("19. How many cookies will Sean give to each of his students?");

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)
        int students = 14;
        int totalCookies = 3 * 12;

        int cookiesPerStudent = (int) Math.floor(totalCookies / (double) students);    // round down to the nearest whole number

        System.out.println("Cookies per student: " + cookiesPerStudent);


        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?

        System.out.println("20. How many cookies will be left over after giving the cookies to his students?");

        int cookiesLeft = totalCookies - (cookiesPerStudent * students);

        System.out.println("There would be " + cookiesLeft + " cookies left.");
        System.out.println();



        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies?
        int newCookiesPerStudent = 3;
        int cookiesConsumed = students * newCookiesPerStudent;    // 42 cookies will be eaten

        int dozensRequired = (int) Math.ceil( (double) cookiesConsumed / 12);    // where 12 represents dozens

        System.out.println("Sean needs to buy " + dozensRequired + " dozen cookies so his students can each have 3 cookies.");
        System.out.println();


        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy?
        System.out.println("How many dozen cookies does Sean need to buy if he distributes cookies based on test score?");
        int perfect = 2 * 4;
        int as = 4 * 3;
        int others = (14 - 2 - 4) * 2;

        int sumOfCookies = perfect + as + others;
        int dozensForSumOfCookies = (int) Math.ceil( (double) sumOfCookies / 12);

        System.out.println(dozensForSumOfCookies + " dozen cookies");
        System.out.println();


        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.
        System.out.println("How much will it cost for Sean to buy 4 dozen cookies if a dozen costs 12.99?");
        double fourDozenCost = 4 * 12.99;
        System.out.println("$" + fourDozenCost);
        System.out.println();

        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?
        System.out.println("24. How many total dozen cookies does Sean need to buy?");
        int dozen = 12;

        // round up so all students can get all the cookie types of their choosing
        double dozenSnickerDoodle = Math.ceil(9.0 / dozen);
        //System.out.println(dozenSnickerDoodle);
        double dozenChocolateChip = Math.ceil(15.0 / dozen);
        //System.out.println(dozenChocolateChip);
        double dozenFrostedChocolateChip = Math.ceil(18.0 / dozen);
        //System.out.println(dozenFrostedChocolateChip);

        int totalDozens = (int) dozenSnickerDoodle + (int) dozenChocolateChip + (int) dozenFrostedChocolateChip;

        System.out.println(totalDozens + " dozen cookies.");
        System.out.println();

        // 25. What is the total cost of this order?
        System.out.println("25. What is the total cost of this order?");

        double snickerDoodleCost = 12.99 * dozenSnickerDoodle;
        double chocolateChipCost = 13.99 * dozenChocolateChip;
        double frostedChocolateChipCost = 15.99 * dozenFrostedChocolateChip;

        double cookieOrderCost = snickerDoodleCost + chocolateChipCost + frostedChocolateChipCost;

        System.out.println("$" + cookieOrderCost);
        System.out.println();

        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)
        System.out.println("How many of each type of cookie will be left over?");

        int snickerDoodleOrder = 9;
        int chocolateChipOrder = 15;
        int frostedChocolateChipOrder = 18;

        int leftoverSnickerDoodle = (int) dozenSnickerDoodle * dozen - snickerDoodleOrder;
        int leftoverChocolateChip = (int) dozenChocolateChip * dozen - chocolateChipOrder;
        int leftoverFrostedChocolateChip = (int) dozenFrostedChocolateChip * dozen - frostedChocolateChipOrder;

        System.out.println(leftoverSnickerDoodle + " Snicker Doodles cookies");
        System.out.println(leftoverChocolateChip + " Chocolate Chip cookies");
        System.out.println(leftoverFrostedChocolateChip + " Frosted Chocolate Chip cookies");
        System.out.println();


        // 27. How much money could Sean have saved if he would
        // have bought:
        System.out.println("27. How much money could Sean have saved if he ordered 2 dz Frosted Chocolate Chip, 1 dz Chocolate Chip, 1 dz Snicker Doodle?");
        // 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle

        double diffSnickerDoodle = 12.99 * 1;
        double diffChocolateChip =  13.99 * 1;
        double diffFrostedChocolateChip = 15.99 * 2;

        double sumOfDifferentOrder = diffSnickerDoodle + diffChocolateChip + diffFrostedChocolateChip;

        double diffOfTwoOrders = cookieOrderCost - sumOfDifferentOrder;
        System.out.println("Sean could've saved " + "$" + diffOfTwoOrders);
        System.out.println();
    }


    // bonus - challenge
    public static void elliotsYardCare()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.


        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?
        System.out.println("28. What is the total cost to Elliot when he mows a 100 x 50 feet lawn?");

        int mediumLawnSize = 100 * 50;
        double mediumMowingExpense = 2.5;
        int mowingSqFt = 1000;

        double mediumLawnExpense = ( (double) mediumLawnSize / mowingSqFt) * mediumMowingExpense;
        System.out.println("$" + mediumLawnExpense);
        System.out.println();


        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?
        System.out.println("29. How much money does Elliot earn to maintain a 100 x 50 ft lawn?");

        int mediumLawnCharge = 30;
        double mediumLawnEarnings = mediumLawnCharge - mediumLawnExpense;

        System.out.println("$" + mediumLawnEarnings);
        System.out.println();

        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?
        System.out.println("30. How much time does it take Elliot to mow a 100 x 50 ft lawn?");

        int mediumMowingRate = mediumLawnSize / mowingSqFt;
        double mowingSpeed = 0.75;   // convert 45 min to hrs

        double mediumTimeSpent = mediumMowingRate * mowingSpeed;
        System.out.println(mediumTimeSpent + " hours");


        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?
        System.out.println("31. How much does Elliot earn per hour on a  100 x 50 ft lawn?");

        double mediumHourlyEarnings = mediumLawnEarnings / mediumTimeSpent;
        System.out.println("$" + mediumHourlyEarnings);


        // 32. What is Elliot's cost per hour on a medium
        // sized yard?



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?


    }
}