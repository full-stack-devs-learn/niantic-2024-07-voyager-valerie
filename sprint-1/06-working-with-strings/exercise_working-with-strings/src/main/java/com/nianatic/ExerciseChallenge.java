package com.nianatic;

public class ExerciseChallenge
{
    /*
     * Your companies website displays the name
     * of each of your employees. But the name
     * needs to be formatted with last name first.
     *
     * Examples:
     * Samuel Black             => Black, Samuel
     * Lori Bell, PhD           => Bell, Lori, PhD
     * Marcus Neuer III         => Neuer, Marcus, III
     * Miguel Bennett Jr., MBA  => Bennett, Miguel, Jr., MBA
     *
     * Your function will accept the full name of
     * an employee, and you must return the
     * appropriately formatted name.
     *
     * Input:
     * reformatName("Samuel Black")             => Black, Samuel
     * reformatName("Lori Bell, PhD")           => Bell, Lori, PhD
     * reformatName("Marcus Neuer III")         => Neuer, Marcus, III
     * reformatName("Miguel Bennett Jr., MBA")  => Bennett, Miguel, Jr., MBA
     *
     */
    public String reformatName(String fullName)
    {
        String strippedFullName = fullName.strip();
        String [] parts = strippedFullName.split(",");
        String [] nameParts = parts[0].split(" ");


        if (nameParts.length > 3)             // if person has all name fields, including a title
        {
            fullName = nameParts[1] + ", " + nameParts[0] + ", " + nameParts[2] + ", " + nameParts[3];

        } else if (nameParts.length > 2)      // first middle last name OR first last suffix (w/o ",")
        {
            fullName = nameParts[1] + ", " + nameParts[0] + ", " + nameParts[2];

        } else                                // first and last name
        {
            fullName = nameParts[1] + ", " + nameParts[0];
        }
        return fullName;
    }

    /*
     * JSON is yet another format that is used to
     * describe and transfer data. JSON stands for
     * JavaScript Object Notation
     *
     * There are no XML tags, but it is still self describing.
     *
     * It is more light-weight than XMl, and has become the
     * standard for transferring data over the web.
     *
     * { "id": 1, "name": "Belinda Carter"}
     *
     * The user will provide you a customer id and their name.
     * You are required to return a formatted JSON String
     * like the pattern shown above.
     *
     * createJSON(1, "Belinda Carter") => { "id": 1, "name": "Belinda Carter"}
     *
     */
    public String createJSON(int id, String name)
    {
        return "{ \"id\": " + id + ", \"name\": \"" + name + "\" }";
    }

}
