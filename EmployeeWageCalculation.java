public interface ImpCalculateEmpWage {
	public void addCompanyEmployeeWage(String company, int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth);
	public void computeEmpWage();
}

public class EmployeeWageCalculation implements ImpCalculateEmpWage
{
	public static final int isFullTime=1;
	public static final int isPartTime=2;

	private int numOfCompany=0;
	private CompanyEmployeeWage[] CompanyEmployeeWageArray;

	public EmployeeWageCalculation() {
	CompanyEmployeeWageArray= new CompanyEmployeeWage[5];
	}

	public void addCompanyEmployeeWage(String company,int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {

		CompanyEmployeeWageArray[numOfCompany]=new CompanyEmployeeWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);

		numOfCompany++;
	}

	public void computeEmpWage() {
		for (int i=0;i< numOfCompany; i++) {
			CompanyEmployeeWageArray[i].setTotalEmpWage(this.computeEmpWage(CompanyEmployeeWageArray[i]));
			System.out.println(CompanyEmployeeWageArray[i]);
		}
	}

	public int computeEmpWage(CompanyEmployeeWage CompanyEmployeeWage) {
		int empHours=0, totalEmpHours=0, totalWorkingDays=0;
		while(totalEmpHours<=CompanyEmployeeWage.maxHoursPerMonth && totalWorkingDays<CompanyEmployeeWage.numOfWorkingDays) {
			totalWorkingDays++;
			int empCheck=(int) Math.floor(Math.random() *10)%3;
			switch (empCheck) {
				case isFullTime:
					empHours=8;
					break;
				case isPartTime:
                                        empHours=4;
                                        break;
				default:
					empHours=0;
			}
			totalEmpHours+=empHours;
			System.out.println("Day#: "+ totalWorkingDays+" Emp Hr: " +empHours);
		}
		return totalEmpHours*CompanyEmployeeWage.empRatePerHour;
	}

	public static void main(String[] args) {
		EmployeeWageCalculation e=new EmployeeWageCalculation();
		e.addCompanyEmployeeWage("SpaceX",20,2,10);
		e.addCompanyEmployeeWage("Tesla",10,4,20);
		e.computeEmpWage();
	}
}


