/**
 * 첫번쨰 예제 java 파일
 *  @version 0.1 2016-09-23
 *  @author 카이젠(Kims)
*/
package Main;

public class Main {
	public static void main(String[] args) {
		final double KM_PER_MILE = 1.609344;
		double km;
		double mile = 60.0;
		km = KM_PER_MILE * mile;
	
		System.out.println("60마일은 " + km + "킬로미터 입니다.") ; 
	}
}