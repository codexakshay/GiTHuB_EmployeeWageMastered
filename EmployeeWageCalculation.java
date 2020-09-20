
public class EmployeeWageCalculation
{
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation");
		final int wagePerHour=20;
		final int fullDayHour=8;
		final int partTimeHour=4;
		int dailyWage=0;
		final int isFullTime=1;
		final int isPartTime=2;
		int i=0;
		int monthlyWage=0;
		final int totMonthDays=20;
		for(i=1;i<=totMonthDays;i++) {
			int empCheck = (int)Math.floor(Math.random()*10)%3;
			switch (empCheck) {
			case isFullTime:
				dailyWage=(wagePerHour*fullDayHour);
				break;
			case isPartTime:
				dailyWage=(wagePerHour*partTimeHour);
				break;
			default:
				break;
			}
			monthlyWage+=dailyWage;
		}
		System.out.println("Total monthly salary is "+monthlyWage);
	}
}


