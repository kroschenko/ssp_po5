import java.util.Random;

class Task_3{
    public static void main(String[] args) {
        Printer printer = new Printer("model 7000", 30, 100, 0.6);
        
        int numPaper;
        String result;
        Random r = new Random();
        for(int i = 0; i < 10; ++i) {
            numPaper = 0 + (10 - 0) * r.nextInt();
            printer.print(numPaper);
            
            numPaper = 0 + (10 - 0) * r.nextInt();
            result = printer.print(numPaper);
            
            if(result.lastIndexOf("Clamping State.") != -1) {
                printer.extractClampingPaper();
            }
            
            if(result.lastIndexOf("Not ehough papers") != -1) {
                numPaper = 0 + (10 - 0) * r.nextInt();
                printer.loadPaper(numPaper);
            }

            if(result.lastIndexOf("Not ehough painters") != -1) {
                printer.refilleCartridge();
            }
        }
    }
}
