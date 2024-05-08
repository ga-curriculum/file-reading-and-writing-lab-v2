import java.util.ArrayList;

public class SuperHero {

    private static ArrayList<SuperHero> heroesList;
    private String superIdentity;
    private String name;
    private String birthplace;

    public SuperHero(String superIdentity, String name, String birthplace) {
        this.superIdentity = superIdentity;
        this.name = name;
        this.birthplace = birthplace;
    }

    public void setSuperIdentity(String superIdentity) {
        this.superIdentity = superIdentity;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setHeroesList(ArrayList<SuperHero> heroesList) {
        SuperHero.heroesList = heroesList;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getName() {
        return name;
    }

    public String getSuperIdentity() {
        return superIdentity;
    }

    public static ArrayList<SuperHero> getHeroesList() {
        return heroesList;
    }

    public String getCorrectAnswer(int questionNumber) {
        switch (questionNumber) {
            case 1:
                return this.birthplace; // Assuming question 1 asks for the superhero's birthplace
            case 2:
                return this.superIdentity; // Assuming question 2 asks for the superhero's super identity
            case 3:
                return this.name; // Assuming question 3 asks for the superhero's name
            default:
                return ""; // If an invalid question number is passed
        }
    }

    @Override
    public String toString() {
        return "Super Identity: " + superIdentity + " Name: " + name + " Birthplace: " + birthplace;
    }
}