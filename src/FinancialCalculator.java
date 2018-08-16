import java.lang.Math;
import java.time.Month;
import java.util.Scanner;

//Created 7/31/2018
// Ideas/Equations from this website
// Goal is to get all the equations to work and develop a GUI
//https://www.businessinsider.com/11-personal-finance-equations-you-need-to-know-2012-7#amortization-1
//https://www.thecalculatorsite.com/articles/finance/compound-interest-formula.php?page=2
public class FinancialCalculator{
    /*M = P r(1+r)^n
    --------------
            (1+r)^n - 1 */

    void MortgageCalculation(int years, double mortgage_amt,double rate)
    {
        double top, bottom, monthly,interest_paid,totalWI;
        int months = years * 12;
        rate = (rate/100)/12;
        top = rate * Math.pow(1+rate, months);
        bottom = Math.pow(1+rate, months) - 1;
        monthly = mortgage_amt * (top/bottom);
        totalWI = monthly*months;
        interest_paid = totalWI - mortgage_amt;
        System.out.println("Monthly Payments = " + monthly);
        System.out.println("Total paid = " + totalWI);
        System.out.println("Interest paid = " + interest_paid);
    }

    // Simple interest = P * r * t
    double SimpleInterest(double p, double rate, int t){
        double AmountAccrued, InterestEarned, Yearly, Monthly;
        rate = rate/100;
        AmountAccrued = p *(1 + (rate * t));
        System.out.println(AmountAccrued);
        InterestEarned = AmountAccrued - p;
        System.out.println(InterestEarned);
        Yearly = InterestEarned/t;
        System.out.println(Yearly);
        Monthly = InterestEarned/(t*12);
        System.out.println(Monthly);
        return AmountAccrued;
    }

    // A = P(1+(r/n))^n*t
    double CompoundInterest(double p, double rate, char AdditionPeriod, double PMT, int years,int n){
        double CompoundInterestP = 0; // Compound interest principal
        double FutureValue = 0; // Future value of a series
        double total = 0;
        if(AdditionPeriod == 'B' || AdditionPeriod == 'b'){
            rate/=100;
            PMT*=12;
            CompoundInterestP = p*Math.pow(1+(rate/n),n*years);
            FutureValue = PMT * ((Math.pow(1+(rate/n),n*years) - 1)/(rate/n)) * (1+rate/n);
            total = CompoundInterestP + FutureValue;
            System.out.println(total);
        }
        else if(AdditionPeriod == 'E' || AdditionPeriod == 'e'){
            rate/=100;
            PMT*=12;
            CompoundInterestP = p*Math.pow(1+(rate/n),n*years);
            FutureValue = PMT * ((Math.pow(1+(rate/n),n*years) - 1)/(rate/n));
            total = CompoundInterestP + FutureValue;
            System.out.println(total);
        }
        return total;
    }

    public static void main(String args[]){
        FinancialCalculator myInstance = new FinancialCalculator();
        myInstance.MortgageCalculation(30, 250000, 3.92);
    }
}