public class Rational{
    private  int num;
    private  int den;
    
    
    public  Rational(int n){
        den =1;
        num=n;
        
       //negative();
        
    }

    public Rational(){
        num =0;
        den = 1;
         
    }
    
    public Rational(int n, int d){
        num =n;
        den = d;
        if(den==0){
            den = 1;
        }
        negative();
        reduce();

    }

    public  int getNumerator(){
        return num;
    }
    public  int getDenominator(){
        return den;
    }

      public Rational reciprocal(){
        Rational r = new Rational(den,num);
        return r;
    }

    public double value(){
        double v = (double)num/den;
        return v;
    }

    public String toString(){
        return num+"/"+den+" or "+ value();
        
    }

    private void reduce(){

            int hcf=1;
        for(int i = 1; i <= Math.abs(num) && i <= den; i++) {
            if(num%i==0 && den%i==0) {
            hcf = i;

                }
            }
            num = num/hcf;
            den = den/hcf;
              
    }
    

    public Rational add(Rational r){
        int n = (num*r.den)+(den*r.num);
        int d = den*r.den;
        reduce();
        return new Rational(n, d);
    }
    
    Rational multiply(Rational r){
        int n = num*r.num;
        int d = den*r.den;
        reduce();
        return new Rational(n, d);
        
    }

    Rational subtract(Rational r){
        int n = (num*r.den)-(den*r.num);
        int d = den*r.den;
        reduce();
        return new Rational(n, d);
    }

    Rational divide(Rational r){
        int n = num*r.den;
        int d = den*r.num;
        reduce();
        return new Rational(n, d);
        
    }

    Rational add(int x){
        int n = (num*x)+(den*x);
        int d = den*x;
        reduce();
        return new Rational(n, d);
    }

    Rational subtract(int x){
        int n = (num*x)-(den*x);
        int d = den*x;
        reduce();
        return new Rational(n, d);
    }
    
    Rational multiply(int x){
        int n = num*x;
        int d = den*x;
        reduce();
        return new Rational(n, d);
        
    }

    Rational divide(int x){
        int n = num*x;
        int d = den*x;
        reduce();
        return new Rational(n, d);
        
    }

    private void negative(){
   
        if(den<0){
            den = -1*den;
            num = -1*num;
        }

    }





}
