//Given a number and its reverse. Find that number raised to the power of its own reverse.
package rec;

public class PowerOfNumber {
	
	long power(int N,int R)
    {
        if(N == 0){
            return 0;
        }
         if(R == 0){
            return 1;
        }
        if(R%2 == 0){
            long ans = power(N , R/2);
            return (ans* ans);
        }else{
            long ans = power(N , (R-1)/2);
            return (ans*ans*N);
        }
    }

}
