/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canadiancitizen;

/**
 * @author Jadiha Aruleswaran
 * @author Agincourt Collegiate Institute
 * @version 1.1.1 January 14 2022
 * Overview: Accommodating for different types of Canadian Citizens
 */
public class CanadianCitizen {

    protected String full_name;
    protected int age;
    protected String health_card_id;
    protected String social_insurance_id;

    /**
     *
     * @param full_name Full Name of Canadian Citizen
     * @param age Age of Canadian Citizen
     * @param health_card_id Health Card ID of Canadian Citizen
     * @param social_insurance_id Social Insurance ID of Canadian Citizen
     */
    public CanadianCitizen(String full_name, int age, String health_card_id, String social_insurance_id) {
        this.full_name = full_name;
        this.age = age;
        this.health_card_id = health_card_id;
        this.social_insurance_id = social_insurance_id;
    }

    /**
     * @return Full Name
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     *
     * @param first_name
     */
    public void setFull_name(String first_name) {
        this.full_name = first_name;
    }

    /**
     *
     * @return Age
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return Health Card ID
     */
    public String getHealth_card_id() {
        return health_card_id;
    }

    /**
     *
     * @param health_card_id
     */
    public void setHealth_card_id(String health_card_id) {
        this.health_card_id = health_card_id;
    }

    /**
     *
     * @return Social Insurance ID
     */
    public String getSocial_insurance_id() {
        return social_insurance_id;
    }

    /**
     *
     * @param social_insurance_id
     */
    public void setSocial_insurance_id(String social_insurance_id) {
        this.social_insurance_id = social_insurance_id;
    }

    /* Returns Variables in a string to print in main method*/
    @Override
    public String toString() {
        return "Full Name: " + full_name + "\nAge:  " + age + "\nHealth Card: " + health_card_id + "\nSocial Insurance: " + social_insurance_id;
    }

    /*Verifies if Full Name & Social Insurance ID is already in database*/
    protected boolean sameCitizen(CanadianCitizen canadiancitizen) {
        return this.full_name.equalsIgnoreCase(canadiancitizen.getFull_name()) && this.social_insurance_id.equalsIgnoreCase(canadiancitizen.getSocial_insurance_id());
    }

    /*Child class, Canadian University Student taking parameters from base class Canadian Citizen*/
    public class CanadianUniversityStudent extends CanadianCitizen {

        private double student_loan;
        private int student_id;
        private String university_name;
        private String university_degree;
        private double scholarship;
        private double hours_worked;
        private double student_wage;
        private double living_expenses;
        private double monthly_income;

        /**
         *
         * @param full_name Full Name of University Student
         * @param age Age of University Student
         * @param health_card_id Health Card ID of University Student
         * @param social_insurance_id Social Insurance ID of University Student
         * @param student_loan Student debt of University Student
         * @param student_id Student ID of University Student
         * @param university_name University Name of University Student
         * @param university_degree University Degree of University Student
         * @param scholarship Scholarship Granted to University Student
         * @param hours_worked If working, Total Hours Worked by UniversityStudent
         * @param student_wage If working, Student Wage of University Student
         * @param living_expenses Living Expenses of University Student
         * @param monthly_income If working, Monthly Income of University
         * Student
         */
        public CanadianUniversityStudent(String full_name, int age, String health_card_id, String social_insurance_id, double student_loan, int student_id, String university_name, String university_degree, double scholarship, double hours_worked, double student_wage, double living_expenses, double monthly_income) {
            super(full_name, age, health_card_id, social_insurance_id);
            this.student_loan = student_loan;
            this.student_id = student_id;
            this.university_name = university_name;
            this.university_degree = university_degree;
            this.scholarship = scholarship;
            this.hours_worked = hours_worked;
            this.student_wage = student_wage;
            this.living_expenses = living_expenses;
            this.monthly_income = monthly_income;
        }

        /**
         *
         * @return Student loan
         */
        public double getStudent_loan() {
            return student_loan;
        }

        /**
         *
         * @param student_loan
         */
        public void setStudent_loan(double student_loan) {
            this.student_loan = student_loan;
        }

        /**
         *
         * @return Student ID
         */
        public int getStudent_id() {
            return student_id;
        }

        /**
         *
         * @param student_id
         */
        public void setStudent_id(int student_id) {
            this.student_id = student_id;
        }

        /**
         *
         * @return University Name
         */
        public String getUniversity_name() {
            return university_name;
        }

        /**
         *
         * @param university_name
         */
        public void setUniversity_name(String university_name) {
            this.university_name = university_name;
        }

        /**
         *
         * @return University Degree
         */
        public String getUniversity_degree() {
            return university_degree;
        }

        /**
         *
         * @param university_degree
         */
        public void setUniversity_degree(String university_degree) {
            this.university_degree = university_degree;
        }

        /**
         *
         * @return Scholarship Amount
         */
        public double getScholarship() {
            return scholarship;
        }

        /**
         *
         * @param scholarship
         */
        public void setScholarship(double scholarship) {
            this.scholarship = scholarship;
        }

