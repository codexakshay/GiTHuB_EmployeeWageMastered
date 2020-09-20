public interface ImpCalculateEmpWage {
	public void addCompanyEmployeeWage(String company, int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}
