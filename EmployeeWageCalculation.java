import java.util.*;

public interface ImpCalculateEmpWage {
	public void addCompanyEmployeeWage(String company, int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

public class EmployeeWageCalculation implements ImpCalculateEmpWage
{
	public static final int isFullTime=1;
	public static final int isPartTime=2;

	private int numOfCompany=0;
	private LinkedList<String> dailyWageList;
	private LinkedList<CompanyEmployeeWage> CompanyEmployeeWageList;
	private Map<String,CompanyEmployeeWage> companyToEmpWageMap;

	public EmployeeWageCalculation() {
		CompanyEmployeeWageList=new LinkedList<>();
		companyToEmpWageMap=new HashMap<>();
		dailyWageList=new LinkedList<>();
	}

	public void addCompanyEmployeeWage(String company,int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {

		CompanyEmployeeWage CompanyEmployeeWage=new CompanyEmployeeWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);

		CompanyEmployeeWageList.add(CompanyEmployeeWage);
		companyToEmpWageMap.put(company,CompanyEmployeeWage);
	}

	public void computeEmpWage() {
		for (int i=0;i<CompanyEmployeeWageList.size(); i++) {
			CompanyEmployeeWage CompanyEmployeeWage = CompanyEmployeeWageList.get(i);
			CompanyEmployeeWage.setTotalEmpWage(this.computeEmpWage(CompanyEmployeeWage));
			System.out.println(CompanyEmployeeWage);
		}
	}

	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
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
			this.dailyWageList.add(String.valueOf(empHours*CompanyEmployeeWage.empRatePerHour));
			totalEmpHours+=empHours;
		}
		this.getDailyWage();
		return totalEmpHours*CompanyEmployeeWage.empRatePerHour;
	}

	public void getDailyWage() {
		for(int i=0; i<dailyWageList.size();i++) {
        		System.out.println("Day#: "+(i+1)+" Wage "+dailyWageList.get(i));
        	}
	}

	public static void main(String[] args) {
		EmployeeWageCalculation e=new EmployeeWageCalculation();
		e.addCompanyEmployeeWage("SpaceX",20,2,10);
		e.addCompanyEmployeeWage("Tesla",10,4,20);
		e.computeEmpWage();
		System.out.println("total wage for SpaceX company is :"+ e.getTotalWage("SpaceX"));
	}
}

