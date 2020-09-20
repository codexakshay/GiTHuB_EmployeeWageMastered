public class EmployeeWageCalculation
{
	final int isFullTime=1;
	final int isPartTime=2;

	final int empRatePerHour;
	final int maxHours;
        final int maxDays;
	String company;
	int totalEmpWage;

	public EmployeeWageCalculation(String company,int empRatePerHour,int maxDays,int maxHours) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.maxHours=maxHours;
		this.maxDays=maxDays;
	}

	public int empAttendance() {
		int empCheck=(int) Math.floor(Math.random()*10)%3;
		return empCheck;
	}
	public void welcomeMessage() {
		System.out.println("Welcome to Employee Wage Computation Program");
	}
	public void checkAttendence(){
		switch (empAttendance()) {
		case isFullTime:
			System.out.println("Employee is full time");
			break;
		case isPartTime:
			System.out.println("Employee is part time");
			break;
		default:
			System.out.println("Employee is absent");
		}
	}
	public int daliyWage(int n) {
		final int partTimeHours=4;
	        final int fullTimeHours=8;
		int empWage=0;
		switch (n) {
		case isFullTime:
			empWage = (empRatePerHour*fullTimeHours);
			break;
		case isPartTime:
			empWage= (empRatePerHour*partTimeHours);
			break;
		default:
			break;
		}
		return empWage;
	}
	public void monthlyWage() {
		final int partTimeHours=4;
                final int fullTimeHours=8;
		int days = 0;
		int hours=0;
		int monthlyWage = 0;
		while (hours<=maxHours || days<=maxDays) {
			int n=empAttendance();
			switch (n) {
			case isFullTime:
				monthlyWage+=daliyWage(n);
				hours+=fullTimeHours;
				break;
			case isPartTime:
				monthlyWage+=daliyWage(n);
				hours+=partTimeHours;
				break;
			default:
				break;
			}
			days++;
		}
		this.totalEmpWage=monthlyWage;
	}
	public static void main(String[] args) {
		EmployeeWageCalculation SpaceX = new EmployeeWageCalculation("SpaceX",20,20,100);
		EmployeeWageCalculation Tesla = new EmployeeWageCalculation("Tesla",10,25,100);
		SpaceX.monthlyWage();
		Tesla.monthlyWage();
		System.out.println("Monthly Wage of SpaceX is "+SpaceX.totalEmpWage); 
		System.out.println("Monthly Wage of Tesla is "+Tesla.totalEmpWage);
	}
}




