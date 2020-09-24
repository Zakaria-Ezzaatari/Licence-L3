package exercice0;

public class Premier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=0,y,z=7;
		y=(2*z)-1;
		do {
			x+=y;
			y-=2;
		} while ((y>=1)&&(x!= -1));
		System.out.println("Resultat:"+ x);

	}

}
