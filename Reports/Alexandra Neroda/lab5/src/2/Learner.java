import java.util.Scanner;

public class Learner {
    public static void main(String[] args)
	{
        Scanner in = new Scanner(System.in);
		System.out.print("Enter number of pupils: ");
		int n = in.nextInt(); in.nextLine();
		Pupil[] a = new Pupil[n]; 
        int max = 1, min = 0;

		for (int x = 0; x < n; x++) {
            int randNumber = (int)(Math.random()*((max-min)+1))+min;
			if (randNumber == 0) {
				a[x] = new Student(x + 1);
			}
			else {
				a[x] = new Schoolboy(x + 1);
			}
		}

		for (int x = 0; x < n; x++) {
			if (a[x].num == 1) {
				System.out.print(a[x].n + ". ");
				a[x].type();
			}
            else if (a[x].num == 2) {
                System.out.print(a[x].n + ". ");
				a[x].type();
            }
		}

        in.close();
	}
}

class Pupil
{
		public int n;
		public int num;

		public Pupil(int n, int num) {
			this.n = n;
			this.num = num; 
		}

		public void type() {
			System.out.println("Pupil");
		}
}

class Schoolboy extends Pupil 
{
		public Schoolboy(int x) {
			super(x, 1);
		}

        @Override
		public void type() 
		{
			System.out.println("Schoolboy");
		}
}

class Student extends Pupil
{
		public Student(int x) {
			super(x, 2);
		}

        @Override
		public void type() {
			System.out.println("Student");
		}
}