        /**
         *
         * @return Hours Worked, if working a job
         */
        public double getHours_worked() {
            return hours_worked;
        }

        /**
         *
         * @param hours_worked
         */
        public void setHours_worked(double hours_worked) {
            this.hours_worked = hours_worked;
        }

        /**
         *
         * @return Student Wage, if working a job
         */
        public double getStudent_wage() {
            return student_wage;
        }

        /**
         *
         * @param student_wage
         */
        public void setStudent_wage(double student_wage) {
            this.student_wage = student_wage;
        }

        /**
         *
         * @return Living Expenses
         */
        public double getLiving_expenses() {
            return living_expenses;
        }

        /**
         *
         * @param living_expenses
         */
        public void setLiving_expenses(double living_expenses) {
            this.living_expenses = living_expenses;
        }

        /**
         *
         * @return Monthly Income, if working a job
         */
        public double getMonthly_income() {
            return monthly_income;
        }

        /**
         *
         * @param monthly_income
         */
        public void setMonthly_income(double monthly_income) {
            this.monthly_income = monthly_income;
        }

        /**
         * Calculating total monthly income after subtracting living expenses
         *
         * @return
         */
        public double monthlyIncome() {
            double weekly_income = hours_worked * student_wage;
            monthly_income = weekly_income * 4;
            monthly_income = monthly_income - living_expenses;
            return monthly_income;
        }

        /**
         * Calculating total student debt after subtracting scholarship and
         * income
         *
         * @return
         */
        public double totalStudentDebt() {
            double total_student_debt = student_loan - scholarship - (12 * monthly_income);
            return total_student_debt;
        }

        /* Returns Variables in a string to print in main method*/
        @Override
        public String toString() {
            return "Full Name: " + full_name + "\nAge:  " + age + "\nStudent Id: " + student_id + "\nUniversity Name: " + university_name + "\nUniversity Degree: " + university_degree + "\nMonthly Income: " + monthly_income;
        }

        /*Verifies if student id is already in the database*/
        protected boolean sameUniversityStudent(CanadianUniversityStudent canadianuniversitystudent) {
            return this.student_id == canadianuniversitystudent.getStudent_id();
        }

    }

    /*Child class, Employed Citizen taking parameters from base class Canadian Citizen*/
    public class EmployedCitizen extends CanadianCitizen {

        private double salary;
        private String company_name;
        private int worker_id;

        /**
         *
         * @param full_name Full Name of Employed Citizen
         * @param age Age of Employed Citizen
         * @param health_card_id Health Card ID of Employed Citizen
         * @param social_insurance_id SOcial Insurance ID of Employed Citizen
         * @param salary Salary of Employed Citizen
         * @param company_name Company Name of Employed Citizen
         * @param worker_id Worker ID of Employed Citizen
         */
        public EmployedCitizen(String full_name, int age, String health_card_id, String social_insurance_id, double salary, String company_name, int worker_id) {
            super(full_name, age, health_card_id, social_insurance_id);
            this.salary = salary;
            this.company_name = company_name;
            this.worker_id = worker_id;
        }

        /**
         *
         * @return Salary
         */
        public double getSalary() {
            return salary;
        }

        /**
         *
         * @param salary
         */
        public void setSalary(double salary) {
            this.salary = salary;
        }

        /**
         *
         * @return Company Name
         */
        public String getCompany_name() {
            return company_name;
        }

        /**
         *
         * @param company_name
         */
        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        /**
         *
         * @return Worker ID
         */
        public int getWorker_id() {
            return worker_id;
        }

        /**
         *
         * @param worker_id
         */
        public void setWorker_id(int worker_id) {
            this.worker_id = worker_id;
        }

        /**
         *
         * @return Salary after tax deductions
         */
        public double taxDeduction() {
            if (salary == 49020) {
                salary = salary - salary * 0.15;
            } else if (salary > 49040 && salary < 98040) {
                salary = salary - salary * 0.2005;
            } else if (salary > 98040 && salary < 151978) {
                salary = salary - salary * 0.26;
            } else if (salary > 151978 && salary < 216511) {
                salary = salary - salary * 0.29;
            } else if (salary > 216511) {
                salary = salary - salary * 0.33;
            }
            return salary;
        }

        /**
         *
         * @return Salary after Insurance deduction
         */
        public double insuranceCut() {
            double insurance = salary * 0.20;
            salary = salary - insurance;
            return salary;
        }

        /* Returns Variables in a string to print in main method*/
        @Override
        public String toString() {
            return "Full Name: " + full_name + "\nAge:  " + age + "\nSalary: " + salary + "\nCompany Name: " + company_name + "\nWorker ID: " + worker_id;
        }

        /*Verifies if Worker ID & Company Name is in database*/
        protected boolean sameEmployedCitizen(EmployedCitizen employedcitizen) {
            return this.worker_id == employedcitizen.getWorker_id() && this.company_name.equalsIgnoreCase(employedcitizen.getCompany_name());
        }
    }
}
