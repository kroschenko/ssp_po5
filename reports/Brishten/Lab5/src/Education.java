public class Education {
    public static void main(String[] args) {
        College [] info = new College[2];
        info[0] = new University("Free", "State", 1050, 5);
        info[1] = new University("Charge", "Private", 0, 3);
        for (College temp : info)
            System.out.println(temp);
    }
}

interface EducationInstitution {
    String getOwner(); // получить собственника
    int getPlaces();
}

class College implements EducationInstitution {
    protected String education;
    protected String owner;
    protected int numStateFundedPlaces;
 
    public College(String education, String owner, int numStateFundedPlaces) {
        this.education = education;
        this.owner = owner;
        this.numStateFundedPlaces = numStateFundedPlaces;
    }
 
    public String getEducation() { return education; };
 
    @Override
    public String getOwner() { return owner; }
 
    @Override
    public int getPlaces() { return numStateFundedPlaces; }
}

class University extends College {
    private int numCorpus;
 
    public University(String education, String owner, int numStateFundedPlaces, int numCorpus) {
        super(education, owner, numStateFundedPlaces);
        this.numCorpus = numCorpus;
    }
 
    public int getNumCorpus() { return numCorpus; }
 
    @Override
    public String toString() {
        return  "\nCost of Education = '" + education + "\';\n" +
                "Number of corpuses = " + numCorpus + ";\n" +
                "Owner institutions = " + getOwner() + ";\n" +
                "Number state-funded places = " + getPlaces() + ".\n" +
                "_______________________________________________________";
    }
}